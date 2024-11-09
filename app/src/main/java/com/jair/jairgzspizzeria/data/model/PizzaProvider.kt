package com.jair.jairgzspizzeria.data.model

import com.jair.jairgzspizzeria.api.Pizza

class PizzaProvider {
    companion object{
        var pizzas: List<Pizza> = emptyList()
    }
}