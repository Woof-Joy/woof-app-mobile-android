package com.woofjooy.components

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Checkbox
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.screen.ui.theme.WoofJooyTheme
import kotlin.reflect.KProperty

class MeuPerfilParceiro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            WoofJooyTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    MeuPerfilParceiro("teste")
                }
            }
        }
    }
}

@Composable
fun MeuPerfilParceiro(name: String, modifier: Modifier = Modifier){

    var habilitarEdicao = remember { mutableStateOf(false) }

    var nomeNovo = remember { mutableStateOf("") }
    val nomeAtual = "Renato Silva"

    var checkedDogWalker = remember { mutableStateOf(false) }
    var checkedDogSitter = remember { mutableStateOf(false) }

    var precoDWalkerNovo = remember { mutableStateOf("") }
    var precoDWalkerAtual = "60,00"

    var precoDSitterNovo = remember { mutableStateOf("") }
    var precoDSitterAtual = "30,00"

    var cpfNovo = remember { mutableStateOf("") }
    val cpfAtual = "123.456.789-90"

    var cepNovo = remember { mutableStateOf("") }
    val cepAtual = "00000-000"

    var numeroNovo = remember { mutableStateOf("") }
    val numeroAtual = "123"

    var emailNovo = remember { mutableStateOf("") }
    val emailAtual = "renato.silva@gmail.com"


    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp)
            .padding(20.dp)
            .background(color = colorResource(R.color.branco)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row {
            Title(text = stringResource(R.string.title_meu_perfil_parceiro))
        }
        Row {
            Text(text = stringResource(R.string.txt_info_meu_perfil_parceiro))
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.End
        ){
            IconButton(
                onClick = { habilitarEdicao.value = !habilitarEdicao.value }
            ) {
                Image(painter = painterResource(id = R.drawable.baseline_edit_square_24), contentDescription = null)
            }
        }

        // NOME
        if (habilitarEdicao.value){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                ){
                Input(valCampo = nomeNovo, "Nome", modifier = Modifier
                    .background(
                        color = colorResource(R.color.cinza),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .width(350.dp)
                    .padding(10.dp)
                )
            }
        } else{
            Row{
                Text(text = "Nome", style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp))
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = nomeAtual,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                    modifier = Modifier
                        .background(
                            color = colorResource(R.color.cinza),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(350.dp)
                        .padding(10.dp)
                )
            }
        }

        // SERVIÇOS
        if (habilitarEdicao.value){
            Row{
                Text(text = "Serviços", style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp) )
            }

            Row {
                Column {
                    Row(
                        modifier = Modifier
                            .width(180.dp)
                            .padding(5.dp)
                    ) {
                        Checkbox(
                            checked = checkedDogWalker.value,
                            onCheckedChange = { checkedDogWalker.value = it},
                        )
                        Row (
                            modifier = Modifier
                                .padding(top = 13.dp)
                        ){
                            Text(text = "Dog Walker", style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp) )
                        }
                    }
                }

                Column {
                    Row (
                        modifier = Modifier
                            .width(200.dp)
                            .padding(5.dp)
                    ) {
                        Checkbox(
                            checked = checkedDogSitter.value,
                            onCheckedChange = { checkedDogSitter.value = it},
                        )
                        Row (
                            modifier = Modifier
                                .padding(top = 13.dp)
                        ){
                            Text(text = "Dog Sitter", style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp) )
                        }
                    }
                }
            }

            if (checkedDogWalker.value){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ){
                    Input(valCampo = precoDWalkerNovo, "Preço Dog Walker (Passeio)", modifier = Modifier
                        .background(
                            color = colorResource(R.color.cinza),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(230.dp)
                        .padding(10.dp)
                    )
                }
            }

            if (checkedDogSitter.value){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, top = 16.dp)
                ){
                    Input(valCampo = precoDSitterNovo, "Preço Dog Sitter (Hora)", modifier = Modifier
                        .background(
                            color = colorResource(R.color.cinza),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(230.dp)
                        .padding(10.dp)
                    )
                }
            }
        } else{
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column (
                    modifier = Modifier
                        .background(
                            colorResource(R.color.rosa_claro),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .size(160.dp, 90.dp)
                        .padding(20.dp),
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    ) {
                        Text(
                            text = "Dog Walker",
                            color = colorResource(R.color.rosa_escuro),
                            fontSize = 18.sp,
                            style = TextStyle(fontWeight = FontWeight.Medium)
                        )
                    }

                    Row {
                        Text(
                            text = "R$ ${precoDWalkerAtual} / Passeio",
                            fontSize = 12.sp,
                        )
                    }
                }

                Column (
                    modifier = Modifier
                        .background(
                            colorResource(R.color.rosa_claro),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .size(160.dp, 90.dp)
                        .padding(20.dp),
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    ){
                        Text(
                            text = "Dog Sitter",
                            color = colorResource(R.color.rosa_escuro),
                            fontSize = 18.sp,
                            style = TextStyle(fontWeight = FontWeight.Medium)
                        )
                    }

                    Row {
                        Text(
                            text = "R$ ${precoDSitterAtual} / Hora",
                            fontSize = 12.sp,
                        )
                    }
                }
            }
        }

        // CPF
        if (habilitarEdicao.value){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Input(valCampo = cpfNovo, "CPF", modifier = Modifier
                    .background(
                        color = colorResource(R.color.cinza),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .width(350.dp)
                    .padding(10.dp)
                )
            }
        } else{
            Row{
                Text(text = "CPF", style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp) )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = cpfAtual,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                    modifier = Modifier
                        .background(
                            color = colorResource(R.color.cinza),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(350.dp)
                        .padding(10.dp)
                )
            }
        }

        // CEP + Número
        if (habilitarEdicao.value){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(end = 30.dp)
                ) {
                    Input(valCampo = cepNovo, "CEP", modifier = Modifier
                        .background(
                            color = colorResource(R.color.cinza),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(220.dp)
                        .padding(10.dp)
                    )
                }
                Column {
                    Input(valCampo = numeroNovo, "Número", modifier = Modifier
                        .background(
                            color = colorResource(R.color.cinza),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(100.dp)
                        .padding(10.dp)
                    )
                }
            }
        } else{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Column (
                    modifier = Modifier
                    .padding(end = 30.dp)
                ){
                    Row{
                        Text(text = "CEP", style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp) )
                    }
                    Row {
                        Text(
                            text = cepAtual,
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                            modifier = Modifier
                                .background(
                                    color = colorResource(R.color.cinza),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .width(220.dp)
                                .padding(10.dp)
                        )
                    }
                }
                Column {
                    Row{
                        Text(text = "Número", style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp) )
                    }
                    Row {
                        Text(
                            text = numeroAtual,
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                            modifier = Modifier
                                .background(
                                    color = colorResource(R.color.cinza),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .width(100.dp)
                                .padding(10.dp)
                        )
                    }
                }
            }


        }

        // EMAIL
        if (habilitarEdicao.value){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Input(valCampo = emailNovo, "E-mail", modifier = Modifier
                    .background(
                        color = colorResource(R.color.cinza),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .width(350.dp)
                    .padding(10.dp)
                )
            }
        } else{
            Row{
                Text(text = "E-mail", style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp) )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = emailAtual,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                    modifier = Modifier
                        .background(
                            color = colorResource(R.color.cinza),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(350.dp)
                        .padding(10.dp)
                )
            }
        }

        // SALVAR
        if (habilitarEdicao.value){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ){
                Botao(
                    texto = "Salvar",
                    fontSize = 16.sp,
                    color = colorResource(R.color.branco),
                    background = colorResource(R.color.rosa_escuro),
                    modifier = Modifier
                        .size(400.dp, 40.dp),
                    onClick = {
                        // Implementar ação do botão aqui
                    }
                )
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview4() {
    WoofJooyTheme {
        MeuPerfilParceiro("teste")
    }
}
