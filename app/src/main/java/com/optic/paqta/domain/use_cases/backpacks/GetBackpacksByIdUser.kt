package com.optic.paqta.domain.use_cases.backpacks

import com.optic.paqta.domain.repository.BackpacksRepository
import com.optic.paqta.domain.repository.PostsRepository
import javax.inject.Inject

class GetBackpacksByIdUser @Inject constructor(private val repository: BackpacksRepository) {

    operator fun invoke(idUser: String) = repository.getBackpacksByUserId(idUser)

}