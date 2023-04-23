package com.optic.paqta.domain.repository

import com.optic.paqta.domain.model.Category
import com.optic.paqta.domain.model.Response
import kotlinx.coroutines.flow.Flow


interface CategoriesRepository {

    fun getCategories(): Flow<Response<List<Category>>>

}