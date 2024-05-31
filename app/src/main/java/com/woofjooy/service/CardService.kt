package com.woofjooy.service

import com.woofjooy.datas.ParceiroFeed
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CardService {
    @GET("ficha/parceiro/{user-id}")
    suspend fun getServicos(@Path("user-id") userId:String) : Response<Call<List<ParceiroFeed>>>

}