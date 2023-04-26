package com.optic.paqta.domain.repository

import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface MembersRepository {

    suspend fun create(member: Member, file: File): Response<Boolean>

    suspend fun update(member: Member): Response<Boolean>

    suspend fun saveImage(file: File): Response<String>

    fun getUserById(id: String): Flow<Member>

}