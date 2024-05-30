//package com.woofjooy.fragmentos
//
//import android.os.Build
//import android.os.Bundle
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.compose.rememberNavController
//import com.woofjooy.R
//import com.woofjooy.components.Title
//import com.woofjooy.datas.ParceiroFeed
//import com.woofjooy.screen.TelaLogin
//import com.woofjooy.ui.theme.WoofJooyTheme
//
//@RequiresApi(Build.VERSION_CODES.TIRAMISU)
//@Composable
//fun MeuPerfil(extras: Bundle?, name: String="Home"){
//    val parceiros = remember { mutableStateListOf<ParceiroFeed>() }
//    val habilitarEdicao = remember {
//        mutableStateOf(false)
//    }
//
//    if (!habilitarEdicao.value){
//        Column(
//            modifier = Modifier
//                .fillMaxSize(),
//
//            ) {
//            Column (modifier = Modifier
//                .fillMaxSize(),
//                verticalArrangement = Arrangement.SpaceAround,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Row (
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    verticalAlignment = Alignment.CenterVertically,
//                ){
//                    Column (
//                        verticalArrangement = Arrangement.SpaceAround,
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier.padding(start = 20.dp, end = 10.dp)
//                    ){
//                        Image(painter = painterResource(R.mipmap.imagem_perfil_test), contentDescription = "Imagem de perfil do usuario", modifier= Modifier.size(100.dp))
//                        Botao(texto = "Agendar Servico", fontSize = 8.sp,color = colorResource(R.color.branco), background = colorResource(
//                            R.color.rosa_escuro
//                        ), Modifier
//                            .width(120.dp)) {
//                            //Logica para abrir o modal de agendamento
//                        }
//                    }
//                    Column (
//                        verticalArrangement = Arrangement.Top,
//                        horizontalAlignment = Alignment.Start,
//                        modifier = Modifier.padding(start = 10.dp, end = 20.dp)
//                    ){
//                        Text(
//                            text = nome!!,
//                            color = colorResource(R.color.preto),
//                            fontSize = 16.sp,
//                            style = TextStyle(fontWeight = FontWeight.Bold)
//                        )
//                        Text(
//                            text = endereco!!,
//                            color = colorResource(R.color.rosa_escuro),
//                            fontSize = 12.sp,
//
//                            )
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Text(
//                            text = descricao!!,
//                            color = colorResource(R.color.preto),
//                            fontSize = 8.sp,
//                            style = TextStyle(lineHeight = 12.sp, textAlign = TextAlign.Justify)
//                        )
//
//                    }
//
//                }
//
//                Column (
//                    modifier = Modifier.fillMaxWidth(0.85f),
//
//                    ){
//                    Text(
//                        text = "Servicos",
//                        color = colorResource(R.color.preto),
//                        fontSize = 16.sp,
//                        style = TextStyle(fontWeight = FontWeight.Bold)
//                    )
//                    Text(
//                        text = "Quantidade de serviços: 0",
//                        color = colorResource(R.color.preto),
//                        fontSize = 12.sp,
//
//                        )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Row (
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ){
//                        servicos!!.forEach {
//                            var textValor = "R$ ${it.valor}".replace(".", ",")
//                            if (it.tipoServico.equals("DogSitter")){
//                                textValor += " / Hora"
//                            }else{
//                                textValor += " / Passeio"
//                            }
//                            CardServico(servico = it.tipoServico, textValor = textValor)
//                        }
//
//                    }
//                }
//                Row (
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    Botao(texto = "Observações", fontSize = 12.sp, color = colorResource(R.color.branco), background = colorResource(
//                        R.color.rosa_escuro
//                    ), modifier = Modifier
//                        .width(140.dp)) {
//
//                    }
//                    Botao(texto = "Acomodações", fontSize = 12.sp, color = colorResource(R.color.branco), background = colorResource(
//                        R.color.rosa_escuro
//                    ), modifier = Modifier
//                        .width(140.dp)) {
//
//                    }
//                }
//
//            }
//        }
//    }else{
//
//    }
//
//
//
//
//}
//
//@RequiresApi(Build.VERSION_CODES.TIRAMISU)
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    WoofJooyTheme {
//        MeuPerfil(navController = rememberNavController(), extras = null)
//    }
//}