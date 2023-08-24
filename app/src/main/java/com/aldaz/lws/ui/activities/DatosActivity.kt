package com.aldaz.lws.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aldaz.lws.data.connections.ConnectionApi
import com.aldaz.lws.data.connections.ConnectionApi.getService

import com.aldaz.lws.data.endpoint.Endpoint
import com.aldaz.lws.data.entitties.lws.DatosItem
import com.aldaz.lws.databinding.ActivityListaDatosBinding
import com.aldaz.lws.databinding.ItemDatosBinding
import com.aldaz.lws.ui.viewholder.ExamenesViewModel


class DatosActivity : AppCompatActivity() {

    private lateinit var binding: ItemDatosBinding
    private lateinit var examenesViewModel: ExamenesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buscarExamenPorNumero()
    }

    private fun buscarExamenPorNumero(){
        examenesViewModel = ViewModelProvider(this).get(ExamenesViewModel::class.java)

        // Observe the LiveData for fetched datos
        examenesViewModel.datosList.observe(this) { fetchedDatos ->
            // Update your UI with the fetchedDatos here
            // For example, you can set text in TextViews
            binding.nombreTextView
            // ...and so on
        }


    }


}