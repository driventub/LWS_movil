package com.aldaz.lws.data.endpoint

import com.aldaz.lws.data.entitties.lws.Examen
import retrofit2.Response
import retrofit2.http.GET

interface Endpoint {

    @GET("API/V1/Sema/examenes")
    suspend fun getExamenes(): Response<List<Examen>>
}