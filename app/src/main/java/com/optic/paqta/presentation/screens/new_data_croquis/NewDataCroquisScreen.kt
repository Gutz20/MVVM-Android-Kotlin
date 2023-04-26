package com.optic.paqta.presentation.screens.new_data_croquis

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.components.DefaultButton
import com.optic.paqta.presentation.components.DefaultTopBar
import com.optic.paqta.presentation.screens.new_data_croquis.components.NewDataCroquis
import com.optic.paqta.presentation.screens.new_data_croquis.components.NewDataCroquisContent
import com.optic.paqta.presentation.screens.new_post.components.NewPost
import com.optic.paqta.presentation.screens.new_post.components.NewPostContent

@Composable
fun NewDataCroquisScreen(navController: NavHostController, viewModel: NewDataCroquisViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
             DefaultTopBar(
                 title = "Nueva Zona de peligro",
                 upAvailable = true,
                 navController = navController
             )
        },
        content = {
            NewDataCroquisContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "AÑADIR",
                onClick = { viewModel.onNewPointDanger() }
            )
        }
    )
    NewDataCroquis()
}