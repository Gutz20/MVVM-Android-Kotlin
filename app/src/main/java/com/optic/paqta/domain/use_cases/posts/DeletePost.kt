package com.optic.paqta.domain.use_cases.posts

import com.optic.paqta.domain.model.Post
import com.optic.paqta.domain.repository.PostsRepository
import java.io.File
import javax.inject.Inject

class DeletePost @Inject constructor(private val repository: PostsRepository){

    suspend operator fun invoke(idPost: String) = repository.delete(idPost)

}