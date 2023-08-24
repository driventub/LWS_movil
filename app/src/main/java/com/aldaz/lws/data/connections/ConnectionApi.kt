package com.aldaz.lws.data.connections

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConnectionApi {
    enum class typeApi{
        Lws
    }

//  la direccion ip tiene que ser de donde se esta corriendo
    private val API_LWS="http://192.168.100.7:8080/"
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