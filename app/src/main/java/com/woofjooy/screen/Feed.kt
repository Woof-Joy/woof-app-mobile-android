package com.woofjooy.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.woofjooy.client.RetrofitClient
import com.woofjooy.componets.CardFeed
import com.woofjooy.datas.Usuario
import com.woofjooy.ui.theme.ui.theme.WoofJooyTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Feed : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofJooyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaFeed("Android")
                }
            }
        }
    }
}

@Composable
fun TelaFeed(name: String, modifier: Modifier = Modifier) {
    val parceiros = remember { mutableStateListOf<Usuario>() }
    val expandida = remember { mutableStateOf(false) }



    RetrofitClient.instance.listUsers().enqueue(object : Callback<List<Usuario>> {
        override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
            if (response.isSuccessful) {
                val lista = response.body()
                if (lista != null){
                    parceiros.clear()
                    parceiros.addAll(lista)
                }
            } else {
                // Trate erros, como um código de resposta 404 ou 500
            }
        }

        override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
            // Trate falhas na chamada de rede, como um problema de conexão
        }
    })


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //DESENVOLVER MENU PARA NAVEGAÇÃO DENTRO DO APP(CRIAR ARQUIVO DENTRO DA PASTA "/componets" PARA DESENVOLVER O COMPONENTE DE MENU)

//        Exemplo de para a criação do menu:

//        TextButton(onClick = { expandida.value = !expandida.value }) {
//            Text("Selecione a fruta")
//        }
//        Box {
//            DropdownMenu(
//                expanded = expandida.value,f
//                onDismissRequest = { expandida.value = false },
//            ) {
//                DropdownMenuItem(
//                    text = { Text("Maçã") },
//                    onClick = {
//
//                        expandida.value = false
//                    }
//                )
//                DropdownMenuItem(
//                    text = { Text("Pera") },
//                    onClick = {
//
//                        expandida.value = false
//                    }
//                )
//            }
//        }
//
//
//
//        Image(
//            painter = painterResource(id = R.mipmap.logo_branca),
//            contentDescription = "Foto de um bebezinho",
//            modifier = Modifier.fillMaxHeight(0.1f)
//        )
//        Row{
//            Image(
//                painter = painterResource(id = R.mipmap.logo_branca),
//                contentDescription = "Foto de um bebezinho",
//                modifier = Modifier.fillMaxWidth(0.33f)
//            )
//            Image(
//                painter = painterResource(id = R.mipmap.logo_branca),
//                contentDescription = "Foto de um bebezinho",
//                modifier = Modifier.fillMaxWidth(0.33f)
//            )
//            Image(
//                painter = painterResource(id = R.mipmap.logo_branca),
//                contentDescription = "Foto de um bebezinho",
//                modifier = Modifier.fillMaxWidth(0.33f)
//            )
//        }
//
//
//
//        Button(onClick = {
//            val fruta = Cliente(
//                1,
//                "Pedro"
//            )
//            parceiros.add(fruta)
//        }) {
//            Text("Cadastrar")
//        }
//
//        LazyColumn {
//            items(items = parceiros){
//                Text("${it.id} é R$${it.nome}")
//            }
//        }
//        if (parceiros.isNotEmpty()) {
//            Text("ID: ${parceiros.sumOf { it.id }}")
//        }




        //DESENVOLVER PARTE SUPERIOR COM OS FILTROS...




       LazyColumn {
          items(items = parceiros){
              CardFeed()//falta adicionar atributos como lista de users, tipo de card(pensando em reaproveitar código), etc..

          }

       }


    }

}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    WoofJooyTheme {
        TelaFeed("Android")
    }
}