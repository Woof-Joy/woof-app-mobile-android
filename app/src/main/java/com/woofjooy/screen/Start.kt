package com.woofjooy.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.woofjooy.R
import com.woofjooy.ui.theme.WoofJooyTheme

class Start : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofJooyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaInicial("Android")
                }
            }
        }
    }
}

@Composable
fun TelaInicial(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp)
            .background(color = colorResource(R.color.rosa_escuro)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        Image(
            painter = painterResource(id = R.mipmap.figura_inicio),
            contentDescription = stringResource(id = R.string.contentDescription_img_logo),
            modifier = Modifier.size(250.dp)
        )
        Image(
            painter = painterResource(id = R.mipmap.logo_branca),
            contentDescription = stringResource(id = R.string.contentDescription_img_logo),
            modifier = Modifier.size(150.dp).padding(0.dp)
        )


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview4() {
    WoofJooyTheme {
        TelaInicial("Android")
    }
}