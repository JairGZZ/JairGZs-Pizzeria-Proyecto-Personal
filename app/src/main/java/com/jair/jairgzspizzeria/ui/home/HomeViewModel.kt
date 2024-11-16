package com.jair.jairgzspizzeria.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jair.jairgzspizzeria.R
import com.jair.jairgzspizzeria.model.PizzaModel

class HomeViewModel : ViewModel() {

    private val _pizzaList = MutableLiveData<List<PizzaModel>>()
    val pizzaList: LiveData<List<PizzaModel>> get() = _pizzaList

    init {
        loadPizzas()
    }

    private fun loadPizzas() {
        // Inicializa la lista de pizzas
        _pizzaList.value = listOf(
            PizzaModel("Hola", R.drawable.pizza_chorizo),
            PizzaModel("Pizza Continental", R.drawable.pizza_continental),
            PizzaModel("Pizza Vegetariana", R.drawable.pizza_mozzarella),
            PizzaModel("Pizza Hawaiana", R.drawable.pizza_meat_lovers),
            PizzaModel("Pizza Pepperoni", R.drawable.pizza_chorizo),
            PizzaModel("Pizza Salami", R.drawable.pizza_chorizo)
        )
    }
}