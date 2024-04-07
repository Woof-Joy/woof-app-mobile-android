package com.woofjooy.service
import com.woofjooy.datas.Cliente
import com.woofjooy.datas.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServicesBack {
    @GET("users")
    fun listUsers(): Call<List<Usuario>>

    @GET("users/{id}")
    fun getUserById(@Path("id") userId: Int): Call<Cliente>
}