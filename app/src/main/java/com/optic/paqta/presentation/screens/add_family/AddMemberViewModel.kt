package com.optic.paqta.presentation.screens.add_family

import android.content.Context
import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.optic.paqta.R
import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.model.User
import com.optic.paqta.domain.use_cases.auth.AuthUseCases
import com.optic.paqta.domain.use_cases.members.MembersUseCases
import com.optic.paqta.domain.use_cases.users.UsersUseCases
import com.optic.paqta.presentation.screens.new_post.CategoryRadioButton
import com.optic.paqta.presentation.utils.ComposeFileProvider
import com.optic.paqta.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AddMemberViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val authUseCases: AuthUseCases,
    private val membersUseCases: MembersUseCases
) : ViewModel() {

    // STATE FORM
    var state by mutableStateOf(AddMemberState())

    // FILE
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    // RESPONSE
    var createMemberResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    //USER SESSION
    val currentUser = authUseCases.getCurrentUser()

    fun createMember(member: Member) = viewModelScope.launch {
        createMemberResponse = Response.Loading
        val result = membersUseCases.create(member, file!!)
        createMemberResponse = result
    }

    fun onNewMember() {
        val member = Member(
            name = state.name,
            lastName = state.lastName,
            phone = state.phone,
            movilityDifficulty = state.movilityDifficulty,
            idUser = currentUser?.uid ?: ""
        )
        createMember(member)
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
            lastName = "",
            phone = "",
            movilityDifficulty = "",
            image = ""
        )
        createMemberResponse = null
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onLastNameInput(lastName: String) {
        state = state.copy(lastName = lastName)
    }

    fun onPhoneInput(phone: String) {
        state = state.copy(phone = phone)
    }

    fun onMovilityDifficultyInput(movility: String) {
        state = state.copy(movilityDifficulty = movility)
    }

}