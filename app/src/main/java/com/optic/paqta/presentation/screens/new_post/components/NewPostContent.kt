package com.optic.paqta.presentation.screens.new_post.components

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.optic.paqta.R

import com.optic.paqta.presentation.components.DefaultTextField
import com.optic.paqta.presentation.components.DialogCapturePicture
import com.optic.paqta.presentation.screens.login.LoginScreen
import com.optic.paqta.presentation.screens.new_post.NewPostViewModel
import com.optic.paqta.presentation.ui.theme.PaqtaTheme
import com.optic.paqta.presentation.ui.theme.Red500



@Composable
fun NewPostContent(viewModel: NewPostViewModel = hiltViewModel()) {

    val state = viewModel.state
    viewModel.resultingActivityHandler.handle()
    var dialogState = remember { mutableStateOf(false) }

    DialogCapturePicture(
        status = dialogState,
        takePhoto = { viewModel.takePhoto() },
        pickImage = { viewModel.pickImage() }
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()


    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .background(Red500),
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (viewModel.state.image != "") {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(170.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            model = viewModel.state.image,
                            contentDescription = "Selected image",
                            contentScale = ContentScale.Crop
                        )
                    }
                    else {
                        Image(
                            modifier = Modifier
                                .height(120.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            painter = painterResource(id = R.drawable.add_image),
                            contentDescription = "Imagen de usuario"
                        )
                        Text(
                            text = "SELECCIONA UNA IMAGEN",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

            }
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, start = 20.dp, end = 20.dp),
                value = state.name,
                onValueChange = { viewModel.onNameInput(it) },
                label = "Titulo",
                icon = Icons.Default.Face,
                errorMsg = "",
                validateField = {

                }
            )
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp, start = 20.dp, end = 20.dp),
                value = state.description,
                onValueChange = { viewModel.onDescriptionInput(it) },
                label = "Descripcion",
                icon = Icons.Default.List,
                errorMsg = "",
                validateField = {

                }
            )
            Text(
                modifier = Modifier.padding(vertical = 15.dp),
                text = "CATEGORIAS",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            viewModel.radioOptions.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .selectable(
                            selected = (option.category == state.category),
                            onClick = { viewModel.onCategoryInput(option.category) }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (option.category == state.category),
                        onClick = { viewModel.onCategoryInput(option.category) }
                    )
                    Row() {
                        Text(
                            modifier = Modifier
                                .width(105.dp)
                                .padding(12.dp),
                            text = option.category
                        )
                        Image(
                            modifier = Modifier
                                .height(50.dp)
                                .padding(8.dp),
                            painter = painterResource(id = option.image),
                            contentDescription = ""
                        )
                    }
                }
            }
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultNewPostContent() {
    PaqtaTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NewPostContent()
        }
    }
}