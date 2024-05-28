package com.woofjooy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.client.RetrofitService
import com.woofjooy.datas.Item
import com.woofjooy.datas.Parceiro
import com.woofjooy.datas.Servico
import com.woofjooy.datas.ParceiroFeed
import com.woofjooy.datas.ParceiroPerfil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun CreatorCardFeed(it: Any, novaTela:MutableState<Boolean>, parceiroPerfil: MutableState<ParceiroPerfil>) {
    when (it) {
        is  ParceiroFeed ->{
            print("Usuario")
            Card(id = it.idParceiro, titulo = "${it.nome} ${it.sobrenome}", localizacao = "${it.cidade}, ${it.uf}", descricao = it.descricao, servicos = mutableListOf(), novaTela, parceiroPerfil, it.qtdServicosPrestados)
        }
        is Item -> {
            print("Item")
            //Card(id = it.id, imagem = it.imagem, titulo = it.titulo, localizacao = formatEndereco(it.endereco), descricao = it.descricao, servicos = mutableListOf(), novaTela, parceiroPerfil, 0)
        }
    }
}

@Composable
fun Card(id: Int?, titulo:String, localizacao:String, descricao: String?, servicos: List<Servico>, novaTela:MutableState<Boolean>, parceiroPerfil: MutableState<ParceiroPerfil>, qtdServicos: Int?) { // Alterar o card para montar com base nos parametros
    val boxId = remember { mutableStateOf(id!!) }
    val parceiro = Parceiro()
    Box(
        modifier = Modifier
            .background(
                colorResource(R.color.rosa_claro),
                shape = RoundedCornerShape(40.dp)
            )
            .size(350.dp, 120.dp)
            .clickable {


            }
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.mipmap.imagem_perfil_test),
                    contentDescription = "",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 10.dp)
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                if (!servicos.isEmpty()) {
                    var textoServico = ""
                    servicos.forEach {
                        textoServico += "#${it.tipoServico} "
                    }
                    Text(
                        text = textoServico.trim(),
                        color = colorResource(R.color.rosa_escuro),
                        fontSize = 8.sp
                    )
                }
                Text(
                    text = titulo,
                    color = colorResource(R.color.preto),
                    fontSize = 16.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.mipmap.icone_ponto_localizacao),
                        contentDescription = "",
                        modifier = Modifier.size(8.dp)
                    )
                    Text(
                        text = localizacao,
                        color = colorResource(R.color.rosa_escuro),
                        fontSize = 8.sp
                    )
                }
                Text(
                    text = descricao!!,
                    color = colorResource(
                        R.color.preto
                    ),
                    fontSize = 8.sp,
                    style = TextStyle(lineHeight = 12.sp)
                )
            }
        }
    }
}