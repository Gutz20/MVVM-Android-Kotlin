package com.optic.paqta.presentation.screens.my_backpack

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
import com.optic.paqta.presentation.screens.my_backpack.components.GetBackpacksByIdUser
import com.optic.paqta.presentation.screens.my_posts.components.GetPostsByIdUser

@Composable
fun MyBackpacksScreen(navController: NavHostController) {
    
    Scaffold(
        topBar = {
                 DefaultTopBar(
                     title = "Nueva Mochila",
                 )
        },
        content = {
           GetBackpacksByIdUser(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 50.dp),
                onClick = { navController.navigate(DetailsScreen.NewBackpack.route) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ) 
    
}