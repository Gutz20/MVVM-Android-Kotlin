package com.optic.paqta.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.optic.paqta.presentation.ui.theme.Red500
import com.optic.paqta.presentation.ui.theme.Yellow100

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = Yellow100,
    icon: ImageVector = Icons.Default.ArrowForward,
    enabled: Boolean = true,
    colortexto: Color = Color.Black,
    coloricon: Color = Color.Black

) {

    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        enabled = enabled
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = coloricon
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            color = colortexto,
            text = text
        )

    }

}