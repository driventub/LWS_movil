package com.aldaz.lws.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldaz.lws.R
import com.aldaz.lws.databinding.ActivityListaExamenesBinding

class ListaExamenesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaExamenesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaExamenesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buscarTodosExamenes()
    }

    private fun buscarTodosExamenes(){

    }


}