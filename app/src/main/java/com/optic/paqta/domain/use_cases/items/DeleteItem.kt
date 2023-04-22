package com.optic.paqta.domain.use_cases.items

import com.optic.paqta.domain.model.Post
import com.optic.paqta.domain.repository.ItemsRepository
import javax.inject.Inject

class DeleteItem @Inject constructor(private val repository: ItemsRepository){

    suspend operator fun invoke(idItem: String) = repository.delete(idItem)

}