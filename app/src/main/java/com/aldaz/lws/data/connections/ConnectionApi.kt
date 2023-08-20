package com.aldaz.lws.data.connections

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConnectionApi {
    enum class typeApi{
        Lws
    }


    private val API_LWS="http://127.0.0.1:8080/API/V1/Sema"
    private fun getConnection(base: String): Retrofit{
        var retrofit = Retrofit.Builder()
            .baseUrl(API_LWS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    suspend fun <T,E: Enum<E>> getService(api: E, service: Class<T>): T {
        var BASE=""
        when (api.name ){

            typeApi.Lws.name -> {
                BASE = API_LWS
            }
        }
        return getConnection(BASE).create(service)
    }
}