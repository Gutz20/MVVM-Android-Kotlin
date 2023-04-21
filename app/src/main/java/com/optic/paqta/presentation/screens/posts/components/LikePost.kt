package com.optic.paqta.presentation.screens.posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.optic.paqta.domain.model.Response
import com.optic.paqta.presentation.components.ProgressBar
import com.optic.paqta.presentation.screens.posts.PostsViewModel

@Composable
fun LikePost(viewModel: PostsViewModel = hiltViewModel()) {
    when (val response = viewModel.likeResponse) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {

        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current,response.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG ).show()
        }

        else -> {}
    }

}