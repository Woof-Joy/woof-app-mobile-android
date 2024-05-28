package com.woofjooy.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//@Composable
//fun Modal(){
//    // Mantém o estado do modal: true se estiver aberto, false se estiver fechado
//    val (showModal, setShowModal) = remember { mutableStateOf(false) }
//
//    // O conteúdo do modal
//    val modalContent = "Este é um modal de exemplo."
//
//    // Exibir um botão que abre o modal quando clicado
//    Button(onClick = { setShowModal(true) }) {
//        Text(text = "Abrir Modal")
//    }
//
//    // Modal
//    if (showModal) {
//        AlertDialog(
//            onDismissRequest = { setShowModal(false) },
//            title = {
//                Text(text = "Modal")
//            },
//            text = {
//                Text(text = modalContent)
//            },
//            buttons = {
//                Row(
//                    modifier = Modifier
//                        .padding(horizontal = 12.dp)
//                        .padding(bottom = 12.dp)
//                        .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.End
//                ) {
//                    Button(
//                        onClick = { setShowModal(false) },
//                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
//                    ) {
//                        Text(text = "Fechar")
//                    }
//                }
//            },
//            shape = RoundedCornerShape(8.dp)
//        )
//    }
//}