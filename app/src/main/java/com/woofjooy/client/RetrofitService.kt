package com.woofjooy.client
import com.google.gson.GsonBuilder
import com.woofjooy.datas.Relatorio
import com.woofjooy.service.CardService
import com.woofjooy.service.ImagemService
import com.woofjooy.service.ParceiroService
import com.woofjooy.service.RelatorioService
import com.woofjooy.service.ServicesBack
import com.woofjooy.service.UsuarioService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    const val BASE_URL = "http://100.28.61.16/api/"

    private val okHttpClient: OkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        builder.build()
    }

    private fun <T> createApiService(apiClass: Class<T>, token: String? = null): T {
        val client = if (token != null) {
            okHttpClient.newBuilder().addInterceptor { chain ->
                val originalRequest = chain.request()
                val authenticatedRequest = originalRequest.newBuilder()
                    .header("Authorization", "Bearer $token")
                    .build()
                chain.proceed(authenticatedRequest)
            }.build()
        } else {
            okHttpClient
        }

        var gson = GsonBuilder()
            .disableHtmlEscaping()
            .create()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(apiClass)
    }

    fun getApiParceiro(token: String?): ParceiroService {
        return createApiService(ParceiroService::class.java, token)
    }

    fun getApiUsuario(token: String?): UsuarioService {
        return createApiService(UsuarioService::class.java, token)
    }

    fun getApiServico(token: String?): CardService {
        return createApiService(CardService::class.java, token)
    }

    fun getApiImagem(token: String?): ImagemService {
        return createApiService(ImagemService::class.java, token)
    }

    fun getApiCard(token: String?): CardService {
        return createApiService(CardService::class.java, token)
    }

    fun getApi(token: String?): ServicesBack {
        return createApiService(ServicesBack::class.java, token)
    }

    fun getApiRelatorio(token: String?): RelatorioService {
        return createApiService(RelatorioService::class.java, token)
    }



}