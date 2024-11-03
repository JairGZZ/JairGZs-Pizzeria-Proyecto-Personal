package com.jair.jairgzspizzeria.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    private val _isReady = MutableLiveData<Boolean>()

    init {
        loadData()
    }

    private fun loadData() {
        // Simula la carga de datos con un retraso
        viewModelScope.launch {
            delay(3000) // Simula tiempo de carga (3 segundos)
            _isReady.value = true // Cambia el estado cuando los datos están listos
        }
}


}