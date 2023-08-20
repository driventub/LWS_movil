package com.aldaz.lws.data.dao.lws

import com.aldaz.lws.data.entitties.lws.DatosItem
import retrofit2.http.GET
import retrofit2.http.Query


interface LwsChardDAO {

//    @Query(select * from LwsChars)
    @GET("/examenes")
    fun buscarTodos() : List<DatosItem>

}