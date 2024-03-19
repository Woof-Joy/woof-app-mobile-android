package com.woofjooy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.woofjooy.dados.Cliente
import com.woofjooy.dados.Parceiro
import com.woofjooy.ui.theme.ui.theme.WoofJooyTheme
import java.time.format.TextStyle

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
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val parceiros = remember { mutableStateListOf<Parceiro>() }
    val expandida = remember { mutableStateOf(false) }

    Column {



        LazyColumn{
            items(items = parceiros){
                Box{
                    Row {
                        Image(painter = , contentDescription = )
                        Column {
                            LazyRow{
                                items(items = it.servicos){

                                    Text("#DogWalker")
                                }
                            }
                            Text(text = "Pedro Oliveira")
                            Text(text = "Mooca, São Paulo")
                            Text(text = "Lorem ipsum dolor sit amet. Sed nemo amet et quibusdam amet et iste voluptas.")
                        }

                    }
                }

            }
        }







//        TextButton(onClick = { expandida.value = !expandida.value }) {
//            Text("Selecione a fruta")
//        }
//        Box {
//            DropdownMenu(
//                expanded = expandida.value,
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
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    WoofJooyTheme {
        Greeting("Android")
    }
}