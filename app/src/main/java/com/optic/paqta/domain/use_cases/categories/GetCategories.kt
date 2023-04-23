package com.optic.paqta.domain.use_cases.categories

import com.optic.paqta.domain.repository.CategoriesRepository
import javax.inject.Inject

class GetCategories @Inject constructor(private val repository: CategoriesRepository){

    operator fun invoke() = repository.getCategories()

}