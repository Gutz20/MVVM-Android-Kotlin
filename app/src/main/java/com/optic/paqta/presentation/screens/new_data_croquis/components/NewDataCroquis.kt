package com.optic.paqta.presentation.screens.new_data_croquis.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.optic.paqta.domain.model.Response
import com.optic.paqta.presentation.components.ProgressBar
import com.optic.paqta.presentation.screens.new_data_croquis.NewDataCroquisViewModel
import com.optic.paqta.presentation.screens.new_post.NewPostViewModel

@Composable
fun NewDataCroquis(viewModel: NewDataCroquisViewModel = hiltViewModel()) {

    when(val response = viewModel.createDataCroquisResponse) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            viewModel.clearForm()
            Toast.makeText(LocalContext.current, "Se añadio el campo correctamente", Toast.LENGTH_LONG).show()
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }

        else -> {}
    }

}