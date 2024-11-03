package com.jair.jairgzspizzeria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jair.jairgzspizzeria.adapter.PizzaAdapter
import com.jair.jairgzspizzeria.databinding.HomeActivityBinding
import com.jair.jairgzspizzeria.model.PizzaModel
import com.jair.jairgzspizzeria.viewmodels.LoginViewModel

class HomeActivity :AppCompatActivity(){
    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listaPizza = PizzaModel(
            "Hola",
            R.drawable.pizza_chorizo
        )
        val listaPizza2 = PizzaModel(
            "Pizza Continental",
            R.drawable.pizza_continental
        )

        val lista = listOf(listaPizza,listaPizza2)


        val adapter = PizzaAdapter(lista)

        binding.recyclerPizza.adapter = adapter
        binding.recyclerPizza.layoutManager = GridLayoutManager(this,1)






    }
}
