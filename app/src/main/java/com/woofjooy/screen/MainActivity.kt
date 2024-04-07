package com.woofjooy.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.woofjooy.ui.theme.WoofJooyTheme
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun TelaLogin(name: String, modifier: Modifier = Modifier) {

    var isLoading by remember { mutableStateOf(true) }


    // Simula o carregamento de dados com um delay
    MainScope().launch {
        delay(3000) // Delay de 3 segundos para simulação
        isLoading = false
    }

    if (isLoading) {
        TelaInicial("Android")
    } else {
        SelecionePerfil("Android");
    }


}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WoofJooyTheme {
        TelaLogin("Android")
    }
}