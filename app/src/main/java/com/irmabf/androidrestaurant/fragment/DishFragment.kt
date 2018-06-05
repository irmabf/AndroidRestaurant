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

import kotlinx.android.synthetic.main.fragment_dish.*

class DishFragment: Fragment() {


    var dish: Dish? = null
        set(value) {
            field = value
            if (value != null){
                dish_image.setImageResource(value.image)
                dish_name.text = value.description
                dish_description.text = value.description
                dish_price.text = value.price.toString()
            }

         }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
     savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_dish, container, false)!!


    }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dish = Dish(
            "Donut",
            R.drawable.donut,
            3f,
            "Donut con crema",
            "Ningun alergeno"
        )

    }


}