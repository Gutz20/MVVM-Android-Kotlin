package com.optic.paqta.presentation.screens.backpack.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.optic.paqta.R
import com.optic.paqta.presentation.ui.theme.PaqtaTheme

@Composable
fun ItemBackpackCard(
    navController: NavHostController,
//    viewModel
) {
    Card(
        modifier = Modifier
            .padding(top = 0.dp, bottom = 15.dp)
            .clickable {

            },
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        contentColor = Color.White
    ) {
        Column() {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.backpack),
                contentDescription = ""
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                text = "Nombre del item",
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = "Categoria",
                color = Color.Gray
            )
            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = "Cantidad del item",
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = "Sugerencia",
                fontSize = 13.sp,
                color = Color.Gray
            )
            Row(
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 15.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {

                        },
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = ""
                )

                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "Completo (?)",
                    fontSize = 17.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewItemBackpackCardScreen() {
    PaqtaTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ItemBackpackCard(rememberNavController())
        }
    }
}