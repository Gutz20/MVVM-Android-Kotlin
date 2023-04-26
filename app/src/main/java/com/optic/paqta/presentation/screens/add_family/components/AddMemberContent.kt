package com.optic.paqta.presentation.screens.add_family.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.optic.paqta.R
import com.optic.paqta.presentation.components.DefaultButton
import com.optic.paqta.presentation.components.DefaultTextField
import com.optic.paqta.presentation.components.DialogCapturePicture
import com.optic.paqta.presentation.screens.add_family.AddMemberViewModel
import com.optic.paqta.presentation.screens.signup.SignupViewModel

@Composable
fun AddMemberContent(viewModel: AddMemberViewModel = hiltViewModel()) {

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
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
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
                    contentDescription = "Imagen"
                )
                Text(
                    text = "SELECCIONA UNA IMAGEN",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                modifier = Modifier
                    .padding(
                        top = 40.dp,
                        bottom = 0.dp,
                        start = 0.dp,
                        end = 0.dp
                    ),
                text = "TIENES ALGUN FAMILIAR",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Por favor ingresa sus datos",
                fontSize = 12.sp,
                color = Color.Gray
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = state.name,
                onValueChange = { viewModel.onNameInput(it) },
                label = "Nombre del familiar",
                icon = Icons.Default.Face,
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value = state.lastName,
                onValueChange = { viewModel.onLastNameInput(it) },
                label = "Apellidos",
                icon = Icons.Default.Email,
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value = state.phone,
                onValueChange = { viewModel.onPhoneInput(it) },
                label = "Telefono",
                icon = Icons.Default.Phone,
                keyboardType = KeyboardType.Phone,
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value = state.movilityDifficulty,
                onValueChange = { viewModel.onMovilityDifficultyInput(it) },
                label = "¿Tiene alguna dificultad?",
                icon = Icons.Default.Person,
                keyboardType = KeyboardType.Text,
            )
        }
    }
}


