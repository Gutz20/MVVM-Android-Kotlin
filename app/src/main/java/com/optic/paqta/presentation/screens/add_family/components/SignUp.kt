package com.optic.paqta.presentation.screens.add_family.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.paqta.domain.model.Response
import com.optic.paqta.presentation.components.ProgressBar
import com.optic.paqta.presentation.navigation.AuthScreen
import com.optic.paqta.presentation.navigation.Graph
import com.optic.paqta.presentation.screens.signup.SignupViewModel

@Composable
fun SignUp(navController: NavHostController, viewModel: SignupViewModel = hiltViewModel()) {
    when(val signupResponse = viewModel.signupResponse) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            LaunchedEffect(Unit) {
                viewModel.createUser()
                navController.popBackStack(Graph.AUTHENTICATION, true)
                navController.navigate(route = Graph.HOME)
            }
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, signupResponse.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }
    }
}