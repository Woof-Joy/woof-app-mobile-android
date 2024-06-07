package com.woofjooy.service

import com.woofjooy.datas.Parceiro
import com.woofjooy.datas.ParceiroFeed
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ParceiroService {
    @GET("/parceiros")
    suspend fun getParceiros(): Response<Call<List<ParceiroFeed>>>

    // PerfilParceiro
    @GET("parceiro/{id}")
    suspend fun getParceiro(@Path("id") id: Int): Response<Call<Parceiro>>
}