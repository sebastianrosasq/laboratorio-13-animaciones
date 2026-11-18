package com.example.lab13

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable fun ColorAnimado() {
    var verde by remember { mutableStateOf(false) }
    val color by animateColorAsState(targetValue = if (verde) Color(0xFF25A86D) else Color(0xFF316AD8), animationSpec = tween(1000), label = "color del cuadro")
    Column(Modifier.fillMaxWidth().padding(top = 24.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text("2  Cambio de color", style = MaterialTheme.typography.headlineSmall)
        Text("Transición entre azul y verde con tween de 1 segundo")
        Button(onClick = { verde = !verde }) { Text("Cambiar color") }
        Box(Modifier.size(150.dp).background(color))
    }
}
