package com.jair.jairgzspizzeria.network

import com.jair.jairgzspizzeria.api.Pizza
import com.jair.jairgzspizzeria.core.RetrofitHelper
import com.jair.jairgzspizzeria.data.model.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PizzaService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPizzas(): List<Pizza> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getPizzas()
             response.body()?.pizzas ?: emptyList()
        }
    }

}