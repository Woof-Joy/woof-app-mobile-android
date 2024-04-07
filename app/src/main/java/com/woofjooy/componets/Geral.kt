package com.woofjooy.componets

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.screen.Feed
import com.woofjooy.screen.Login

//Aqui iremos centralizar todos os componentes gerais ou componentes mais simples...
//Caso o componente for muito complexo crie um arquivo para desenvolve-lo
@Composable
fun BotaoSelecionePerfil(text:String, borderColor:Color, color:Color, typePerfil:Int, contexto: Context){
    Button(
        onClick = {
            val tela2 = Intent(contexto, Login::class.java)
            tela2.putExtra("typePerfil", typePerfil)
            contexto.startActivity(tela2)
        },
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

@Composable
fun TextNomeParceiro(){}

@Composable
fun TextEndereco(){}

@Composable
fun TextServico(){}

@Composable
fun TextDescricao(){}

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
fun Input(valCampo: MutableState<String>, label:String){
    Column{

        Text(text = label, color= colorResource(R.color.preto))
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