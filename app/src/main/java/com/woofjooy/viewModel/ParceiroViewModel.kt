package com.woofjooy.viewModel

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.woofjooy.client.RetrofitService
import com.woofjooy.datas.ParceiroPerfil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//class ParceiroViewModel : ViewModel(){
//
//
//    val parceiroAtual = MutableLiveData(ParceiroPerfil())
//    val parceiros = MutableLiveData(SnapshotStateList<ParceiroPerfil>())
//
//    val apiBack = RetrofitService.getApi()
//    val erroApi = MutableLiveData("")
//
//    init {
//        carregarTodos()
//    }
//
//    fun carregarTodos() {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val response = apiBack.getParceiros()
//                if (response.isSuccessful) {
//                    parceiros.value!!.clear()
//                    parceiros.value!!.addAll(response.body() ?: emptyList())
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
//}