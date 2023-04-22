package com.optic.paqta.domain.use_cases.items

import com.optic.paqta.domain.model.Item
import com.optic.paqta.domain.model.Post
import com.optic.paqta.domain.repository.ItemsRepository
import com.optic.paqta.domain.repository.PostsRepository
import java.io.File
import javax.inject.Inject

class UpdateItem @Inject constructor(private val repository: ItemsRepository){

    suspend operator fun invoke(item: Item, file: File?) = repository.update(item, file)

}