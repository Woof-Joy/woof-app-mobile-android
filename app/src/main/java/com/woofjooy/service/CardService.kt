package com.woofjooy.service

import com.woofjooy.datas.Servico
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path


interface CardService{
    @GET("/servicos/{id}")
    suspend fun getServicoById(@Path("id") id: Int): Response<Servico>

    @GET("/servicos")
    suspend fun getAll(): Response<List<Servico>>

    @DELETE("/servicos/{id}")
    suspend fun delete(@Path("id") id: Int): Response<Void>


}