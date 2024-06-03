package com.woofjooy.fragmentos

import androidx.compose.runtime.Composable
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.woofjooy.R
import com.woofjooy.components.InputSelect
import com.woofjooy.components.Title
import com.woofjooy.datas.Servico

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun MeuServicos(extras: Bundle?, name: String = "Home") {
    val servicos = remember { mutableStateListOf<Servico>() }
    val ordenacao = remember {
        mutableStateOf("")
    }
    val options =
        listOf<String>("Aguardando Inicio", "Aguardando Confimação", "Em Andamento", "Concluído")


    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {

        Row (
            modifier = Modifier.padding(10.dp),
        ){
            Title(stringResource(R.string.title_meus_servicos))
        }
        Row (
            modifier = Modifier.padding(15.dp)
        ){
            InputSelect(searchText = ordenacao, options = options, label = "Filtrar por:") {
                ordenacao.value = it
            }
        }



    }
    //CARDS
    LazyColumn {
        items(items = servicos) {

        }
    }


}
