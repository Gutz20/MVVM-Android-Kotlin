package com.optic.paqta.presentation.screens.my_croquis

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.components.DefaultTopBar
import com.optic.paqta.presentation.navigation.DetailsScreen
import com.optic.paqta.presentation.screens.my_croquis.components.GetCroquisByIdUser
import com.optic.paqta.presentation.screens.my_croquis.components.MyCroquisContent

@Composable
fun MyCroquisScren (navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Croquis Familiar",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            GetCroquisByIdUser(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 50.dp),
                onClick = { navController.navigate(DetailsScreen.NewDataCroquis.route) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    )
}