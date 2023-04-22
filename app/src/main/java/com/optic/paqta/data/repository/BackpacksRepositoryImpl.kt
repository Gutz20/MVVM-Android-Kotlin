package com.optic.paqta.data.repository

import android.net.Uri
import android.util.Log
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FieldValue
import com.google.firebase.storage.StorageReference
import com.optic.paqta.core.Constants
import com.optic.paqta.core.Constants.BACKPACKS
import com.optic.paqta.core.Constants.USERS
import com.optic.paqta.domain.model.Backpack
import com.optic.paqta.domain.model.Post
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.model.User
import com.optic.paqta.domain.repository.BackpacksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class BackpacksRepositoryImpl @Inject constructor(
    @Named(BACKPACKS) private val backpacksRef: CollectionReference,
    @Named(USERS) private val usersRef: CollectionReference,
    @Named(BACKPACKS) private val storageBackpacksRef: StorageReference,
) : BackpacksRepository {
    override fun getBackpacks(): Flow<Response<List<Backpack>>> = callbackFlow {
        val snapshotListener = backpacksRef.addSnapshotListener { snapshot, e ->

            GlobalScope.launch(Dispatchers.IO) {
                val backpacksResponse = if (snapshot != null) {
                    val backpacks = snapshot.toObjects(Backpack::class.java)

                    snapshot.documents.forEachIndexed { index, document ->
                        backpacks[index].id = document.id
                    }

                    val idUserArray = ArrayList<String>()

                    backpacks.forEach { backpack ->
                        idUserArray.add(backpack.idUser)
                    }

                    val idUserList = idUserArray.toSet().toList() // ELEMENTOS SIN REPETIR

                    idUserList.map { id ->
                        async {
                            val user =
                                usersRef.document(id).get().await().toObject(User::class.java)!!
                            backpacks.forEach { backpack ->
                                if (backpack.idUser == id) {
                                    backpack.user = user
                                }
                            }
                        }
                    }.forEach {
                        it.await()
                    }

                    Response.Success(backpacks)
                } else {
                    Response.Failure(e)
                }
                trySend(backpacksResponse)
            }
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun getBackpacksByUserId(idUser: String): Flow<Response<List<Backpack>>> =
        callbackFlow {
            val snapshotListener =
                backpacksRef.whereEqualTo("idUser", idUser).addSnapshotListener { snapshot, e ->

                    val backpacksResponse = if (snapshot != null) {
                        val backpacks = snapshot.toObjects(Backpack::class.java)
                        snapshot.documents.forEachIndexed { index, document ->
                            backpacks[index].id = document.id
                        }

                        Response.Success(backpacks)
                    } else {
                        Response.Failure(e)
                    }
                    trySend(backpacksResponse)

                }
            awaitClose {
                snapshotListener.remove()
            }
        }

    override suspend fun create(backpack: Backpack, file: File): Response<Boolean> {
        return try {
            // IMAGE
            val fromFile = Uri.fromFile(file)
            val ref = storageBackpacksRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()

            // DATA
            backpack.image = url.toString()
            backpacksRef.add(backpack).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun update(backpack: Backpack, file: File?): Response<Boolean> {
        return try {
            // IMAGE
            if (file != null) {
                val fromFile = Uri.fromFile(file)
                val ref = storageBackpacksRef.child(file.name)
                val uploadTask = ref.putFile(fromFile).await()
                val url = ref.downloadUrl.await()
                backpack.image = url.toString()
            }
            val map: MutableMap<String, Any> = HashMap()
            map["name"] = backpack.name
            map["description"] = backpack.description
            map["image"] = backpack.image
            // DATA
            backpacksRef.document(backpack.id).update(map).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun delete(idBackpack: String): Response<Boolean> {
        return try {
            backpacksRef.document(idBackpack).delete().await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    //    EN DESARROLLO
    override suspend fun addItem(idBackpack: String, idUser: String): Response<Boolean> {
        return try {
            backpacksRef.document(idBackpack).update("items", FieldValue.arrayUnion(idUser)).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun deleteItem(idBackpack: String, idUser: String): Response<Boolean> {
        return try {
            backpacksRef.document(idBackpack).update("items", FieldValue.arrayRemove(idUser))
                .await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }


}