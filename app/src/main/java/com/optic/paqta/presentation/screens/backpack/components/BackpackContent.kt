package com.optic.paqta.presentation.screens.backpack.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.optic.paqta.R
import com.optic.paqta.presentation.screens.backpack.BackpackViewModel
import com.optic.paqta.presentation.ui.theme.PaqtaTheme
import androidx.compose.foundation.lazy.items

@Composable
fun BackpackContent(
    navController: NavHostController,
    viewModel: BackpackViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.backpack_color),
            contentDescription = "Mochila",
        )

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
//            items(
//                items = backp
//            ) {
//                ItemBackpackCard(navController, )
//            }

        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBackpackScreen() {
    PaqtaTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            BackpackContent(rememberNavController())
        }
    }
}