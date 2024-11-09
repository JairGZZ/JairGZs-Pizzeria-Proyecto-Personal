package com.jair.jairgzspizzeria.data.model

import com.jair.jairgzspizzeria.api.PizzaResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("/.json")
     suspend fun    getPizzas( ): Response<PizzaResponse>

}