package com.irmabf.androidrestaurant.fragment
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.model.Dish

import kotlinx.android.synthetic.main.fragment_dish.view.*

class DishFragment: Fragment() {
    lateinit var root: View

    var dish: Dish? = null
        set(value) {
            field = value
            //Accedemos a las vistas
            val dishImage = root.dish_image

            val dishName = root.dish_name
            val dishDescription = root.dish_description
            val dishPrice = root.dish_price

            // Actualizo la vista con el modelo
            value?.let {
                dishImage.setImageResource(value.image)
                dishName.text = value.name
                dishDescription.text = value.description

                val priceString = getString(R.string.dish_price, value.price)
                dishPrice.text = priceString

            }
        }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        if (inflater != null){
            root = inflater.inflate(R.layout.fragment_dish, container, false)
            dish = Dish("Donut", R.drawable.donut, 3f, "Donuto con crema", "Ninguno")
        }
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
}