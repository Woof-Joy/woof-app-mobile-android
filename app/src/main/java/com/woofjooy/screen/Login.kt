package com.woofjooy.screen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.componets.Botao
import com.woofjooy.componets.Input
import com.woofjooy.ui.theme.WoofJooyTheme

class Login : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        setContent {
            WoofJooyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login(extras)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Login(extras: Bundle?) {
    val email = remember {
        mutableStateOf("")
    }
    val senha = remember {
        mutableStateOf("")
    }
    val typePerfil = extras?.getInt("typePerfil")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.rosa_escuro)),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.mipmap.logo_branca),
            contentDescription = "Logo da marca woofjoy",
            modifier = Modifier.size(150.dp)
        )
        Column(
            modifier = Modifier
                .background(
                    color = colorResource(R.color.branco),
                    shape = RoundedCornerShape(topStart = 80.dp, topEnd = 80.dp)
                )
                .height(6200.dp)
                .fillMaxWidth()
            ,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = stringResource(R.string.boa_vindas_login), fontSize = 24.sp, style = TextStyle(fontWeight = FontWeight.Bold))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Input(valCampo = email, label = stringResource(R.string.label_email))
                Spacer(modifier = Modifier.height(8.dp))
                Input(valCampo = senha, label = stringResource(R.string.label_senha))
                Spacer(modifier = Modifier.height(16.dp)) // Adiciona um espaçamento entre os TextField e o Button
                Botao(stringResource(R.string.txt_botao_login), colorResource(R.color.branco), colorResource(
                    R.color.rosa_escuro
                ))
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    "Ainda não tem uma conta?"
                )
                Text("Cadastre-se", style = TextStyle(fontWeight = FontWeight.Bold, color = colorResource(
                    R.color.rosa_escuro
                )
                )
                )
            }

        }
    }
}





