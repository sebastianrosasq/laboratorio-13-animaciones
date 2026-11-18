package com.example.lab13

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable fun ContenidoAnimado() {
    var estado by remember { mutableIntStateOf(0) }
    val mensajes = listOf("Cargando información...", "Contenido disponible", "Ocurrió un error")
    Column(Modifier.fillMaxWidth().padding(top = 24.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text("4  Cambio de contenido", style = MaterialTheme.typography.headlineSmall)
        Text("Selecciona un estado para ver la transición")
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf("Cargando", "Contenido", "Error").forEachIndexed { i, titulo ->
                FilledTonalButton(onClick = { estado = i }, contentPadding = PaddingValues(horizontal = 8.dp)) { Text(titulo) }
            }
        }
        AnimatedContent(targetState = estado, transitionSpec = { fadeIn(tween(700)) togetherWith fadeOut(tween(500)) }, label = "estado") { actual ->
            Card(Modifier.fillMaxWidth()) { Text(mensajes[actual], Modifier.padding(24.dp), style = MaterialTheme.typography.titleLarge) }
        }
    }
}
