package com.woofjooy.service
import com.woofjooy.datas.Cliente
import com.woofjooy.datas.Usuario
import com.woofjooy.datas.UsuarioLogin
import com.woofjooy.datas.UsuarioLoginRespose
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServicesBack {
    @GET("/parceiros")
    fun getParceiros(): Call<List<Usuario>>

    @GET("users/{id}")
    fun getUserById(@Path("id") userId: Int): Call<Usuario>

    //Cadastro
    @POST("/users/{tipo}")
    fun cadastro(user:UsuarioLogin, @Path("tipo") tipo:String):Call<UsuarioLogin>

    //Login
    @POST("users/login")
    fun login(user:UsuarioLogin):Call<UsuarioLoginRespose>

}