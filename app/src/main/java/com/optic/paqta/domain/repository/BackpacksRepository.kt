package com.optic.paqta.domain.repository

import com.optic.paqta.domain.model.Backpack
import com.optic.paqta.domain.model.Post
import com.optic.paqta.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface BackpacksRepository {

    fun getBackpacks(): Flow<Response<List<Backpack>>>
    fun getBackpacksByUserId(idUser: String): Flow<Response<List<Backpack>>>
    suspend fun create(backpack: Backpack, file: File): Response<Boolean>
    suspend fun update(backpack: Backpack, file: File?): Response<Boolean>
    suspend fun delete(idBackpack: String): Response<Boolean>
    suspend fun addItem(idBackpack: String, idUser: String): Response<Boolean>
    suspend fun deleteItem(idBackpack: String, idUser: String): Response<Boolean>
}