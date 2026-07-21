package com.example.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.RedSecondary
import kotlin.math.roundToInt

@Composable
fun BreakingNewsBanner(
    onBannerClick: () -> Unit = {}
) {
    val text = "ÚLTIMO MINUTO: Congreso debate moción de interpelación por presupuesto 2024 • Elecciones Regionales: JEE publica lista definitiva de candidatos • Informe Económico: BCRP proyecta estabilidad fiscal • "

    val infiniteTransition = rememberInfiniteTransition(label = "MarqueeTransition")
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -1200f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 22000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "MarqueeOffset"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(RedSecondary)
            .clickable { onBannerClick() }
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.offset { IntOffset(offsetX.roundToInt(), 0) }
        ) {
            Text(
                text = text + text + text,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp,
                maxLines = 1,
                softWrap = false
            )
        }
    }
}
