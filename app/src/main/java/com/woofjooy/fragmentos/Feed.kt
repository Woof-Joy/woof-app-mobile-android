package com.woofjooy.fragmentos

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.client.RetrofitClient
import com.woofjooy.components.CreatorCardFeed
import com.woofjooy.components.Input
import com.woofjooy.components.InputSelect
import com.woofjooy.components.Title
import com.woofjooy.datas.ParceiroFeed
import com.woofjooy.datas.ParceiroPerfil
import com.woofjooy.datas.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Feed(extras: Bundle?, name: String="Home"){
    val parceiros = remember { mutableStateListOf<ParceiroFeed>() }
    val filtroPesquisa = remember {
        mutableStateOf("")
    }
    val filtroTipoServico = remember { mutableStateOf("") }
    val ordenacao = remember {
        mutableStateOf("")
    }
    val perfilUsuario = remember {
        mutableStateOf(false)
    }
    val parceiroPerfil = remember {
        mutableStateOf(ParceiroPerfil())
    }

    val usuario = extras?.getSerializable("dataUser", Usuario::class.java)
    val token = extras?.getInt("userToken")

    RetrofitClient.instance.getParceiros().enqueue(object : Callback<List<ParceiroFeed>> {
        override fun onResponse(call: Call<List<ParceiroFeed>>, response: Response<List<ParceiroFeed>>) {
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

        override fun onFailure(call: Call<List<ParceiroFeed>>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })


    if (!perfilUsuario.value){
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
                    Title("Feed")
                }
                Column {
                    Row (
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(painter = painterResource(R.mipmap.lupa), contentDescription = "", modifier = Modifier.size(10.dp))
                        Input(valCampo = filtroPesquisa,  placeholder = "Pesquise", fontSize=8.sp, modifier = Modifier
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
                            modifier= Modifier.padding(6.dp)
                        ) {
                            Text(text = "Sua localização", fontSize = 8.sp)
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                            ){
                                Image(painter = painterResource(R.mipmap.localizacao_black), contentDescription = "Icone para representar localização", modifier = Modifier
                                    .size(8.dp)
                                    .padding(1.dp))
                                Text(text = "Centro, São Paulo", fontSize = 8.sp)
                            }
                        }
                        InputSelect(searchText = filtroTipoServico, options = listOf("DogWalker", "DogSitter", "Ambos"), label = "Tipo de Serviço:") {
                            filtroTipoServico.value = it
                        }
                        InputSelect(searchText = ordenacao, options = listOf("", "", ""), label = "Ordenar por:") {
                            ordenacao.value = it
                        }

                    }
                }
            }

            //CARDS
            LazyColumn {
                items(items = parceiros){
                    CreatorCardFeed(it = it, perfilUsuario, parceiroPerfil)
                }

            }


        }
    }else{
        PerfilParceiro(
            nome = parceiroPerfil.value.nome,
            endereco = parceiroPerfil.value.localizacao,
            descricao = parceiroPerfil.value.descricao,
            servicos = parceiroPerfil.value.servicos
        )
    }




}