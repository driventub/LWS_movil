package com.aldaz.lws.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldaz.lws.data.entitties.lws.DatosItem

class LwsAdapter(private var datos: List<DatosItem>,private var fnClick: (DatosItem) -> Unit)
    :RecyclerView.Adapter<LwsAdapter.DatosViewHolder>(){

        class DatosViewHolder(view: View): RecyclerView.ViewHolder(view){
            private val binding:
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatosViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DatosViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}