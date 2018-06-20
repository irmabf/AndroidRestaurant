package com.irmabf.androidrestaurant.adapter

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.model.Dish


class DishRecyclerViewAdapter(private val dish: List<Dish>): RecyclerView.Adapter<DishRecyclerViewAdapter.DishViewHolder>() {

    /*OnClickListener

    *📌 1. El RecyclerViewAdapter va a guardar un clickListener, alguien que
    * se va a enterar de cuándo se pulsan alguno de los elementos de la lista
      */
    var onClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_dish, parent, false)
        view.setOnClickListener { onClickListener?.onClick(it) }
        /**
         * 📌 2. Decimos a este view que cuando lo pulsen avise a nuestro onClickListener
         * 3. Vamos al DishFragmente para suscribirnos
         * */

        return DishViewHolder(view)
    }

    override fun getItemCount() = dish.size

    /**
    *OnBindViewHolder es llamado cuando tenemos datos para mostrar la fila
     * y necesitamos saber como mostrar la fila con esos datos
     * equivale al CellForRowAtIndexPath de iOS
    * */
    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bindDish(dish[position])
    }

    inner class DishViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val dishName = itemView.findViewById<TextView?>(R.id.dish_name)
        val dishImage = itemView.findViewById<ImageView?>(R.id.dish_image)
        val dishPrice = itemView.findViewById<TextView?>(R.id.dish_price)
        val dishDescription = itemView.findViewById<TextView?>(R.id.dish_description)

        fun bindDish(dish: Dish){
            //Actualizamos la vista con el modelo, la vista es itemView y el modelo dish

            dishImage?.setImageResource(dish.image)
            dishName?.text = dish.name
            dishDescription?.text = dish.description
            dishPrice?.text = dish.price.toString()
        }
    }
}