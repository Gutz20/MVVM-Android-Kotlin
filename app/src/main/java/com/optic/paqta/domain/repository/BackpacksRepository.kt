package com.optic.paqta.domain.repository

import com.optic.paqta.domain.model.Backpack
import com.optic.paqta.domain.model.Response

interface BackpacksRepository {

    suspend fun create(backpack: Backpack): Response<Boolean>
    suspend fun update(backpack: Backpack): Response<Boolean>

}