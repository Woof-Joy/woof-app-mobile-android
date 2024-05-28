package com.woofjooy.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.components.BotaoSelecionePerfil
import com.woofjooy.components.Input
import com.woofjooy.ui.theme.WoofJooyTheme

class SelectTypePerfil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofJooyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SelecionePerfil("Android")
                }
            }
        }
    }
}

@Composable
fun SelecionePerfil(name: String, modifier: Modifier = Modifier) {
    val contexto = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp)
            .background(color = colorResource(R.color.branco)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text= stringResource(R.string.titulo_entrada), fontSize = 24.sp,
            style = TextStyle(
                colorResource(R.color.rosa_escuro),
                fontWeight = FontWeight.Bold)
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            BotaoSelecionePerfil(
                stringResource(R.string.parceiro), colorResource(R.color.rosa_claro), colorResource(
                R.color.rosa_escuro
            ), "P", contexto)
            BotaoSelecionePerfil(
                stringResource(R.string.cliente), colorResource(R.color.rosa_claro), colorResource(
                R.color.rosa_escuro
            ), "C", contexto)
        }


    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {
    WoofJooyTheme {
        SelecionePerfil("Android")
    }
}