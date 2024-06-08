package com.woofjooy.viewModel

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.woofjooy.client.RetrofitService
import com.woofjooy.datas.ParceiroPerfil
import com.woofjooy.datas.UsuarioLogin
import com.woofjooy.datas.UsuarioLoginRespose
import com.woofjooy.screen.Home
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel(token:String?) : ViewModel() {
    val parceiroAtual = MutableLiveData(ParceiroPerfil())
    val parceiros = MutableLiveData(SnapshotStateList<ParceiroPerfil>())
    var usuarioLoginResponse= UsuarioLoginRespose(token = "")
    val api = RetrofitService.getApiUsuario(token)
    val erroApi = MutableLiveData("")

//    init {
//        carregarTodos()
//    }
//
    fun login(usuarioLogin:UsuarioLogin, contexto:Context) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.login(usuarioLogin)
                if (response.isSuccessful) {
                    val usuarioResponse = response.body()
                    if (usuarioResponse != null){
                        usuarioLoginResponse = usuarioLoginResponse.copy(
                            userId = usuarioResponse.userId,
                            nome = usuarioResponse.nome,
                            email = usuarioResponse.email,
                            role = usuarioResponse.role,
                            token = usuarioResponse.token,
                            nomeCompleto = usuarioResponse.nomeCompleto,
                            cpf =usuarioResponse.cpf,
                            dataNasc = usuarioResponse.dataNasc,
                            descricao = usuarioResponse.descricao,
                            imgUsuario = usuarioResponse.imgUsuario,
                            senha = usuarioResponse.senha,
                            listItens = usuarioResponse.listItens,
                            cliente = usuarioResponse.cliente,
                            parceiro = usuarioResponse.parceiro
                        )
                        val home: Intent = Intent(contexto, Home::class.java)
                        home.putExtra("userToken", usuarioLoginResponse.token)
                        home.putExtra("dataUser", usuarioLoginResponse)
                        contexto.startActivity(home)
                    }
                } else {
                    print("Erro ao tentar executar a função")
                }
            } catch (e: Exception) {
                Log.e("api", "Deu ruim no get! ${e.message}")
                erroApi.postValue(e.message)
            }
        }
    }
//
//    fun atualizarAtual(filme: Filme) {
//        filmeAtual.value = filme
//    }
//
//    fun salvarAtualNaLista() {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val post = apiFilmes.post(filmeAtual.value!!)
//                if (post.isSuccessful) {
//                    carregarTodos()
//                } else {
//                    Log.e("api"," erro no post")
//                }
//            } catch (e:Exception) {
//                Log.e("api", "Erro no post de filmes: ${e.message}")
//            }
//        }
//
//    }
//
//    fun excluir(id:Int) {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val delete = apiFilmes.delete(id)
//                if (delete.isSuccessful) {
//                    filmes.value!!.removeIf { it.id == id }
//                } else {
//                    Log.e("api"," erro no delete")
//                }
//            } catch (e:Exception) {
//                Log.e("api", "Erro no delete de filmes: ${e.message}")
//            }
//        }
//    }
//
//    fun pesquisar(nome: String) {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val response = apiFilmes.getPorNome(nome)
//                if (response.isSuccessful) {
//                    filmes.value!!.clear()
//                    filmes.value!!.addAll(response.body() ?: emptyList())
//                } else {
//                    Log.e("api", "erro no get")
//                    erroApi.postValue(response.errorBody()!!.string())
//                }
//            } catch (e: Exception) {
//                Log.e("api", "Deu ruim no get! ${e.message}")
//                erroApi.postValue(e.message)
//            }
//        }
//    }
}