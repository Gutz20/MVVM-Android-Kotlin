package com.optic.paqta.presentation.screens.add_family

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.optic.paqta.presentation.components.DefaultButton
import com.optic.paqta.presentation.components.DefaultTopBar
import com.optic.paqta.presentation.screens.add_family.components.AddMemberContent
import com.optic.paqta.presentation.screens.add_family.components.NewMember
import com.optic.paqta.presentation.screens.profile_update.components.SaveImage
import com.optic.paqta.presentation.ui.theme.PaqtaTheme

@Composable
fun AddFamilyScreen(navController: NavHostController, viewModel: AddMemberViewModel = hiltViewModel()) {
    
    Scaffold(
        topBar = {
             DefaultTopBar(
                 title = "Nuevo miembro de familia",
                 upAvailable = true,
                 navController = navController
             )
        },
        content = {
            AddMemberContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "AÑADIR",
                onClick = { viewModel.onNewMember() }
            )
        }
    )
    NewMember()
}