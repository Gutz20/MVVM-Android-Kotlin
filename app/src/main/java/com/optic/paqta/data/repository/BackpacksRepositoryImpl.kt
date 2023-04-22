package com.optic.paqta.data.repository

import com.google.firebase.firestore.CollectionReference
import com.optic.paqta.core.Constants.BACKPACKS
import com.optic.paqta.domain.model.Backpack
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.repository.BackpacksRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class BackpacksRepositoryImpl @Inject constructor(
    @Named(BACKPACKS) private val backpacksRef: CollectionReference,
): BackpacksRepository{

    override suspend fun create(backpack: Backpack): Response<Boolean> {
        return try {
            backpacksRef.add(backpack).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun update(backpack: Backpack): Response<Boolean> {
        return try {
            val map: MutableMap<String, Any> = HashMap()
            map[""]
            backpacksRef.document(backpack.id).update(map).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }


}