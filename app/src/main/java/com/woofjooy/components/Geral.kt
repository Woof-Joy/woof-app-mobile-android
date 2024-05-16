package com.woofjooy.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.woofjooy.R
import com.woofjooy.datas.Servico
import com.woofjooy.screen.Feed
import com.woofjooy.screen.Login

//Aqui iremos centralizar todos os componentes gerais ou componentes mais simples...
//Caso o componente for muito complexo crie um arquivo para desenvolve-lo
@Composable
fun BotaoSelecionePerfil(text:String, borderColor:Color, color:Color, typePerfil:String, contexto: Context){
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
fun Botao(texto:String, fontSize: TextUnit, color: Color, background: Color, modifier: Modifier, onClick:()->Unit){
    val contexto = LocalContext.current
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(background)
    ) {
        Text(texto, color = color, fontSize=fontSize)
    }
}

@Composable
fun Title(text:String){
    Text(text, fontSize = 24.sp, style = TextStyle(fontWeight = FontWeight.Bold))
}

@Composable
fun Input(
    valCampo: MutableState<String>,
    label: String = "",
    placeholder: String = "",
    fontSize: TextUnit = 16.sp,
    modifier: Modifier = Modifier
) {
    Column {
        if (label.isNotBlank()) {
            Text(text = label, color = Color.Black)
        }
        BasicTextField(
            value = valCampo.value,
            onValueChange = { valCampo.value = it },
            modifier = modifier,
            textStyle = TextStyle(fontSize = fontSize, color = Color.Black)
        )
    }
}
@Composable
fun InputSelect(searchText: MutableState<String>, options: List<String>, label:String="", placeholder: String="", onOptionSelected: (String) -> Unit){
    val expanded = remember { mutableStateOf(false) }
    Column {
        if (label.isNotBlank()) {
            Text(text = label, color = colorResource(R.color.preto), fontSize = 8.sp)
        }
        BasicTextField(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            readOnly = true,
            modifier = Modifier
                .clickable { expanded.value = true }
                .width(80.dp)
                .padding(top = 5.dp, end = 5.dp)
                .background(
                    color = colorResource(R.color.cinza_legenda),
                    shape = RoundedCornerShape(15.dp)
                )
            ,
            textStyle = LocalTextStyle.current.copy(color = Color.Black)
        ){
            if (placeholder.isNotBlank()) {
                Text(text = label, color = colorResource(R.color.preto), fontSize = 8.sp)
            }
        }

        // Lista suspensa de opções
        if (expanded.value) {
            Dialog(onDismissRequest = { expanded.value = false }) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shadowElevation = 8.dp
                ) {
                    Column (
                        modifier = Modifier.width(66.dp)
                    ){
                        options.forEach { option ->
                            Text(
                                text = option,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        expanded.value = false
                                        onOptionSelected(option)
                                    }
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CardServico(servico: String="", textValor:String=""){
    Column (
        modifier = Modifier
            .height(100.dp)
            .background(
                color = colorResource(R.color.branco),
                shape = RoundedCornerShape(15.dp)
            ), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start
    ){
        Text(text = "Servico", color = colorResource(R.color.rosa_escuro), fontSize = 24.sp, style=TextStyle(fontWeight = FontWeight.Bold), modifier = Modifier.padding(start = 10.dp, end = 10.dp))
        Text(text = "R$ 60,0 / passeio", color = colorResource(R.color.preto), fontSize = 16.sp, modifier = Modifier.padding(start = 10.dp, end = 10.dp))
    }
}