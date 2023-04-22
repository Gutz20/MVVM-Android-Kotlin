package com.optic.paqta.domain.use_cases.items

import com.optic.paqta.domain.repository.ItemsRepository
import com.optic.paqta.domain.repository.PostsRepository
import javax.inject.Inject

class GetItems @Inject constructor(private val repository: ItemsRepository) {

    operator fun invoke() = repository.getItems()

}