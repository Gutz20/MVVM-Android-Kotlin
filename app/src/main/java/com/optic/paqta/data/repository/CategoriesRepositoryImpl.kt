package com.optic.paqta.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.optic.paqta.core.Constants.CATEGORIES
import com.optic.paqta.domain.model.Category
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.repository.CategoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class CategoriesRepositoryImpl @Inject constructor(
    @Named(CATEGORIES) private val categoriesRef: CollectionReference,
    @Named(CATEGORIES) private val storageCategoriesRef: StorageReference,
) : CategoriesRepository {

    override fun getCategories(): Flow<Response<List<Category>>> = callbackFlow {
        val snapshotListener = categoriesRef.addSnapshotListener { snapshot, e ->

            GlobalScope.launch(Dispatchers.IO) {
                val categoriesResponse = if (snapshot != null) {
                    val categories = snapshot.toObjects(Category::class.java)

                    Response.Success(categories)
                } else {
                    Response.Failure(e)
                }
                trySend(categoriesResponse)
            }
        }
        awaitClose {
            snapshotListener.remove()
        }
    }


}