package com.optic.paqta.data.repository

import android.content.ClipData
import android.net.Uri
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.optic.paqta.core.Constants.ITEMS
import com.optic.paqta.domain.model.Item
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.repository.ItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class ItemsRepositoryImpl @Inject constructor(
    @Named(ITEMS) private val itemsRef: CollectionReference,
    @Named(ITEMS) private val storageItemsRef: StorageReference,
) : ItemsRepository {

    override fun getItems(): Flow<Response<List<Item>>> = callbackFlow {
        val snapshotListener = itemsRef.addSnapshotListener { snapshot, e ->
            GlobalScope.launch(Dispatchers.IO) {
                val itemsResponse = if (snapshot != null) {
                    val items = snapshot.toObjects(Item::class.java)

                    snapshot.documents.forEachIndexed { index, document ->
                        items[index].id = document.id
                    }

                    Response.Success(items)
                } else {
                    Response.Failure(e)
                }
                trySend(itemsResponse)
            }
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override suspend fun create(item: Item, file: File): Response<Boolean> {
        return try {
//            IMAGE
            val fromFile = Uri.fromFile(file)
            val ref = storageItemsRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()

            // DATA
            item.image = url.toString()
            itemsRef.add(item).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun update(item: Item, file: File?): Response<Boolean> {
        return try {
            // IMAGE
            if (file != null) {
                val fromFile = Uri.fromFile(file)
                val ref = storageItemsRef.child(file.name)
                val uploadTask = ref.putFile(fromFile).await()
                val url = ref.downloadUrl.await()
                item.image = url.toString()
            }
            val map: MutableMap<String, Any> = HashMap()
            map["name"] = item.name
            map["description"] = item.description
            map["image"] = item.image
            map["category"] = item.category
            // DATA
            itemsRef.document(item.id).update(map).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun delete(idItem: String): Response<Boolean> {
        return try {
            itemsRef.document(idItem).delete().await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

}