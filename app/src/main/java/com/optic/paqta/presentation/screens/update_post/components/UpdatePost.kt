package com.optic.paqta.presentation.screens.update_post.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.optic.paqta.domain.model.Response
import com.optic.paqta.presentation.components.ProgressBar
import com.optic.paqta.presentation.screens.update_post.UpdatePostViewModel

@Composable
fun UpdatePost(viewModel: UpdatePostViewModel = hiltViewModel()) {

    when (val response = viewModel.updatePostResponse) {
//            Mostrar que se esta realizando la peticion
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            viewModel.clearForm()
            Toast.makeText(LocalContext.current,"La publicacion se ha actualizado correctamente", Toast.LENGTH_LONG ).show()
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current,response.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG ).show()
        }

        else -> {}
    }

}