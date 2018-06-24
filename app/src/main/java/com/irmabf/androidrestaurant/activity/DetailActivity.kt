package com.irmabf.androidrestaurant.activity

import android.content.Context
import android.content.Intent
import android.icu.text.AlphabeticIndex
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.model.Tables
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_TABLE_INDEX = "EXTRA_TABLE_INDEX"
        val EXTRA_DISH_INDEX = "EXTRA_DISH_INDEX"

        fun intent(context: Context, tableIndex: Int, dishIndex: Int): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_DISH_INDEX, dishIndex)
            intent.putExtra(EXTRA_TABLE_INDEX, tableIndex)
            return intent

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //Sacamos los datos con los que configurar la interfaza
        val table = Tables[intent.getIntExtra(EXTRA_TABLE_INDEX, 0)]
        val dish = table.dish[intent.getIntExtra(EXTRA_DISH_INDEX, 0)]
        //Actualizamos la interfaz
        dish_image?.setImageResource(dish.image)
        dish_name?.text = dish.name

        dish_description?.text = dish.description
        dish_price?.text = dish.price.toString()

    }

}
