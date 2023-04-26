package com.optic.paqta.data.repository

import android.net.Uri
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.optic.paqta.core.Constants.POINTS
import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.model.PointDanger
import com.optic.paqta.domain.model.Post
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.repository.PointsDangerRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class PointsRepositoryImpl @Inject constructor(
    @Named(POINTS) private val pointsRef: CollectionReference,
    @Named(POINTS) private val storagePointsRef: StorageReference
) : PointsDangerRepository {

    override fun getPointsByUserId(idUser: String): Flow<Response<List<PointDanger>>> =
        callbackFlow {
            val snapshotListener =
                pointsRef.whereEqualTo("idUser", idUser).addSnapshotListener { snapshot, e ->

                    val pointsReponse = if (snapshot != null) {
                        val points = snapshot.toObjects(PointDanger::class.java)
                        snapshot.documents.forEachIndexed { index, document ->
                            points[index].id = document.id
                        }

                        Response.Success(points)
                    } else {
                        Response.Failure(e)
                    }
                    trySend(pointsReponse)

                }
            awaitClose {
                snapshotListener.remove()
            }
        }

    override suspend fun create(pointDanger: PointDanger): Response<Boolean> {
        return try {
            // IMAGE
//            val fromFile = Uri.fromFile(file)
//            val ref = storageMembersRef.child(file.name)
//            val uploadTask = ref.putFile(fromFile).await()
//            val url = ref.downloadUrl.await()

//            pointDanger.image = url.toString()
            pointsRef.add(pointDanger).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun update(pointDanger: PointDanger): Response<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun saveImage(file: File): Response<String> {
        return try {
            val fromFile = Uri.fromFile(file)
            val ref = storagePointsRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()
            return Response.Success(url.toString())
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }


}