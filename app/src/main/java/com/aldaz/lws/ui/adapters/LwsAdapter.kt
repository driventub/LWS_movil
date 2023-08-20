package com.aldaz.lws.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aldaz.lws.data.entitties.lws.DatosItem
import com.aldaz.lws.databinding.DatosBinding
import com.example.yourapp.databinding.ItemExamenBinding

class LwsAdapter(
    private var datos: List<DatosItem>,
    private var fnClick: (DatosItem) -> Unit
) : RecyclerView.Adapter<LwsAdapter.DatosViewHolder>() {

    class DatosViewHolder(private val binding: DatosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dato: DatosItem, fnClick: (DatosItem) -> Unit) {
            binding.dato = dato
            binding.executePendingBindings()

            itemView.setOnClickListener {
                fnClick(dato)
                // Implement your API fetching logic here when an item is clicked
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DatosBinding.inflate(inflater, parent, false)
        return DatosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DatosViewHolder, position: Int) {
        val dato = datos[position]
        holder.bind(dato, fnClick)
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    fun updateData(newData: List<DatosItem>) {
        datos = newData
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        // Implement if you have multiple view types
        return super.getItemViewType(position)
    }

    fun setOnItemClickListener(listener: (DatosItem) -> Unit) {
        fnClick = listener
    }
}
