package com.aldaz.lws.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aldaz.lws.databinding.ActivityMainBinding
import com.aldaz.lws.ui.adapters.LwsAdapter
import com.aldaz.lws.ui.viewholder.ExamenesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: ExamenesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ExamenesViewModel::class.java)

        val adapter = LwsAdapter(emptyList(), { clickedExamen ->
            // Handle item click
//            val examenNumero = clickedExamen.numero
            // Fetch the data using examenNumero and viewModel.fetchDatos(examenNumero)
        }, viewModel)

        binding.recyclerView.adapter = adapter
        binding.viewModel = viewModel // Set the ViewModel to the binding
        binding.lifecycleOwner = this // Set the lifecycle owner for LiveData observation

        viewModel.examenesList.observe(this) { examenes ->
            adapter.updateExamenes(examenes)
        }

        viewModel.fetchExamenes()
    }
}
