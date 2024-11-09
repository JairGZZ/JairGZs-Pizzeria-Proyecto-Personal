package com.jair.jairgzspizzeria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jair.jairgzspizzeria.api.Pizza
import com.jair.jairgzspizzeria.viewholder.PizzaViewHolder

class PizzaAdapter(  val listPizza: List<Pizza>): RecyclerView.Adapter<PizzaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PizzaViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {

        return listPizza.size
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = listPizza[position]
        if (pizza != null) {
            holder.bind(pizza)
        }
    }


}

//fun main(){
//    val array = intArrayOf(2,11,15,20,39,7)
//
//
//    val suma = twoSum(array,9)
//    println(suma.contentToString())




//}
fun recorrerHashmap(hashMap: HashMap<String,String>){
    for (i in hashMap.values){
        println(i)

    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {

    val map = HashMap<Int, Int>()

    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    return intArrayOf()

}
