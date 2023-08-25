package com.aldaz.lws.ui.activities

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.lifecycle.ViewModelProvider
import com.aldaz.lws.data.connections.ConnectionApi
import com.aldaz.lws.data.connections.ConnectionApi.getService

import com.aldaz.lws.data.endpoint.Endpoint
import com.aldaz.lws.data.entitties.lws.DatosItem
import com.aldaz.lws.databinding.ActivityListaDatosBinding
import com.aldaz.lws.databinding.DatosBinding
import com.aldaz.lws.databinding.ItemDatosBinding
import com.aldaz.lws.ui.adapters.DatosAdapter
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
        enviar()
    }

    private fun buscarExamenPorNumero(){
        val examenNumero = intent.getStringExtra("EXAMEN_NUMERO")
        examenesViewModel = ViewModelProvider(this)[ExamenesViewModel::class.java]

        val adapter = DatosAdapter(emptyList())
        binding.recyclerView.adapter = adapter
        binding.viewModel = examenesViewModel
        binding.lifecycleOwner = this


        examenesViewModel.datosList.observe(this) { fetchedDatos ->
            adapter.updateDatos(fetchedDatos)
        }
        if (examenNumero != null) {
            examenesViewModel.fetchDatos(examenNumero)
        }

    }

    private fun regresar(){
        binding.backButton.setOnClickListener() {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun enviar(){
        binding.capture.setOnClickListener(){
            val bitmap = Bitmap.createBitmap(
                binding.recyclerView.width,
                binding.recyclerView.height,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            binding.recyclerView.draw(canvas)

            val imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ContentValues())
            val outputStream = contentResolver.openOutputStream(imageUri!!)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream?.close()

            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.setPackage("com.whatsapp")
            sendIntent.putExtra(Intent.EXTRA_STREAM, imageUri)
            sendIntent.type = "image/*"
            sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(sendIntent)
        }
    }



}