package com.aldaz.lws.data.entitties.lws

data class DatosItem(
    val id: Int,
    val nombre: String,
    val referencia: String,
    val tipo: Tipo,
    val valMax: Double,
    val valMin: Double,
    val valor: Double
)