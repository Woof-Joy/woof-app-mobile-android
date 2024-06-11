package com.woofjooy.viewModel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.woofjooy.client.RetrofitService
import com.woofjooy.datas.Servico
import com.woofjooy.screen.Home
import com.woofjooy.store.StoreServicos
import kotlinx.coroutines.launch

class ServicoViewModel(token:String?) : ViewModel(){
    private val _servico = MutableLiveData<Servico>()
    val servico: LiveData<Servico> get() = _servico

    private val _servicos = MutableLiveData<List<Servico>>()
    val servicos: LiveData<List<Servico>> get() = _servicos

    private val _deleteResult = MutableLiveData<Boolean>()
    val deleteResult: LiveData<Boolean> get() = _deleteResult
    val cardService = RetrofitService.getApiServico(token)
    fun getServicoById(id: Int) {
        viewModelScope.launch {
            val response = cardService.getServicoById(id)
            if (response.isSuccessful)
                _servico.value = response.body()
            else {
                // Handle error here
            }
        }
    }

    fun getAll(context:Context) {
        viewModelScope.launch {
            val response = cardService.getAll()
            if (response.isSuccessful) {
                val storeServicos = StoreServicos.getInstance(context)
                response.body()?.let { storeServicos.saveServicos(it) }
                _servicos.value = response.body()
            } else {
                // Handle error here
            }
        }
    }

    fun delete(id: Int, context: Context) {
        viewModelScope.launch {
            val home: Intent = Intent(context, Home::class.java)
            val response = cardService.delete(id)
            _deleteResult.value = response.isSuccessful
            context.startActivity(home)
        }
    }



}