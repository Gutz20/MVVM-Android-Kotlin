package com.optic.paqta.presentation.screens.my_croquis

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.paqta.R
import com.optic.paqta.domain.model.PointDanger
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.model.User
import com.optic.paqta.domain.use_cases.auth.AuthUseCases
import com.optic.paqta.domain.use_cases.points.PointsUseCases
import com.optic.paqta.domain.use_cases.users.UsersUseCases
import com.optic.paqta.presentation.screens.new_post.CategoryRadioButton
import com.optic.paqta.presentation.utils.ComposeFileProvider
import com.optic.paqta.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MyCroquisViewModel @Inject constructor(
    @ApplicationContext public val context: Context,
    private val usersUseCases: UsersUseCases,
    private val pointsUserCases: PointsUseCases,
    private val authUseCases: AuthUseCases
) : ViewModel() {

    var state by mutableStateOf(NewCroquisState())
    var pointsResponse by mutableStateOf<Response<List<PointDanger>>?>(null)
    val currentUser = authUseCases.getCurrentUser()

    // FILE
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    init {
        getDataCroquis()
    }


    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(imageMapping = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(imageMapping = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.imageMapping)
        }
    }

    fun getDataCroquis() = viewModelScope.launch {
        pointsResponse = Response.Loading
        pointsUserCases.getPointsByIdUser(currentUser?.uid ?: "").collect() { response ->
            pointsResponse = response
        }
    }

}
