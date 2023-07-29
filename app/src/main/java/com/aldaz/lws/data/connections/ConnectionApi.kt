package com.aldaz.lws.data.connections

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConnectionApi {
    enum class typeApi{
        Jikan,Marvel,Lws
    }

    private val API_JIKAN="https://api.jikan.moe/v4/"
    private val API_MARVEL="https://gateway.marvel.com/v1/public/"
    private val API_LWS="http://127.0.0.1:8080/API/Sema/V1/examenes/todos"
    private fun getConnection(base: String): Retrofit{
        var retrofit = Retrofit.Builder()
            .baseUrl(base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    suspend fun <T,E: Enum<E>> getService(api: E, service: Class<T>): T {
        var BASE=""
        when (api.name ){
            typeApi.Jikan.name->{
                BASE= API_JIKAN
            }
            typeApi.Marvel.name-> {
                BASE = API_MARVEL
            }
            typeApi.Lws.name -> {
                BASE = API_LWS
            }
        }
        return getConnection(BASE).create(service)
    }
}