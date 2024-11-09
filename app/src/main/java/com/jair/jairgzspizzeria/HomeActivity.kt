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
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jair.jairgzspizzeria.adapter.PizzaAdapter
import com.jair.jairgzspizzeria.api.Pizza
import com.jair.jairgzspizzeria.databinding.HomeActivityBinding
import com.jair.jairgzspizzeria.domain.GetPizzaUseCase
import com.jair.jairgzspizzeria.network.PizzaService
import com.jair.jairgzspizzeria.viewmodels.LoginViewModel
import kotlinx.coroutines.launch

class HomeActivity :AppCompatActivity(){
    private lateinit var binding: HomeActivityBinding
    private val pizzaService = PizzaService()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.recyclerPizza.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val pizzaList: List<Pizza> = pizzaService.getPizzas()
            binding.recyclerPizza.adapter = PizzaAdapter(pizzaList)
        }





    }
}
