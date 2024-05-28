package com.woofjooy.components

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R

@Composable
fun Carousel() {
    val images = listOf(
        R.mipmap.imagem_carrossel_test,
        R.mipmap.imagem_perfil_test
    )
    val selectedIndex = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .width(350.dp)
            .height(190.dp)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.Transparent)
                .clipToBounds()
        ) {
            Image(
                painter = painterResource(id = images[selectedIndex.value]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.FillBounds
            )
            IconButton(
                onClick = {
                    selectedIndex.value = (selectedIndex.value - 1).coerceIn(0, images.size - 1)
                },
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(8.dp)
                    .size(32.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .graphicsLayer(rotationY = 180f)
            ) {
                Image(painter = painterResource(R.drawable.baseline_arrow_forward_ios_24), contentDescription = "")
            }
            IconButton(
                onClick = {
                    selectedIndex.value = (selectedIndex.value + 1).coerceIn(0, images.size - 1)
                },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(8.dp)
                    .size(32.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .graphicsLayer(rotationY = 180f)
            ) {
                Image(painter = painterResource(R.drawable.baseline_arrow_back_ios_24), contentDescription = "")
            }
        }
    }
}