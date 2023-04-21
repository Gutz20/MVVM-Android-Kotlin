package com.optic.paqta.presentation.screens.posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.paqta.domain.model.Response
import com.optic.paqta.presentation.components.ProgressBar
import com.optic.paqta.presentation.screens.posts.PostsViewModel

@Composable
fun GetPosts(navController: NavHostController, viewModel: PostsViewModel = hiltViewModel()) {
    when (val response = viewModel.postsResponse) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            PostsContent(navController, posts = response.data)
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current,response.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG ).show()
        }

        else -> {}
    }

}