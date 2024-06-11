package com.woofjooy.fragmentos

import androidx.compose.runtime.Composable
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.woofjooy.R
import com.woofjooy.components.Card
import com.woofjooy.components.InputSelect
import com.woofjooy.components.Title
import com.woofjooy.datas.Servico
import com.woofjooy.datas.ServicoOld
import com.woofjooy.store.StoreServicos
import com.woofjooy.viewModel.ServicoViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun MeuServicos(extras: Bundle?, name: String = "Home") {
    val servicos = remember { mutableStateListOf<Servico>() }
    val ordenacao = remember {
        mutableStateOf("")
    }
    val options =
        listOf<String>("Aguardando Inicio", "Aguardando Confimação", "Em Andamento", "Concluído")
    val relatorioAberto = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val servicoViewModel = ServicoViewModel(null)
    val coroutineScope = rememberCoroutineScope()
    val storeServicos = StoreServicos.getInstance(context)
    servicoViewModel.getAll(context)
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            storeServicos.getServicos.collect { retrievedServico ->
                servicos.clear()
                servicos.addAll(retrievedServico)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {

        Row(
            modifier = Modifier.padding(10.dp),
        ) {
            Title(stringResource(R.string.title_meus_servicos))
        }
        Row(
            modifier = Modifier.padding(15.dp)
        ) {
            InputSelect(searchText = ordenacao, options = options, label = "Filtrar por:") {
                ordenacao.value = it
            }
        }

        Column {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(
                    items = servicos
                ) {
                    Card(
                        it,
                        funPatch = fun() {
                            relatorioAberto.value = true

                        },
                        funDelete = fun() {
                            servicoViewModel.delete(it.id, context)
                        }

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }


    }

    //CARDS

}


//listOf<Servico>(
//Servico(
//status = "Aguardando Confirmação",
//dataInicio = LocalDateTime.now(),
//dataFim = LocalDateTime.now(),
//tipoServico = "Dog Walker",
//cliente = "Cliente Teste"
//),
//
//Servico(
//status = "Aguardando Confirmação",
//dataInicio = LocalDateTime.now(),
//dataFim = LocalDateTime.now(),
//tipoServico = "Dog Walker",
//cliente = "Cliente Teste"
//),
//
//Servico(
//status = "Aguardando Confirmação",
//dataInicio = LocalDateTime.now(),
//dataFim = LocalDateTime.now(),
//tipoServico = "Dog Walker",
//cliente = "Cliente Teste"
//),
//Servico(
//status = "Aguardando Confirmação",
//dataInicio = LocalDateTime.now(),
//dataFim = LocalDateTime.now(),
//tipoServico = "Dog Walker",
//cliente = "Cliente Teste"
//),
//)