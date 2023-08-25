package com.aldaz.lws.ui.viewholder

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope // Import viewModelScope

import com.aldaz.lws.data.connections.ConnectionApi
import com.aldaz.lws.data.endpoint.Endpoint
import com.aldaz.lws.data.entitties.lws.DatosItem
import com.aldaz.lws.data.entitties.lws.Examen
import com.aldaz.lws.databinding.ActivityMainBinding
import com.aldaz.lws.ui.adapters.LwsAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch // Import launch from kotlinx.coroutines

class ExamenesViewModel : ViewModel() {

    private val _examenesList = MutableLiveData<List<Examen>>()
    val examenesList: LiveData<List<Examen>> = _examenesList
    

    private val _datosList = MutableLiveData<List<DatosItem>>()
    val datosList :LiveData<List<DatosItem>> = _datosList
//    val adapter : LwsAdapter(emptyList()){}

//    Necesario utilizar la buscando de donde utilizo 
    fun fetchExamenes(vista: View) {

        viewModelScope.launch { // Use viewModelScope.launch
            try {
                val apiService = ConnectionApi.getService(ConnectionApi.typeApi.Lws, Endpoint::class.java)
                val response = apiService.getExamenes()
                if (response.isSuccessful) {
                    val fetchedData = response.body()
                    _examenesList.value = response.body()
                    val snackbarMessage = "Se encontraron: ${fetchedData?.size} examenes"
                    Log.d("EXA", snackbarMessage)
                    Snackbar.make(vista, snackbarMessage, Snackbar.LENGTH_LONG).show()
                } else {
                    val noEncontrado = "Error buscando examenes: ${response.code()}"
                    Log.e("EXA", noEncontrado)
                    Snackbar.make(vista, noEncontrado, Snackbar.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                val errorRed = "Network error: ${e.message}"
                Log.e("EXA", errorRed)
                Snackbar.make(vista, errorRed, Snackbar.LENGTH_LONG).show()
            }
        }
    }

    fun fetchDatos(datos: String, vista: View){
        viewModelScope.launch { // Use viewModelScope.launch
            try {
                val apiService = ConnectionApi.getService(ConnectionApi.typeApi.Lws, Endpoint::class.java)
                val response = apiService.getDatos(datos)
                if (response.isSuccessful) {

                    val fetchedData = response.body()
                    val exito  = "Se encontraron: ${fetchedData?.size} datos "
                    _datosList.value = response.body()
                    Log.d("EXA",exito )
                    Snackbar.make(vista, exito, Snackbar.LENGTH_LONG).show()
                } else {
                    val error = "Error buscando datos: ${response.code()}"
                    Log.e("EXA",error )
                    Snackbar.make(vista, error, Snackbar.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                val error = "Network error: ${e.message}"
                Log.e("EXA", error)
                Snackbar.make(vista, error, Snackbar.LENGTH_LONG).show()
            }
        }
    }
}
