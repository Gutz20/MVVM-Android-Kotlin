package com.optic.paqta.presentation.screens.ubication

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.screens.ubication.components.UbicationContent

@Composable
fun UbicationScreen(navController: NavHostController, viewModel: UbicationViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {},
        content = {
            UbicationContent()
        },
        bottomBar = {}
    )
}

