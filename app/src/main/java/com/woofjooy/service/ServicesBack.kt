package com.woofjooy.service
import com.woofjooy.datas.Parceiro
import com.woofjooy.datas.ParceiroFeed
import com.woofjooy.datas.Usuario
import com.woofjooy.datas.UsuarioLogin
import com.woofjooy.datas.UsuarioLoginRespose
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServicesBack {
    @GET("parceiros")
    fun getParceiros(): Call<List<ParceiroFeed>>



    @GET("info/java")
    fun version(): Call<List<ParceiroFeed>>

    @GET("users/{id}")
    fun getUserById(@Path("id") userId: Int): Call<Usuario>

    // Cadastro
    @POST("users/{tipo}")
    fun cadastro(@Body user: UsuarioLogin, @Path("tipo") tipo: String): Call<UsuarioLogin>

    // Login
    @POST("users/login")
    fun login(@Body user: UsuarioLogin): Call<UsuarioLoginRespose>

    // PerfilParceiro
    @GET("parceiro/{id}")
    fun getParceiro(@Path("id") id: Int): Call<Parceiro>
}