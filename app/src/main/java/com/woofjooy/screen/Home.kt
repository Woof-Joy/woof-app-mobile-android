package com.woofjooy.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.woofjooy.fragmentos.Feed
import com.woofjooy.fragmentos.Sair
import com.woofjooy.fragmentos.TelasFragmentos
import com.woofjooy.screen.ui.theme.WoofJooyTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofJooyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home(rememberNavController())
                }
            }
        }
    }
}

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TelasFragmentos.TELA1.name
    ) {
        composable(TelasFragmentos.TELA1.name) {
            Feed()
        }
//        composable(TelasFragmentos.TELA2.name) {
//            PerfilParceiro(name = )
//        }
        composable(TelasFragmentos.TELA3.name) {
            Sair()
        }
    }
//    Spacer(modifier = Modifier.weight(1f))
    Row {
        TelasFragmentos.values().forEach {
            Card(modifier = Modifier.weight(1f)) {
                TextButton(
                    onClick = {  navController.navigate(it.name) }
                ) {
                    // importar do androidx.compose...
                    Image(
                        painter = painterResource(id = it.imagem),
                        contentDescription = it.descricao )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    WoofJooyTheme {
        Home(rememberNavController())
    }
}