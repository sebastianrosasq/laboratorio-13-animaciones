package com.example.lab13

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable fun Visibilidad() {
    var visible by remember { mutableStateOf(true) }
    Column(Modifier.fillMaxWidth().padding(top = 24.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text("1  Visibilidad", style = MaterialTheme.typography.headlineSmall)
        Text("El cuadro aparece y desaparece con un fundido")
        Button(onClick = { visible = !visible }) { Text(if (visible) "Ocultar cuadro" else "Mostrar cuadro") }
        AnimatedVisibility(visible = visible, enter = fadeIn(tween(700)), exit = fadeOut(tween(700))) {
            Box(Modifier.size(150.dp).background(Color(0xFF526DE3)))
        }
    }
}
