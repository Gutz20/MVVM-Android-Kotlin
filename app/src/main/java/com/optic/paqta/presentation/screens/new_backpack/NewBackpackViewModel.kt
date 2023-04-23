package com.optic.paqta.presentation.screens.new_backpack

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.paqta.R
import com.optic.paqta.domain.model.Backpack

import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.use_cases.auth.AuthUseCases
import com.optic.paqta.domain.use_cases.backpacks.BackpacksUseCases
import com.optic.paqta.presentation.utils.ComposeFileProvider
import com.optic.paqta.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class NewBackpackViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val backpacksUseCases: BackpacksUseCases,
    private val authUseCases: AuthUseCases,
): ViewModel() {

    var state by mutableStateOf(NewBackpackState())

    // FILE
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    // RESPONSE
    var createBackpackResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    //USER SESSION
    val currentUser = authUseCases.getCurrentUser()

    val radioOptions = listOf(
        CategoryRadioButton("PC ", R.drawable.icon_pc),
        CategoryRadioButton("PS4", R.drawable.icon_ps4),
        CategoryRadioButton("XBOX", R.drawable.icon_xbox),
        CategoryRadioButton("Nintend", R.drawable.icon_nintendo),
        CategoryRadioButton("Mobile", R.drawable.icon_mobile),
    )

    fun createBackpack(backpack: Backpack) = viewModelScope.launch {
        createBackpackResponse = Response.Loading
        val result = backpacksUseCases.create(backpack, file!!)
        createBackpackResponse = result
    }

    fun onNewBackpack() {
        val backpack = Backpack(
            name = state.name,
            description = state.description,
//            category = state.category,
            idUser = currentUser?.uid ?: ""
        )
        createBackpack(backpack)
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }

    fun clearForm() {
        state = state.copy(
            name ="",
            category = "",
            description = "",
            image = ""
        )
        createBackpackResponse = null
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onCategoryInput(category: String) {
        state = state.copy(category = category)
    }

    fun onDescriptionInput(description: String) {
        state = state.copy(description = description)
    }

    fun onImageInput(image: String) {
        state = state.copy(image = image)
    }

}

data class CategoryRadioButton(
    var category: String,
    var image: Int
)