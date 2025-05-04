package com.example.torchlight

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.torchlight.ui.composables.ToggleButton
import com.example.torchlight.ui.theme.Roboto
import com.example.torchlight.ui.utilities.toggleFlashlight

@Composable
fun TorchLight(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var isOn by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .width(412.dp)
            .height(915.dp)
            .background(color = Color(0xFFF3F3F3))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .width(142.dp)
                .height(118.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Flashlight",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.W700,
                    color = Color(0xFF49C128),
                )
            )

            ToggleButton(
                initialState = false,
                onToggle = { on ->
                    isOn = on
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        toggleFlashlight(context, on)
                    }
                }
            )
        }
    }
}
