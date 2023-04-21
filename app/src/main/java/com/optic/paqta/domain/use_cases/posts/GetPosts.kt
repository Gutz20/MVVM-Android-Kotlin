package com.optic.paqta.domain.use_cases.posts

import com.optic.paqta.domain.repository.PostsRepository
import javax.inject.Inject

class GetPosts @Inject constructor(private val repository: PostsRepository) {

    operator fun invoke() = repository.getPosts()

}