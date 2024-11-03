package com.jair.jairgzspizzeria.viewmodels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    private lateinit var auth: FirebaseAuth

    val userLoginError = MutableLiveData<Boolean>()
    val userLoginFirebase = MutableLiveData<Boolean>()


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    // Inicia la "carga" simulada
    fun startLoading() {
        _isLoading.value = true
        // Usa un hilo para simular carga
        viewModelScope.launch {
            delay(400) // Pausa 3 segundos para simular carga
            _isLoading.value = false // Termina la carga
        }
    }

    fun login(correo:String,contraseña:String){
        if (correo.isEmpty() || contraseña.isEmpty()){

            userLoginError.value = false
        }else if (contraseña.length <2){
            userLoginError.value = false

        }else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            userLoginError.value = false
        }else {
            userLoginFirebase(correo,contraseña)
        }
    }

    private fun userLoginFirebase(correo: String, contraseña: String) {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(correo,contraseña).addOnCompleteListener{
            userLoginFirebase.value = it.isSuccessful
        }



    }



}