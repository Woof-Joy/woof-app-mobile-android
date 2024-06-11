package com.woofjooy.viewModel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.woofjooy.client.RetrofitService
import com.woofjooy.datas.Relatorio
import com.woofjooy.screen.Home
import com.woofjooy.store.StoreRelatorio
import kotlinx.coroutines.launch

class RelatorioViewModel(token: String?) : ViewModel() {
    private val _relatorio = MutableLiveData<Relatorio>()
    val relatorios: LiveData<Relatorio> get() = _relatorio

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error
    val relatorioService = RetrofitService.getApiRelatorio(token)
    fun fetchRelatorio(idServico: Int, context:Context) {
        viewModelScope.launch {
            val response = relatorioService.postRelatorio(idServico)
            if (response.isSuccessful) {
                val storeRelatorio = StoreRelatorio.getInstance(context)
                storeRelatorio.saveRelatorio(response.body())
                val home: Intent = Intent(context, Home::class.java)
                context.startActivity(home)
                _relatorio.value = response.body()
            } else {
                // Handle error here
            }
        }
    }
}