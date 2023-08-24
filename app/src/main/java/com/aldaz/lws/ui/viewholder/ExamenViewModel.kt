package com.aldaz.lws.ui.viewholder

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope // Import viewModelScope

import com.aldaz.lws.data.connections.ConnectionApi
import com.aldaz.lws.data.endpoint.Endpoint
import com.aldaz.lws.data.entitties.lws.DatosItem
import com.aldaz.lws.data.entitties.lws.Examen
import com.aldaz.lws.ui.adapters.LwsAdapter
import kotlinx.coroutines.launch // Import launch from kotlinx.coroutines

class ExamenesViewModel : ViewModel() {

    private val _examenesList = MutableLiveData<List<Examen>>()
    val examenesList: LiveData<List<Examen>> = _examenesList

    private val _datosList = MutableLiveData<List<DatosItem>>()
    val datosList :LiveData<List<DatosItem>> = _datosList
//    val adapter : LwsAdapter(emptyList()){}
    fun fetchExamenes() {
        viewModelScope.launch { // Use viewModelScope.launch
            try {
                val apiService = ConnectionApi.getService(ConnectionApi.typeApi.Lws, Endpoint::class.java)
                val response = apiService.getExamenes()
                if (response.isSuccessful) {
                    val fetchedData = response.body()
                    _examenesList.value = response.body()
                    Log.d("EXA", "Fetched ${fetchedData?.size} examenes ")
                } else {
                    Log.e("EXA", "Error fetching examenes: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("EXA", "Network error: ${e.message}")
            }
        }
    }

    fun fetchDatos(datos: String){
        viewModelScope.launch { // Use viewModelScope.launch
            try {
                val apiService = ConnectionApi.getService(ConnectionApi.typeApi.Lws, Endpoint::class.java)
                val response = apiService.getDatos(datos)
                if (response.isSuccessful) {
                    val fetchedData = response.body()
                    _datosList.value = response.body()
                    Log.d("EXA", "Fetched ${fetchedData?.size} datos ")
                } else {
                    Log.e("EXA", "Error fetching datos: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("EXA", "Network error: ${e.message}")
            }
        }
    }
}
