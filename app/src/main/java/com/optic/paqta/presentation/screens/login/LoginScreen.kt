package com.optic.paqta.presentation.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.optic.paqta.presentation.screens.login.components.Login
import com.optic.paqta.presentation.screens.login.components.LoginBottomBar
import com.optic.paqta.presentation.screens.login.components.LoginContent
import com.optic.paqta.presentation.ui.theme.PaqtaTheme

@Composable
fun LoginScreen(navController: NavHostController) {

    Scaffold(
        topBar = {},
        content = {
            LoginContent(navController)
        },
        bottomBar = {
            LoginBottomBar(navController)
        }
    )
    // MANEJAR EL ESTADO DE LA PETICION DE LOGIN
    Login(navController = navController)

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    PaqtaTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LoginScreen(rememberNavController())
        }
    }
}