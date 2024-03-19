package com.woofjooy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp)
            .background(color = colorResource(R.color.branco)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text=stringResource(R.string.titulo_entrada), fontSize = 24.sp,
                style = TextStyle(colorResource(R.color.rosa_escuro),
                fontWeight = FontWeight.Bold)
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            BotaoSelecionePerfil(stringResource(R.string.parceiro), colorResource(R.color.rosa_claro), colorResource(R.color.rosa_escuro))
            BotaoSelecionePerfil(stringResource(R.string.cliente), colorResource(R.color.rosa_claro), colorResource(R.color.rosa_escuro))
        }


    }
}


@Composable
fun BotaoSelecionePerfil(text:String, borderColor:Color, color:Color){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(60.dp)
            .fillMaxWidth()
            .border(
                3.dp, borderColor,
                shape = RoundedCornerShape(30.dp)
            )
            .background(color, shape = RoundedCornerShape(30.dp))
        ,
        colors = ButtonDefaults.buttonColors(color)

    ) {
        Text(text = text, fontSize = 24.sp, modifier = Modifier
            .padding(top = 30.dp, bottom = 30.dp))

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    WoofJooyTheme {
        SelecionePerfil("Android")
    }
}