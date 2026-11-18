package com.example.lab13
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable fun Juego() {
    var jugando by remember { mutableStateOf(false) }
    var puntos by remember { mutableIntStateOf(0) }
    var derecha by remember { mutableStateOf(false) }
    val movimiento by animateDpAsState(if (derecha) 170.dp else 10.dp, tween(700), label = "posición")
    val fondo by animateColorAsState(if (jugando) Color(0xFF18285D) else Color(0xFF343B4E), tween(700), label = "fondo")
    val pulso = rememberInfiniteTransition(label = "pulso")
    val escala by pulso.animateFloat(0.85f, 1.1f, infiniteRepeatable(tween(650), RepeatMode.Reverse), label = "escala")
    Column(Modifier.fillMaxWidth().padding(top = 20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("5  Misión espacial", style = MaterialTheme.typography.headlineSmall)
        Text("Atrapa la estrella y suma puntos")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { jugando = !jugando; if (!jugando) puntos = 0 }) { Text(if (jugando) "Reiniciar" else "Comenzar") }
            if (jugando) FilledTonalButton(onClick = { puntos++; derecha = !derecha }) { Text("Atrapar") }
        }
        Box(Modifier.fillMaxWidth().height(260.dp).background(fondo, RoundedCornerShape(20.dp))) {
            Text("✦     ·       ✧        ·       ✦", Modifier.align(Alignment.TopCenter).padding(18.dp), color = Color.White)
            AnimatedVisibility(visible = jugando, enter = fadeIn(tween(600)) + scaleIn(), exit = fadeOut(tween(500))) {
                Box(Modifier.fillMaxSize()) { Text("★", Modifier.offset(x = movimiento, y = 90.dp).scale(escala), color = Color(0xFFFFD766), fontSize = 64.sp) }
            }
            AnimatedContent(targetState = puntos, transitionSpec = { fadeIn(tween(300)) togetherWith fadeOut(tween(300)) }, modifier = Modifier.align(Alignment.BottomStart).padding(18.dp), label = "puntos") { valor ->
                Text("Puntos: $valor", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
