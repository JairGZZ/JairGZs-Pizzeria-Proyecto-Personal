package com.jair.jairgzspizzeria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.jair.jairgzspizzeria.viewmodels.LoginViewModel
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val loginViewMode: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()



        splashScreen.setKeepOnScreenCondition{
            loginViewMode.isLoading.value == true

        }
        loginViewMode.startLoading()

        loginViewMode.isLoading.observe(this, Observer { isLoading ->
            if (!isLoading) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        })





//        loginViewMode.mensaje.observe(this, Observer { newMensaje ->
//            findViewById<TextView>(R.id.tvMain).text = newMensaje
//        })


        }
    }

