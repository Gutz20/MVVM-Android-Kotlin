package com.optic.paqta.domain.use_cases.backpacks

import com.optic.paqta.domain.model.Backpack
import com.optic.paqta.domain.model.Post
import com.optic.paqta.domain.repository.BackpacksRepository
import com.optic.paqta.domain.repository.PostsRepository
import java.io.File
import javax.inject.Inject

class UpdateBackpack @Inject constructor(private val repository: BackpacksRepository){

    suspend operator fun invoke(backpack: Backpack, file: File?) = repository.update(backpack, file)

}