package com.jair.jairgzspizzeria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.jair.jairgzspizzeria.databinding.ActivityLoginBinding
import com.jair.jairgzspizzeria.viewmodels.LoginViewModel

class LoginActivity:AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnIngresar.setOnClickListener {

            val contraseña = binding.etContrasena.text.toString()
            val correo = binding.etCorreo.text.toString()
            loginViewModel.login(correo,contraseña)

        }
        loginViewModel.userLoginFirebase.observe(this) { success ->
            if(success) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }


//        button.setOnClickListener {
//            if(contra.text.toString() == "122345567" && correo.text.toString() == "jai@gmail.com"){
//                val intent = Intent(this,HomeActivity ::class.java)
//                startActivity(intent)
//
//            }else if (contra.text.toString().isEmpty() || correo.text.toString().isEmpty()){
//                showAlertDialog("Campos incompletos,","por favor complete todos los campos")
//
//                }
//            else{
//                showAlertDialog("No se pudo iniciar Sesion","Contraseña o correo incorrctos")
//            }
//        }





    }

    private fun showAlertDialog(title:String,message:String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)


        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
