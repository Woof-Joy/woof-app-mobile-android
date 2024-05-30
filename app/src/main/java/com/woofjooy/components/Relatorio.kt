package com.woofjooy.components
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
@Composable
fun Relatorio(){
    var relatorioText by remember { mutableStateOf(TextFieldValue())}

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Column {
            /*Text(
                 "Relatório",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    /*color = colorResource(id = R.color.black),*/
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )*/

            Title(text = stringResource(R.string.title_relatorio))

                TextField(
                    value = relatorioText,
                    onValueChange = {relatorioText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(8.dp)
                        .background(colorResource(id = R.color.cinza_legenda))

                )
            Botao(
                texto = "Enviar",
                fontSize = 16.sp,
                color = colorResource(id = R.color.branco),
                background = colorResource(id = R.color.rosa_escuro),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp),
                onClick = {
                    // Implementar ação do botão aqui
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewRelatorio() {
    Relatorio()
}