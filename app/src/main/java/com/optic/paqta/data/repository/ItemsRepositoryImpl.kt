package com.optic.paqta.data.repository

import android.content.ClipData
import android.net.Uri
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.optic.paqta.core.Constants.ITEMS
import com.optic.paqta.domain.model.Item
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.repository.ItemsRepository
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class ItemsRepositoryImpl @Inject constructor(
    @Named(ITEMS) private val itemsRef: CollectionReference,
    @Named(ITEMS) private val storageItemsRef: StorageReference,
): ItemsRepository{

    override suspend fun create(item: Item, file: File): Response<Boolean> {
//        IMAGE
//        val fromFile = Uri.fromFile(file)
//        val ref = storageItemsRef.child(file.name)
//        val uploadTask = ref.putFile(fromFile).await()
//        val url = ref.downloadUrl.await()
        TODO("Not yet implemented")

    }

    override suspend fun update(item: Item): Response<Boolean> {
        TODO("Not yet implemented")
    }


    override suspend fun delete(idItem: String): Response<Boolean> {
        TODO("Not yet implemented")
    }


}