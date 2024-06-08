package com.woofjooy.service

import com.woofjooy.datas.Parceiro
import com.woofjooy.datas.ParceiroFeed
import com.woofjooy.datas.Usuario
import com.woofjooy.datas.UsuarioLogin
import com.woofjooy.datas.UsuarioLoginRespose
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsuarioService {

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") userId: Int): Response<Usuario>

    // Cadastro
    @POST("users/{tipo}")
    suspend fun cadastro(@Body user: UsuarioLogin, @Path("tipo") tipo: String): Response<UsuarioLogin>

    // Login
    @POST("users/login-mobile")
    fun login(@Body user: UsuarioLogin): Response<UsuarioLoginRespose>


}