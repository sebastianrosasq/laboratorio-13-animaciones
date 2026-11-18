package com.example.lab13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); setContent { MaterialTheme { Laboratorio() } } }
}

@Composable fun Laboratorio() {
    var pagina by remember { mutableIntStateOf(0) }
    val nombres = listOf("Visibilidad", "Color", "Tamaño", "Contenido", "Videojuego")
    Column(Modifier.fillMaxSize().safeDrawingPadding().padding(16.dp)) {
        Text("Laboratorio 13", style = MaterialTheme.typography.headlineMedium)
        Text("Animaciones con Jetpack Compose", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(12.dp))
        Row(Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            nombres.forEachIndexed { i, nombre -> FilterChip(selected = pagina == i, onClick = { pagina = i }, label = { Text(nombre) }) }
        }
        HorizontalDivider()
        when (pagina) { 0 -> Visibilidad(); 1 -> ColorAnimado(); 2 -> TamanoPosicion(); 3 -> ContenidoAnimado(); 4 -> Juego() }
    }
}
