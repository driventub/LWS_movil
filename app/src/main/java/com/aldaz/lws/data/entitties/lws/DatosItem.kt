package com.aldaz.lws.data.entitties.lws

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class DatosItem(
    val id: Int,
    val nombre: String,
    val referencia: String,
    val tipo: @RawValue Tipo,
    val valMax: Double,
    val valMin: Double,
    val valor: Double
): Parcelable