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
import com.woofjooy.client.RetrofitClient
import com.woofjooy.datas.Endereco
import com.woofjooy.datas.Item
import com.woofjooy.datas.Parceiro
import com.woofjooy.datas.Servico
import com.woofjooy.datas.ParceiroFeed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun formatEndereco(end:Endereco):String{
    return "${end.bairro.capitalize()}, ${end.estado}"
}

@Composable
fun CreatorCardFeed(it: Any) {
    when (it) {
        is  ParceiroFeed ->{
            print("Usuario")
            Card(id = it.idParceiro, imagem = it.imgParceiro, titulo = "${it.nome} ${it.sobrenome}", localizacao = "${it.cidade}, ${it.uf}", descricao = it.descricao, servicos = mutableListOf())
        }
        is Item -> {
            print("Item")
            Card(id = it.id, imagem = it.imagem, titulo = it.titulo, localizacao = formatEndereco(it.endereco), descricao = it.descricao, servicos = mutableListOf())
        }
    }
}

@Composable
fun Card(id: Int?, imagem: String?, titulo:String, localizacao:String, descricao: String?, servicos: List<Servico>) { // Alterar o card para montar com base nos parametros
    val boxId = remember { mutableStateOf(id!!) }
    val parceiro = Parceiro()
    Box(
        modifier = Modifier
            .background(
                colorResource(R.color.rosa_claro),
                shape = RoundedCornerShape(40.dp)
            )
            .size(350.dp, 120.dp)
            .clickable() {
                RetrofitClient.instance
                    .getParceiro(boxId.value)
                    .enqueue(object :
                        Callback<Parceiro> {
                        override fun onResponse(
                            call: Call<Parceiro>,
                            response: Response<Parceiro>
                        ) {
                            if (response.isSuccessful) {
                            val parceiroResponse = response.body()
                            if (parceiroResponse != null){
                                parceiro.copy(
                                    idUser = parceiroResponse.idUser,
                                    nome = parceiroResponse.nome,
                                    aceitaDogBravo = parceiroResponse.aceitaDogBravo,
                                    aceitaDogCio = parceiroResponse.aceitaDogCio,
                                    aceitaDogEspecial = parceiroResponse.aceitaDogEspecial,
                                    aceitaDogGrande = parceiroResponse.aceitaDogGrande,
                                    aceitaDogIdoso = parceiroResponse.aceitaDogIdoso,
                                    dataEntrada = parceiroResponse.dataEntrada,
                                    imgParceiro = parceiroResponse.imgParceiro,
                                    maxDogs = parceiroResponse.maxDogs,
                                    servicos = parceiroResponse.servicos,
                                )
                            }
                            } else {
                                print("Erro ao tentar executar a função")
                            }
                        }

                        override fun onFailure(call: Call<Parceiro>, t: Throwable) {
                            TODO("Not yet implemented")
                        }
                    })
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