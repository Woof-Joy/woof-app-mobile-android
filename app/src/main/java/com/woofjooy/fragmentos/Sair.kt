package com.woofjooy.fragmentos

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R

@Composable
fun Sair(onConfirmExit: () -> Unit, onCancelExit: () -> Unit) {
    var exitConfirmed = remember { mutableStateOf(false) }

    if (exitConfirmed.value) {
        onConfirmExit()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .shadow(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Tem certeza que deseja sair?",
                    fontSize = 20.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Button(onClick = { exitConfirmed.value = true }, colors = ButtonDefaults.buttonColors(
                        colorResource(R.color.rosa_escuro))) {
                        Text("Sim")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = { onCancelExit() }, colors = ButtonDefaults.buttonColors(
                        colorResource(R.color.rosa_escuro))) {
                        Text("Não")
                    }
                }
            }

        }

    }
}


