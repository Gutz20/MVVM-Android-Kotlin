package com.optic.paqta.presentation.screens.my_backpack

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.paqta.domain.model.Backpack
import com.optic.paqta.domain.model.Category
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.use_cases.auth.AuthUseCases
import com.optic.paqta.domain.use_cases.backpacks.BackpacksUseCases
import com.optic.paqta.domain.use_cases.categories.CategoriesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyBackpacksViewModel @Inject constructor(
    private val backpacksUseCases: BackpacksUseCases,
    private val categoriesUseCases: CategoriesUseCases,
    private val authUseCases: AuthUseCases,
) : ViewModel() {

    var backpacksResponse by mutableStateOf<Response<List<Backpack>>?>(null)
    var categoriesResponse by mutableStateOf<Response<List<Category>>?>(null)
    var deleteResponse by mutableStateOf<Response<Boolean>?>(null)
    val currentUser = authUseCases.getCurrentUser()

    init {
        getBackpacks()
        getCategories()
    }

    fun delete(idPost: String) = viewModelScope.launch {
        deleteResponse = Response.Loading
        val result = backpacksUseCases.deleteBackpack(idPost)
        deleteResponse = result
    }

    fun getBackpacks() = viewModelScope.launch {
        backpacksResponse = Response.Loading
        backpacksUseCases.getBackpacksByIdUser(currentUser?.uid ?: "").collect() { response ->
            backpacksResponse = response
        }
    }

    fun getCategories() = viewModelScope.launch {
        categoriesResponse = Response.Loading
        categoriesUseCases.getCategories().collect() { response ->
            categoriesResponse = response
        }
    }

}