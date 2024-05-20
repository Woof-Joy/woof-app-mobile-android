package com.woofjooy.client
import com.woofjooy.service.ServicesBack
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.18.32.81:8080/api"
    val instance: ServicesBack by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ServicesBack::class.java)
    }
}