package com.optic.paqta.domain.repository

import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.model.User
import kotlinx.coroutines.flow.Flow
import java.io.File

interface UsersRepository {

    suspend fun create(user: User): Response<Boolean>
    suspend fun update(user: User): Response<Boolean>
    suspend fun saveImage(file: File): Response<String>
    fun getUserById(id: String): Flow<User>

    suspend fun addMember(idUser: String, datos: ArrayList<Member>): Response<Boolean>

}