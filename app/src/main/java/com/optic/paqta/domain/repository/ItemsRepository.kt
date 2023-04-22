package com.optic.paqta.domain.repository

import com.optic.paqta.domain.model.Item
import com.optic.paqta.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File


interface ItemsRepository {

    fun getItems(): Flow<Response<List<Item>>>
    suspend fun create(item: Item, file: File): Response<Boolean>
    suspend fun update(item: Item, file: File?): Response<Boolean>
    suspend fun delete(idItem: String): Response<Boolean>

}