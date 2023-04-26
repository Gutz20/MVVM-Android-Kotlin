package com.optic.paqta.presentation.screens.my_croquis.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.paqta.domain.model.Response
import com.optic.paqta.presentation.components.ProgressBar
import com.optic.paqta.presentation.screens.my_croquis.MyCroquisViewModel

@Composable
fun GetCroquisByIdUser(navController: NavHostController, viewModel: MyCroquisViewModel = hiltViewModel()) {

    when(val response = viewModel.pointsResponse) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            MyCroquisContent(navController = navController, points = response.data)
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }

        else -> {}
    }

}