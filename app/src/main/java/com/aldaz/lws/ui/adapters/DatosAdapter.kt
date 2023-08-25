
package com.aldaz.lws.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldaz.lws.data.entitties.lws.DatosItem
import com.aldaz.lws.data.entitties.lws.Examen
import com.aldaz.lws.databinding.ItemDatosBinding

class DatosAdapter(
    private var datosItems: List<DatosItem>
) : RecyclerView.Adapter<DatosAdapter.DatosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDatosBinding.inflate(inflater, parent, false)
        return DatosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DatosViewHolder, position: Int) {
        val datosItem = datosItems[position]
        holder.bind(datosItem)
    }

    override fun getItemCount(): Int = datosItems.size

    inner class DatosViewHolder(private val binding: ItemDatosBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(datosItem: DatosItem) {
            binding.datosItem = datosItem
            binding.executePendingBindings()
        }
    }

    fun updateDatos(newDatos: List<DatosItem>) {
        datosItems = newDatos
        notifyDataSetChanged()
    }
}
