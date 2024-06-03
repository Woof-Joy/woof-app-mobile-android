package com.woofjooy.screen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.woofjooy.R

import com.woofjooy.fragmentos.MeuPerfil
import com.woofjooy.fragmentos.MeuServicos

import com.woofjooy.fragmentos.Sair
import com.woofjooy.fragmentos.TelasFragmentos
import com.woofjooy.screen.ui.theme.WoofJooyTheme

class Home : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        setContent {
            WoofJooyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home(navController = rememberNavController(), extras = extras)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@SuppressLint("NewApi")
@Composable
fun Home(navController: NavHostController, extras: Bundle?,modifier: Modifier = Modifier) {
    val contexto = LocalContext.current
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        NavHost(
            modifier = Modifier.weight(1f),
            navController = navController,
            startDestination = TelasFragmentos.TELA1.name
        ) {
            composable(TelasFragmentos.TELA1.name) {
                MeuServicos(extras = extras)
            }
            composable(TelasFragmentos.TELA2.name) {
                MeuPerfil(extras = extras)

            }
            composable(TelasFragmentos.TELA3.name) {
                Sair({
                    val inicio = Intent(contexto, MainActivity::class.java)
                    contexto.startActivity(inicio)
                }, {
                    navController.navigate(TelasFragmentos.TELA1.name)
                })
            }
        }

        Row(
            modifier = Modifier
                .background(color = colorResource(R.color.rosa_escuro))
        )
        {
            TelasFragmentos.values().forEach {
                TextButton(
                    onClick = { navController.navigate(it.name) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .background(color = colorResource(R.color.rosa_escuro))
                ) {
                    // importar do androidx.compose...
                    Image(
                        painter = painterResource(id = it.imagem),
                        contentDescription = it.descricao,
                        modifier = Modifier.size(20.dp)

                    )
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    WoofJooyTheme {
        Home(rememberNavController(), extras = null)
    }
}