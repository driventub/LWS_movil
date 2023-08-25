package com.aldaz.lws.ui.adapters

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.aldaz.lws.data.entitties.lws.DatosItem
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("valorOutOfBounds")
    fun TextView.setValorTextColor(datosItem: DatosItem?) {
        if (datosItem != null) {
            val valor = datosItem.valor
            val valorMin = datosItem.valMin
            val valorMax = datosItem.valMax

            // Check if valor is out of bounds
            val isOutOfBounds = valor < valorMin || valor > valorMax

            // Set text color based on the condition
            val textColorRes = if (isOutOfBounds) android.R.color.holo_red_dark else android.R.color.black
            setTextColor(ContextCompat.getColor(context, textColorRes))
        }
    }
}