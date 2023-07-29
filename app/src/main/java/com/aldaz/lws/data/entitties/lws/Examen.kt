package com.aldaz.lws.data.entitties.lws

data class Examen(
    val fecha: String,
    val id: Int,
    val numero: String,
    val paciente: Paciente,
    val usuario: Usuario
)