package com.woofjooy.screen

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.woofjooy.client.RetrofitClient
import com.woofjooy.components.CreatorCardFeed
import com.woofjooy.components.Input
import com.woofjooy.components.InputSelect
import com.woofjooy.components.Title
import com.woofjooy.datas.Usuario
import com.woofjooy.ui.theme.ui.theme.WoofJooyTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Feed : ComponentActivity() {
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
                    TelaFeed(extras)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun TelaFeed(extras: Bundle?) {
    val parceiros = remember { mutableStateListOf<Usuario>() }
    val expandida = remember { mutableStateOf(false) }
    val filtroPesquisa = remember {
        mutableStateOf("")
    }
    val filtroTipoServico = remember { mutableStateOf("") }
    val ordenacao = remember {
        mutableStateOf("")
    }
    val usuario = extras?.getSerializable("dataUser", Usuario::class.java)


    RetrofitClient.instance.getParceiros().enqueue(object : Callback<List<Usuario>> {
        override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
            if (response.isSuccessful) {
                val lista = response.body()
                if (lista != null) {
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

        ) {

        //DESENVOLVER PARTE SUPERIOR COM OS FILTROS...
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Title(stringResource(id = R.string.title_activity_feed))
            }
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.mipmap.lupa),
                        contentDescription = "",
                        modifier = Modifier.size(10.dp)
                    )
                    Input(
                        valCampo = filtroPesquisa,
                        placeholder = stringResource(id = R.string.placeholder_search),
                        fontSize = 8.sp,
                        modifier = Modifier
                            .width(230.dp)
                            .padding(10.dp)
                            .background(
                                color = colorResource(R.color.cinza_legenda),
                                shape = RoundedCornerShape(15.dp)
                            )
                    )
                }
                Row {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(6.dp)
                    ) {
                        Text(text = stringResource(id = R.string.text_location), fontSize = 8.sp)
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(R.mipmap.localizacao_black),
                                contentDescription = stringResource(
                                    id = R.string.contentDescription_img_location
                                ),
                                modifier = Modifier
                                    .size(8.dp)
                                    .padding(1.dp)
                            )
                            Text(text = "Centro, São Paulo", fontSize = 8.sp)
                        }
                    }
                    InputSelect(
                        searchText = filtroTipoServico,
                        options = listOf(
                            stringResource(id = R.string.selectBox_tipo_servico1),
                            stringResource(id = R.string.selectBox_tipo_servico2),
                            stringResource(id = R.string.selectBox_tipo_servico3)
                        ),
                        label = stringResource(id = R.string.label_selectBox_tipo_servico)
                    ) {
                        filtroTipoServico.value = it
                    }
                    InputSelect(
                        searchText = ordenacao,
                        options = listOf("", "", ""),
                        label = stringResource(id = R.string.label_selectBox_ordenacao_servico)
                    ) {
                        ordenacao.value = it
                    }

                }
            }
        }

        //CARDS
        LazyColumn {
            items(items = parceiros) {
                CreatorCardFeed(it = it)//falta adicionar atributos como lista de users, tipo de card(pensando em reaproveitar código), etc..
            }

        }


    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    WoofJooyTheme {
        TelaFeed(null)
    }
}