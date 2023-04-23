package com.optic.paqta.presentation.screens.my_backpack.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.paqta.domain.model.Response
import com.optic.paqta.presentation.components.ProgressBar
import com.optic.paqta.presentation.screens.my_backpack.MyBackpacksViewModel
import com.optic.paqta.presentation.screens.my_posts.MyPostsViewModel

@Composable
fun GetBackpacksByIdUser(navController: NavHostController, viewModel: MyBackpacksViewModel = hiltViewModel()) {

    when(val response = viewModel.backpacksResponse) {
        // MOSTRAR QUE SE ESTA REALIZANDO LA PETICION Y TODAVIA ESTA EN PROCESO
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            MyBackpacksContent(navController = navController, backpacks = response.data)
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconido", Toast.LENGTH_LONG).show()
        }

    }

}