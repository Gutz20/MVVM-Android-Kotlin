package com.optic.paqta.data.repository

import android.net.Uri
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.optic.paqta.core.Constants.MEMBERS
import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.repository.MembersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class MembersRepositoryImpl @Inject constructor(
    @Named(MEMBERS) private val membersRef: CollectionReference,
    @Named(MEMBERS) private val storageMembersRef: StorageReference
): MembersRepository {
    override fun getMembersByUserId(idUser: String): Flow<Response<List<Member>>> {
        TODO("Not yet implemented")
    }

    override suspend fun create(member: Member, file: File): Response<Boolean> {
        return try {
            // IMAGE
            val fromFile = Uri.fromFile(file)
            val ref = storageMembersRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()

            member.image = url.toString()
            membersRef.add(member).await()
           Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun update(member: Member): Response<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun saveImage(file: File): Response<String> {
        return try {
            val fromFile = Uri.fromFile(file)
            val ref = storageMembersRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()
            return Response.Success(url.toString())
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun getUserById(id: String): Flow<Member> {
        TODO("Not yet implemented")
    }

}