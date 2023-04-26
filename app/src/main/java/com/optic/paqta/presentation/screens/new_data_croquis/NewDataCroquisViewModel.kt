package com.optic.paqta.presentation.screens.new_data_croquis

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.paqta.R
import com.optic.paqta.domain.model.PointDanger

import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.use_cases.auth.AuthUseCases
import com.optic.paqta.domain.use_cases.points.PointsUseCases
import com.optic.paqta.presentation.utils.ComposeFileProvider
import com.optic.paqta.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class NewDataCroquisViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val pointsDangersUseCases: PointsUseCases,
    private val authUseCases: AuthUseCases,
): ViewModel() {

    var state by mutableStateOf(NewDataCroquisState())

    // FILE
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    // RESPONSE
    var createDataCroquisResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    //USER SESSION
    val currentUser = authUseCases.getCurrentUser()

    val radioOptions = listOf(
        CategoryRadioButton("ZONA DE ALTO PELIGRO ", R.drawable.baseline_dangerous_24),
        CategoryRadioButton("ZONA DE ALTO RIESGO", R.drawable.outline_warning_amber_24),
        CategoryRadioButton("ZONA SEGURA", R.drawable.baseline_security_24),
    )

    fun createPointDanger(pointDanger: PointDanger) = viewModelScope.launch {
        createDataCroquisResponse = Response.Loading
        val result = pointsDangersUseCases.createPointDanger(pointDanger)
        createDataCroquisResponse = result
    }

    fun onNewPointDanger() {
        val pointDanger = PointDanger(
            description = state.description,
            category = state.category,
            idUser = currentUser?.uid ?: ""
        )
        createPointDanger(pointDanger)
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
            category = "",
            description = "",
        )
        createDataCroquisResponse = null
    }

    fun onCategoryInput(category: String) {
        state = state.copy(category = category)
    }

    fun onDescriptionInput(description: String) {
        state = state.copy(description = description)
    }
}

data class CategoryRadioButton(
    var category: String,
    var image: Int
)