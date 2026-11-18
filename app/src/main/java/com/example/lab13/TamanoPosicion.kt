package com.example.lab13

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable fun TamanoPosicion() {
    var movido by remember { mutableStateOf(false) }
    val tamano by animateDpAsState(if (movido) 110.dp else 70.dp, tween(900), label = "tamaño")
    val desplazamiento by animateDpAsState(if (movido) 160.dp else 0.dp, tween(900), label = "posición")
    Column(Modifier.fillMaxWidth().padding(top = 24.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text("3  Tamaño y posición", style = MaterialTheme.typography.headlineSmall)
        Text("El cuadro se mueve y cambia de tamaño al mismo tiempo")
        Button(onClick = { movido = !movido }) { Text("Mover y cambiar tamaño") }
        Box(Modifier.fillMaxWidth().height(130.dp)) {
            Box(Modifier.offset(x = desplazamiento).size(tamano).background(Color(0xFFE68046)))
        }
        Text("Orden de modificadores", style = MaterialTheme.typography.titleMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
            Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
                Box(Modifier.background(Color(0xFFD5CCF0)).padding(12.dp).size(38.dp).background(Color(0xFF65509D)))
                Text("Fondo antes", style = MaterialTheme.typography.labelMedium)
            }
            Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
                Box(Modifier.padding(12.dp).size(38.dp).background(Color(0xFF65509D)))
                Text("Padding antes", style = MaterialTheme.typography.labelMedium)
            }
        }
    }
}
