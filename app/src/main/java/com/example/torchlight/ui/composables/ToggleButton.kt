package com.example.torchlight.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.torchlight.ui.theme.Roboto

@Composable
fun ToggleButton(
    modifier: Modifier = Modifier,
    initialState: Boolean = false,
    onToggle: (Boolean) -> Unit = {}
) {
    var isOn by remember { mutableStateOf(initialState) }

    Column(
        modifier = modifier
            .width(100.dp)
            .height(50.dp)
            .background(
                color = if (isOn) Color(0xFF81C784) else Color(0xFFBDBDBD),
                shape = RoundedCornerShape(3.dp)
            )
            .clickable {
                isOn = !isOn
                onToggle(isOn)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = if (isOn) "ON" else "OFF",
            modifier = Modifier
                .wrapContentWidth()
                .height(21.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = Roboto,
                fontWeight = FontWeight.W500,
                color = Color.Black
            )
        )
    }
}
