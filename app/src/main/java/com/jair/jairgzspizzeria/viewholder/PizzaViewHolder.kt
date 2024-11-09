package com.jair.jairgzspizzeria.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jair.jairgzspizzeria.R
import com.jair.jairgzspizzeria.api.Pizza
import com.jair.jairgzspizzeria.databinding.ItemPizzaBinding

class PizzaViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_pizza, parent, false)) {

    private val binding = ItemPizzaBinding.bind(itemView)
    private val description: TextView = binding.tvPizzaDescription
    private val image: ImageView = binding.ivPizza
    private val name: TextView = binding.tvPizzaName  // Asegúrate de que 'tvPizzaName' sea correcto en el XML

    fun bind(pizza: Pizza) {
        // Usa todas las propiedades del objeto Pizza para inicializar las vistas
        name.text = pizza.name
        description.text = pizza.description
        Glide.with(itemView.context).load(pizza.image).into(image)
    }
}
