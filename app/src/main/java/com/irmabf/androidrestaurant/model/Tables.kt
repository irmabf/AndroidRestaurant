package com.irmabf.androidrestaurant.model

import com.irmabf.androidrestaurant.R

//Tables singleton
object Tables{
    private val tables: List<Table> = listOf(
            Table(
                    "Mesa 1", listOf(
                            Dish("Donut", R.drawable.donut, 3f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                            Dish("Donut", R.drawable.donut, 4f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                            Dish("Donut", R.drawable.donut, 5f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                            Dish("Donut", R.drawable.donut, 6f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                            Dish("Donut", R.drawable.donut, 7f, "Donut Relleno de Crema", listOf("1, 2, 3") )
                    )),
            Table(
                    "Mesa 2", listOf(
                    Dish("Pizza Queso", R.drawable.pizza_quesos_plato, 3f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                    Dish("Pizza Queso", R.drawable.pizza_quesos_plato, 4f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                    Dish("Pizza Queso", R.drawable.pizza_quesos_plato, 5f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                    Dish("Pizza Queso", R.drawable.pizza_quesos_plato, 6f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                    Dish("Pizza Queso", R.drawable.pizza_quesos_plato, 7f, "Donut Relleno de Crema", listOf("1, 2, 3") )
                )),

            Table(
                    "Mesa 1", listOf(
                    Dish("Arroz", R.drawable.arroz_delicias, 3f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                    Dish("Arroz", R.drawable.arroz_delicias, 4f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                    Dish("Arroz", R.drawable.arroz_delicias, 5f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                    Dish("Arroz", R.drawable.arroz_delicias, 6f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                    Dish("Arroz", R.drawable.arroz_delicias, 7f, "Donut Relleno de Crema", listOf("1, 2, 3") )
                ))

    )
    val count
        get() = tables.size

    //fun getTable(index: Int) = tables[index]
    //Use operator overloading kotlin feature  to override [] array operator with a new functionality
    operator fun get(index: Int) = tables[index]

    //Transforms  tables List to Array
   fun toArray() = tables.toTypedArray()
}