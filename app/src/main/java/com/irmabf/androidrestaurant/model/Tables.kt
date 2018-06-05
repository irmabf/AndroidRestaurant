package com.irmabf.androidrestaurant.model

import com.irmabf.androidrestaurant.R
import java.io.Serializable

class Tables{
    private val tables: List<Table> = listOf(
            Table("Mesa 1", Dish("Donut", R.drawable.donut, 3f, "Donut Relleno de Crema", listOf(
                    "1, 2, 3"
            ))),
            Table("Mesa 2", Dish("Pizza 4 Quesos", R.drawable.pizza_quesos_plato, 9f, "Pizza a los cuatro quesos hecha en horno de leña", listOf(
                    "2", "3", "4"))),
            Table("Mesa 3", Dish("Arroz 3 delicias", R.drawable.arroz_delicias, 9f, "Arroz 3 delicias con gambas, jamón y tortilla", listOf(
                    "32, 32"
            )))
    )
    val count
        get() = tables.size

    fun getTable(index: Int) = tables[index]
}