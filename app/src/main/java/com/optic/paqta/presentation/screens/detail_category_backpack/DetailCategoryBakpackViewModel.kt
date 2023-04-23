package com.optic.paqta.presentation.screens.detail_category_backpack

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.optic.paqta.domain.model.Category
import com.optic.paqta.domain.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailCategoryBakpackViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val data = savedStateHandle.get<String>("category")
    val category = Category.fromJson(data!!)

}