package com.woofjooy.service

import com.woofjooy.datas.Relatorio
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RelatorioService {
    @GET("/relatorio/{idServico}")
    suspend fun postRelatorio(@Path("idServico") idServico:Int): Response<Relatorio>
}