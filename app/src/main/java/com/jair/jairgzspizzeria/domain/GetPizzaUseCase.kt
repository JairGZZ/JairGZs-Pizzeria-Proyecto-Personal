package com.jair.jairgzspizzeria.domain

import com.jair.jairgzspizzeria.api.Pizza
import com.jair.jairgzspizzeria.data.model.PizzaRepository

class GetPizzaUseCase {
    private val repository = PizzaRepository()
    suspend operator fun invoke(): List<Pizza>? {

    return repository.getPizzas()
    }
}