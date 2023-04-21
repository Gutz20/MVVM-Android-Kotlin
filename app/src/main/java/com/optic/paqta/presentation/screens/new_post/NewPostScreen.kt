package com.optic.paqta.presentation.screens.new_post

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.screens.new_post.components.NewPost
import com.optic.paqta.presentation.screens.new_post.components.NewPostContent
import com.optic.paqta.presentation.components.DefaultButton
import com.optic.paqta.presentation.components.DefaultTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewPostScreen(navController: NavHostController, viewModel: NewPostViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            DefaultTopBar (
                title = "Nuevo Post",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            NewPostContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "PUBLICAR",
                onClick = { viewModel.onNewPost() }
            )
        }
    )
    NewPost()
}

