package com.optic.paqta.presentation.screens.detail_backpack.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.optic.paqta.R
import com.optic.paqta.presentation.screens.detail_backpack.DetailBackpackViewModel
import com.optic.paqta.presentation.screens.detail_post.DetailPostViewModel
import com.optic.paqta.presentation.ui.theme.PaqtaTheme
import com.optic.paqta.presentation.ui.theme.Red500

@Composable
fun DetailBackpackContent(navController: NavHostController,  viewModel: DetailBackpackViewModel = hiltViewModel()) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
    ) {

        Box() {

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                model = viewModel.backpack.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            IconButton(onClick = { navController?.popBackStack() }) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "" ,
                    tint = Color.White
                )
            }

        }

        if (!viewModel.backpack.user?.username.isNullOrBlank()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 15.dp)
                ,
                elevation = 4.dp,
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(55.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.comunicacion),
                        contentDescription = "Comunicacion",
                        contentScale = ContentScale.Crop,
                    )
                    Column(modifier = Modifier.padding(top = 7.dp, start = 20.dp)) {
                        Text(
                            text = viewModel.backpack.user?.username ?: "",
                            fontSize = 13.sp
                        )
                        Text(
                            text = viewModel.backpack.user?.email ?: "",
                            fontSize = 11.sp
                        )
                    }

                }
            }
        }
        else {
            Spacer(modifier = Modifier.height(15.dp))
        }
        Text(
            modifier = Modifier.padding(start = 20.dp, bottom = 15.dp),
            text = viewModel.backpack.name,
            fontSize = 20.sp,
            color = Red500,
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = Modifier.padding(start = 13.dp, bottom = 15.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 7.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
//                Image(
//                    modifier = Modifier.size(25.dp),
//                    painter = painterResource(
//                        id = if (viewModel.backpack.category == "PC") R.drawable.icon_pc
//                            else if (viewModel.backpack.category == "XBOX") R.drawable.icon_xbox
//                            else if (viewModel.backpack.category == "PS4") R.drawable.icon_ps4
//                            else if (viewModel.backpack.category == "NINTENDO") R.drawable.icon_nintendo
//                            else  R.drawable.icon_mobile
//                    ),
//                    contentDescription = ""
//                )
                Spacer(modifier = Modifier.width(7.dp))
//                Text(
//                    text = viewModel.backpack.category,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 17.sp
//                )
            }
        }
        Divider(
            modifier = Modifier.padding(end = 20.dp, top = 10.dp, bottom = 10.dp),
            startIndent = 20.dp,
            thickness = 1.dp,
            color = Color.DarkGray
        )
        Text(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            text = "DESCRIPCION CATEGORIA",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        Text(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
            text = viewModel.backpack.description,
            fontSize = 14.sp
        )

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Previews() {
    PaqtaTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            DetailBackpackContent(rememberNavController())
        }
    }
}