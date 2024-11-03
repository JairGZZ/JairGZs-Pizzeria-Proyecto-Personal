package com.jair.jairgzspizzeria.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jair.jairgzspizzeria.R
import com.jair.jairgzspizzeria.databinding.ItemPizzaBinding
import com.jair.jairgzspizzeria.model.PizzaModel

class PizzaViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(
    R.layout.item_pizza, parent, false))  {

    val binding = ItemPizzaBinding.bind(itemView)

    private var description: TextView? = null
    private var image: ImageView? = null

    init {
        description = binding.tvPizzaDescription
        image = binding.ivPizza

    }
    fun bind(pizza: PizzaModel){
        description?.text = pizza.description
        image?.setImageResource(pizza.image)
    }
}