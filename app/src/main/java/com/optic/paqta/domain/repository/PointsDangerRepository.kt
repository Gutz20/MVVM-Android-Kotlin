package com.optic.paqta.domain.repository

import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.model.PointDanger
import com.optic.paqta.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PointsDangerRepository {

    fun getPointsByUserId(idUser: String): Flow<Response<List<PointDanger>>>

    suspend fun create(pointDanger: PointDanger): Response<Boolean>

    suspend fun update(pointDanger: PointDanger): Response<Boolean>

    suspend fun saveImage(file: File): Response<String>

}