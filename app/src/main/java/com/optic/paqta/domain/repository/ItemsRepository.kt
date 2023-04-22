package com.optic.paqta.domain.repository

import com.optic.paqta.domain.model.Item
import com.optic.paqta.domain.model.Response
import java.io.File

interface ItemsRepository {

    suspend fun create(item: Item, file: File): Response<Boolean>
    suspend fun update(item: Item): Response<Boolean>
    suspend fun delete(idItem: String): Response<Boolean>

}