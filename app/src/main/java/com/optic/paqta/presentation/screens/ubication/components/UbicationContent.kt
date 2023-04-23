package com.optic.paqta.presentation.screens.ubication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.optic.paqta.presentation.components.DefaultButton
import com.optic.paqta.presentation.ui.theme.PaqtaTheme

@Composable
fun UbicationContent(
//    navController: NavHostController,
//    viewModel: UbicationViewModel = hiltViewModel()
) {


    Column() {
        DefaultButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            text = "START TRACKING",
            onClick = {

            }
        )

        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "STOP TRACKING",
            onClick = {  }
        )

        Text(text = "status")

        Row() {
            Text(text = "latitud")
            Text(text = "longitud")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewUbicationScreen() {
    PaqtaTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            UbicationContent()
        }
    }
}
