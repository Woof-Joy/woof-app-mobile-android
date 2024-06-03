package com.woofjooy.client
import com.woofjooy.service.CardService
import com.woofjooy.service.ServicesBack
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    const val BASE_URL = "http://100.28.61.16/api/"
    fun getApi(): ServicesBack {
        val cliente =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ServicesBack::class.java)

        return cliente
    }

    fun getApiCard(): CardService {
        val response =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CardService::class.java)

        return response
    }
}