package com.optic.paqta.presentation.screens.new_backpack

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.components.DefaultButton
import com.optic.paqta.presentation.components.DefaultTopBar
import com.optic.paqta.presentation.screens.new_backpack.components.NewBackpack
import com.optic.paqta.presentation.screens.new_backpack.components.NewBackpackContent
import com.optic.paqta.presentation.screens.new_post.components.NewPost
import com.optic.paqta.presentation.screens.new_post.components.NewPostContent

@Composable
fun NewBackpackScreen(navController: NavHostController, viewModel: NewBackpackViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
             DefaultTopBar(
                 title = "Nuevo Backpack",
                 upAvailable = true,
                 navController = navController
             )
        },
        content = {
            NewBackpackContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "PUBLICAR",
                onClick = { viewModel.onNewBackpack() }
            )
        }
    )
    NewBackpack()

}