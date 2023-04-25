package com.optic.paqta.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.optic.paqta.core.Constants.MEMBERS
import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.repository.MembersRepository
import kotlinx.coroutines.flow.Flow
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class MembersRepositoryImpl @Inject constructor(
    @Named(MEMBERS) private val membersRef: CollectionReference,
    @Named(MEMBERS) private val storageMembersRef: StorageReference
): MembersRepository {

    override suspend fun create(member: Member): Response<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun update(member: Member): Response<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun saveImage(file: File): Response<String> {
        TODO("Not yet implemented")
    }

    override fun getUserById(id: String): Flow<Member> {
        TODO("Not yet implemented")
    }

}