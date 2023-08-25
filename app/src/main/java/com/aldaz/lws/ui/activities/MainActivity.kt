    package com.aldaz.lws.ui.activities

    import android.content.Intent
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
            viewModel = ViewModelProvider(this)[ExamenesViewModel::class.java]

            val adapter = LwsAdapter(emptyList(), { clickedExamen ->
                val examenNumero = clickedExamen.numero
//                viewModel.fetchDatos(examenNumero, binding.root) // Fetch the data using examenNumero

                // Navigate to DatosActivity with fetched data
                val intent = Intent(this, DatosActivity::class.java).apply {
                    putExtra("EXAMEN_NUMERO", examenNumero)
                }
                startActivity(intent)
            }, viewModel)

            binding.recyclerView.adapter = adapter
            binding.viewModel = viewModel // Set the ViewModel to the binding
            binding.lifecycleOwner = this // Set the lifecycle owner for LiveData observation

            viewModel.examenesList.observe(this) { examenes ->
                adapter.updateExamenes(examenes)
            }

            viewModel.fetchExamenes(binding.root)
        }
    }
