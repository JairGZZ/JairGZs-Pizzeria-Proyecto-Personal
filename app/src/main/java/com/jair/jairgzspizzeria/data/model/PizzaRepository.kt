package com.jair.jairgzspizzeria.data.model

import com.jair.jairgzspizzeria.api.Pizza
import com.jair.jairgzspizzeria.network.PizzaService

class PizzaRepository {
    private val api = PizzaService()
    suspend fun getPizzas(): List<Pizza> {
        val response = api.getPizzas()
        PizzaProvider.pizzas = response
        return response
    }

}