package com.jair.jairgzspizzeria

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.jair.jairgzspizzeria.adapter.PizzaAdapter
import com.jair.jairgzspizzeria.databinding.HomeActivityBinding
import com.jair.jairgzspizzeria.model.PizzaModel

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
        val listaPizza3 = PizzaModel("Pizza Vegetariana",R.drawable.pizza_mozzarella)


        val lista = listOf(listaPizza,listaPizza2,listaPizza3)


        val adapter = PizzaAdapter(lista)

        binding.recyclerPizza.adapter = adapter
        binding.recyclerPizza.layoutManager = GridLayoutManager(this,1)






    }
}
