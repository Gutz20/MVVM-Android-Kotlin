package com.optic.paqta.domain.use_cases.backpacks

import com.optic.paqta.domain.repository.BackpacksRepository
import com.optic.paqta.domain.repository.PostsRepository
import javax.inject.Inject

class AddItemBackpack @Inject constructor(private val repository: BackpacksRepository){

    suspend operator fun invoke(idPost: String, idUser: String) = repository.addItem(idPost, idUser)

}