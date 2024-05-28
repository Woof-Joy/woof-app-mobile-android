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

interface ServicesBack {
    @GET("/parceiros")
    suspend fun getParceiros(): Response<Call<List<ParceiroFeed>>>

    @GET("info/java")
    suspend fun version(): Response<Call<List<ParceiroFeed>>>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") userId: Int): Response<Call<Usuario>>

    // Cadastro
    @POST("users/{tipo}")
    suspend fun cadastro(@Body user: UsuarioLogin, @Path("tipo") tipo: String): Response<Call<UsuarioLogin>>

    // Login
    @POST("users/login-mobile")
    fun login(@Body user: UsuarioLogin): Call<UsuarioLoginRespose>

    // PerfilParceiro
    @GET("parceiro/{id}")
    suspend fun getParceiro(@Path("id") id: Int): Response<Call<Parceiro>>
}