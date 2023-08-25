package com.aldaz.lws.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.aldaz.lws.data.entitties.lws.DatosItem
import com.aldaz.lws.data.entitties.lws.Examen
import com.aldaz.lws.databinding.ActivityMainBinding
import com.aldaz.lws.databinding.DatosBinding
import com.aldaz.lws.ui.activities.DatosActivity
import com.aldaz.lws.ui.viewholder.ExamenesViewModel


class LwsAdapter(
    private var examenes: List<Examen>,
    private var fnClick: (Examen) -> Unit,
    private val examenesViewModel: ExamenesViewModel
) : RecyclerView.Adapter<LwsAdapter.ExamenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamenViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DatosBinding.inflate(inflater, parent, false)
        return ExamenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExamenViewHolder, position: Int) {
        val examen = examenes[position]
        holder.bind(examen, fnClick)
    }

    override fun getItemCount(): Int = examenes.size

    inner class ExamenViewHolder(private val binding: DatosBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(examen: Examen, fnClick: (Examen) -> Unit) {
            binding.examen = examen
            binding.executePendingBindings()

            itemView.setOnClickListener {
                fnClick(examen)

//                examenesViewModel.fetchDatos(examen.numero, binding.root)

            }
        }
    }

    fun updateExamenes(newExamenes: List<Examen>) {
        examenes = newExamenes
        notifyDataSetChanged()
    }
}
