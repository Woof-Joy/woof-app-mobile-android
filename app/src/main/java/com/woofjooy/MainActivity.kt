package com.woofjooy

import android.content.Intent
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.ui.theme.WoofJooyTheme
import java.util.Objects

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofJooyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaLogin("Android")
                }
            }
        }
    }
}


@Composable
fun TelaLogin(name: String, modifier: Modifier = Modifier) {
    val email = remember {
        mutableStateOf("")
    }
    val senha = remember {
        mutableStateOf("")
    }


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
                Botao(stringResource(R.string.txt_botao_login), colorResource(R.color.branco), colorResource(R.color.rosa_escuro))
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
                )))
            }

        }
    }

}



@Composable
fun Botao(texto:String, color: Color, background: Color){
    val contexto = LocalContext.current
    Button(
        onClick = {
            val feed = Intent(contexto, Feed::class.java)

            //feed.putExtra("listaParceiros", parceiros)

            contexto.startActivity(feed)
        },
        modifier = Modifier
            .padding(start = 60.dp, end = 60.dp)
            .width(200.dp)

        ,
        colors = ButtonDefaults.buttonColors(background)
    ) {
        Text(texto, color = color)
    }
}


@Composable
fun Input(valCampo:MutableState<String>, label:String){
    Column{

        Text(text = "$label", color= colorResource(R.color.preto))
        //Text(text = stringResource(R.string.label_email), color=Color.Gray)

        BasicTextField(
            value = valCampo.value,
            onValueChange = { valCampo.value = it },
            modifier = Modifier
                .border(3.dp, colorResource(R.color.rosa_escuro), shape = RoundedCornerShape(50.dp))
                .width(300.dp)
                .padding(10.dp)

        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WoofJooyTheme {
        TelaLogin("Android")
    }
}