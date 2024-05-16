package com.woofjooy.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.components.Botao
import com.woofjooy.components.CardServico
import com.woofjooy.components.Carousel
import com.woofjooy.ui.theme.WoofJooyTheme


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


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TelaLogin(name: String, modifier: Modifier = Modifier) {
//    var isLoading by remember { mutableStateOf(true) }
//    // Simula o carregamento de dados com um delay
//    MainScope().launch {
//        delay(3000) // Delay de 3 segundos para simulação
//        isLoading = false
//    }
//
//    if (isLoading) {
//        TelaInicial("Android")
//    } else {
//        SelecionePerfil("Android");
//    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.rosa_claro)),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 20.dp, end = 10.dp)
            ) {
                Image(
                    painter = painterResource(R.mipmap.imagem_perfil_test),
                    contentDescription = stringResource(id = R.string.contentDescription_img_perfil),
                    modifier = Modifier.size(100.dp)
                )
                Botao(
                    texto = stringResource(id = R.string.text_botao_agendar),
                    fontSize = 8.sp,
                    color = colorResource(R.color.branco),
                    background = colorResource(
                        R.color.rosa_escuro
                    ),
                    Modifier
                        .width(120.dp)
                ) {
                    //Logica para abrir o modal de agendamento
                }
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 10.dp, end = 20.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.label_nome),
                    color = colorResource(R.color.preto),
                    fontSize = 16.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = stringResource(id = R.string.label_localizacao),
                    color = colorResource(R.color.rosa_escuro),
                    fontSize = 12.sp,

                    )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.lorem),
                    color = colorResource(R.color.preto),
                    fontSize = 8.sp,
                    style = TextStyle(lineHeight = 12.sp, textAlign = TextAlign.Justify)
                )
            }
        }
        Carousel()
        Column(
            modifier = Modifier.fillMaxWidth(0.85f),

            ) {
            Text(
                text = stringResource(id = R.string.label_servicos),
                color = colorResource(R.color.preto),
                fontSize = 16.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Quantidade de serviços: x",
                color = colorResource(R.color.preto),
                fontSize = 12.sp,

                )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
//            parceiro.servicos.forEach {
//                  var textValor = "R$ ${parceiro.servicos.valor}"
//                  if (parceiro.servicos.tipoServico.equals("DogSitter")){
//                    textValor += " / Hora"
//                  }else{
//                    textValor += " / Passeio"
//                  }
//                CardServico(servico = , textValor = )
//            }
                CardServico()
                CardServico()
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Botao(
                texto = stringResource(id = R.string.label_obs),
                fontSize = 12.sp,
                color = colorResource(R.color.branco),
                background = colorResource(
                    R.color.rosa_escuro
                ),
                modifier = Modifier
                    .width(140.dp)
            ) {

            }
            Botao(
                texto = stringResource(id = R.string.label_acomodacoes),
                fontSize = 12.sp,
                color = colorResource(R.color.branco),
                background = colorResource(
                    R.color.rosa_escuro
                ),
                modifier = Modifier
                    .width(140.dp)
            ) {

            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WoofJooyTheme {
        TelaLogin("Android")
    }
}