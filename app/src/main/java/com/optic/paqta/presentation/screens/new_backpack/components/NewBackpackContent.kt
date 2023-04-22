package com.optic.paqta.presentation.screens.new_backpack.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.optic.paqta.presentation.components.DialogCapturePicture
import com.optic.paqta.presentation.screens.backpack.components.BackpackContent
import com.optic.paqta.presentation.screens.new_backpack.NewBackpackViewmodel
import com.optic.paqta.presentation.ui.theme.PaqtaTheme

@Composable
fun NewBackpackContent(
    navController: NavHostController,
    viewModel: NewBackpackViewmodel = hiltViewModel()
) {

    var dialogState = remember { mutableStateOf(false) }

    DialogCapturePicture(
        status = dialogState,
        takePhoto = {  }) {

    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "This text is a example")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewNewBackpackScreen() {
    PaqtaTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NewBackpackContent(rememberNavController())
        }
    }
}