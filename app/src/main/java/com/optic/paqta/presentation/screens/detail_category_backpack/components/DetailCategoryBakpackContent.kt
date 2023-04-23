package com.optic.paqta.presentation.screens.detail_category_backpack.components

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import com.optic.paqta.presentation.screens.detail_category_backpack.DetailCategoryBakpackViewModel
import com.optic.paqta.presentation.screens.detail_post.DetailPostViewModel
import com.optic.paqta.presentation.ui.theme.PaqtaTheme
import com.optic.paqta.presentation.ui.theme.Red500

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailCategoryBakpackContent(
    navController: NavHostController,
    viewModel: DetailCategoryBakpackViewModel = hiltViewModel()
) {

    val checkedState = remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                model = viewModel.category.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            IconButton(onClick = { navController?.popBackStack() }) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp, horizontal = 15.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(55.dp)
                        .clip(CircleShape),
                    model = viewModel.category.image ?: "",
//                    painter = painterResource(id = R.drawable.halo),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                )
                Column(modifier = Modifier.padding(top = 7.dp, start = 20.dp)) {
                    Text(
                        text = viewModel.category.name ?: "",
                        fontSize = 13.sp
                    )
                    Text(
                        text = viewModel.category.name ?: "",
                        fontSize = 11.sp
                    )
                }

            }
        }

        Text(
            modifier = Modifier.padding(start = 20.dp, bottom = 15.dp),
            text = viewModel.category.name,
            fontSize = 20.sp,
            color = Red500,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 100.dp),
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(200.dp),
                model = viewModel.category.imagenDeReferencia,
                contentDescription = "",
            )
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
            text = viewModel.category.description,
            fontSize = 14.sp
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
            ) {
                items(
                   items = viewModel.category.items
                ) { item ->
                    Log.d("ptoCategory", "Que me traes: ${viewModel.category.items}")
                    Log.d("pto", "Que me traesto: $item")
                    ListItem(
                        text = { Text(item) },
                        icon = {
                            Checkbox(
                                checked = checkedState.value,
                                onCheckedChange = { checkedState.value = it }
                            )
                        },
                        modifier = Modifier.clickable {}
                    )
                }
            }
        }
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
            DetailCategoryBakpackContent(rememberNavController())
        }
    }
}