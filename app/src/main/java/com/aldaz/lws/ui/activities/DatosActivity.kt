package com.aldaz.lws.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aldaz.lws.data.connections.ConnectionApi
import com.aldaz.lws.data.connections.ConnectionApi.getService

import com.aldaz.lws.data.endpoint.Endpoint
import com.aldaz.lws.data.entitties.lws.DatosItem
import com.aldaz.lws.databinding.ActivityListaDatosBinding
import com.aldaz.lws.databinding.DatosBinding
import com.aldaz.lws.databinding.ItemDatosBinding
import com.aldaz.lws.ui.viewholder.ExamenesViewModel


class DatosActivity : AppCompatActivity() {

//    private lateinit var binding: ItemDatosBinding
    private lateinit var binding: ActivityListaDatosBinding
    private lateinit var examenesViewModel: ExamenesViewModel
//    private lateinit var bindingDatos: DatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buscarExamenPorNumero()
        regresar()
    }

    private fun buscarExamenPorNumero(){
        examenesViewModel = ViewModelProvider(this).get(ExamenesViewModel::class.java)

        // Observe the LiveData for fetched datos
        examenesViewModel.datosList.observe(this) { fetchedDatos ->
            // Update your UI with the fetchedDatos here
            // For example, you can set text in TextViews

            // ...and so on
        }


    }

    private fun regresar(){
        binding.backButton.setOnClickListener() {
            // Navigate back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: Close this activity
        }
    }

}