package com.aldaz.lws.data.endpoint

import com.aldaz.lws.data.entitties.lws.DatosItem
import com.aldaz.lws.data.entitties.lws.Examen
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {

    @GET("API/V1/Sema/examenes")
    suspend fun getExamenes(): Response<List<Examen>>

    @GET("API/V1/Sema/examenes/{numero}")
    suspend fun getDatos(@Path("numero") numero: String): Response<List<DatosItem>>
}