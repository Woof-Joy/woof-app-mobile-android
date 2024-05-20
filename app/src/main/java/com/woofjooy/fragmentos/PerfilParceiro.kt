package com.woofjooy.fragmentos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.components.Botao
import com.woofjooy.components.CardServico
import com.woofjooy.components.Carousel
import com.woofjooy.datas.Servico


@Composable
fun PerfilParceiro(nome: String?, endereco: String?, descricao: String?, servicos: List<Servico>?){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.rosa_claro)),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column (
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 20.dp, end = 10.dp)
            ){
                Image(painter = painterResource(R.mipmap.imagem_perfil_test), contentDescription = "Imagem de perfil do usuario", modifier= Modifier.size(100.dp))
                Botao(texto = "Agendar Servico", fontSize = 8.sp,color = colorResource(R.color.branco), background = colorResource(
                    R.color.rosa_escuro
                ), Modifier
                    .width(120.dp)) {
                    //Logica para abrir o modal de agendamento
                }
            }
            Column (
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 10.dp, end = 20.dp)
            ){
                Text(
                    text = nome!!,
                    color = colorResource(R.color.preto),
                    fontSize = 16.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = endereco!!,
                    color = colorResource(R.color.rosa_escuro),
                    fontSize = 12.sp,

                    )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = descricao!!,
                    color = colorResource(R.color.preto),
                    fontSize = 8.sp,
                    style = TextStyle(lineHeight = 12.sp, textAlign = TextAlign.Justify)
                )

            }

        }
        Carousel()
        Column (
            modifier = Modifier.fillMaxWidth(0.85f),

            ){
            Text(
                text = "Servicos",
                color = colorResource(R.color.preto),
                fontSize = 16.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Quantidade de serviços: 0",
                color = colorResource(R.color.preto),
                fontSize = 12.sp,

                )
            Spacer(modifier = Modifier.height(8.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
            servicos!!.forEach {
                  var textValor = "R$ ${it.valor}".replace(".", ",")
                  if (it.tipoServico.equals("DogSitter")){
                    textValor += " / Hora"
                  }else{
                    textValor += " / Passeio"
                  }
                CardServico(servico = it.tipoServico, textValor = textValor)
            }

            }
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Botao(texto = "Observações", fontSize = 12.sp, color = colorResource(R.color.branco), background = colorResource(
                R.color.rosa_escuro
            ), modifier = Modifier
                .width(140.dp)) {

            }
            Botao(texto = "Acomodações", fontSize = 12.sp, color = colorResource(R.color.branco), background = colorResource(
                R.color.rosa_escuro
            ), modifier = Modifier
                .width(140.dp)) {

            }
        }

    }
}