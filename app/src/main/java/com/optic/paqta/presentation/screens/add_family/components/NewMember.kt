package com.optic.paqta.presentation.screens.add_family.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.optic.paqta.domain.model.Response
import com.optic.paqta.presentation.components.ProgressBar
import com.optic.paqta.presentation.screens.add_family.AddMemberViewModel

@Composable
fun NewMember(viewModel: AddMemberViewModel = hiltViewModel()){

    when (val response = viewModel.createMemberResponse) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            viewModel.clearForm()
            Toast.makeText(LocalContext.current, "El miembro se ha agregado", Toast.LENGTH_LONG).show()
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }
    }

}