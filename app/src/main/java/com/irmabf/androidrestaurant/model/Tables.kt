package com.irmabf.androidrestaurant.model

import com.irmabf.androidrestaurant.R

//Tables singleton
object Tables{
    private val tables: List<Table> = listOf(
            Table(
                    "Mesa 1", listOf(
                        Dish("Salmon a la parrilla", R.drawable.salmon_dish, 5f, "Salmon fresco a la parrilla", listOf("1")),
                        Dish("Hamburguesa con Patatas", R.drawable.burger_fries_dish, 3f, "Hamburguesa de pollo o vacuno con patatas fritas", listOf("1", "2")),
                        Dish("Pizza Queso", R.drawable.pizza_quesos_plato, 4f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                        Dish("Pasta", R.drawable.pasta_dish, 4f, "Spaguetti Carbonara", listOf("1, 2, 3") ),
                        Dish("Arroz", R.drawable.arroz_delicias, 3f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                        Dish("Donut", R.drawable.donut, 3f, "Donut Relleno de Crema", listOf("1", "2", "3") ),
                        Dish("Café", R.drawable.coffee, .75f, "Café con leche o café solo", listOf("1")),
                        Dish("Cerveza", R.drawable.cerveza_jarra, 1.5f, "Jarra de cerveza fresca", listOf("1") )
                    )),
            Table(
                    "Mesa 2", listOf(
                        Dish("Salmon a la parrilla", R.drawable.salmon_dish, 5f, "Salmon fresco a la parrilla", listOf("1")),
                        Dish("Hamburguesa con Patatas", R.drawable.burger_fries_dish, 3f, "Hamburguesa de pollo o vacuno con patatas fritas", listOf("1", "2")),
                        Dish("Pizza Queso", R.drawable.pizza_quesos_plato, 4f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                        Dish("Pasta", R.drawable.pasta_dish, 4f, "Spaguetti Carbonara", listOf("1, 2, 3") ),
                        Dish("Arroz", R.drawable.arroz_delicias, 3f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                        Dish("Donut", R.drawable.donut, 3f, "Donut Relleno de Crema", listOf("1", "2", "3") ),
                        Dish("Café", R.drawable.coffee, .75f, "Café con leche o café solo", listOf("1")),
                        Dish("Cerveza", R.drawable.cerveza_jarra, 1.5f, "Jarra de cerveza fresca", listOf("1") )
                    )),

            Table(
                    "Mesa 3", listOf(
                        Dish("Salmon a la parrilla", R.drawable.salmon_dish, 5f, "Salmon fresco a la parrilla", listOf("1")),
                        Dish("Hamburguesa con Patatas", R.drawable.burger_fries_dish, 3f, "Hamburguesa de pollo o vacuno con patatas fritas", listOf("1", "2")),
                        Dish("Pizza Queso", R.drawable.pizza_quesos_plato, 4f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                        Dish("Pasta", R.drawable.pasta_dish, 4f, "Spaguetti Carbonara", listOf("1, 2, 3") ),
                        Dish("Arroz", R.drawable.arroz_delicias, 3f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                        Dish("Donut", R.drawable.donut, 3f, "Donut Relleno de Crema", listOf("1", "2", "3") ),
                        Dish("Café", R.drawable.coffee, .75f, "Café con leche o café solo", listOf("1")),
                        Dish("Cerveza", R.drawable.cerveza_jarra, 1.5f, "Jarra de cerveza fresca", listOf("1") )
                )),
            Table(
                    "Mesa 4", listOf(
                        Dish("Salmon a la parrilla", R.drawable.salmon_dish, 5f, "Salmon fresco a la parrilla", listOf("1")),
                        Dish("Hamburguesa con Patatas", R.drawable.burger_fries_dish, 3f, "Hamburguesa de pollo o vacuno con patatas fritas", listOf("1", "2")),
                        Dish("Pizza Queso", R.drawable.pizza_quesos_plato, 4f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                        Dish("Pasta", R.drawable.pasta_dish, 4f, "Spaguetti Carbonara", listOf("1, 2, 3") ),
                        Dish("Arroz", R.drawable.arroz_delicias, 3f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                        Dish("Donut", R.drawable.donut, 3f, "Donut Relleno de Crema", listOf("1", "2", "3") ),
                        Dish("Café", R.drawable.coffee, .75f, "Café con leche o café solo", listOf("1")),
                        Dish("Cerveza", R.drawable.cerveza_jarra, 1.5f, "Jarra de cerveza fresca", listOf("1") )
            )),
            Table(
                    "Mesa 5", listOf(
                        Dish("Salmon a la parrilla", R.drawable.salmon_dish, 5f, "Salmon fresco a la parrilla", listOf("1")),
                        Dish("Hamburguesa con Patatas", R.drawable.burger_fries_dish, 3f, "Hamburguesa de pollo o vacuno con patatas fritas", listOf("1", "2")),
                        Dish("Pizza Queso", R.drawable.pizza_quesos_plato, 4f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                        Dish("Pasta", R.drawable.pasta_dish, 4f, "Spaguetti Carbonara", listOf("1, 2, 3") ),
                        Dish("Arroz", R.drawable.arroz_delicias, 3f, "Donut Relleno de Crema", listOf("1, 2, 3") ),
                        Dish("Donut", R.drawable.donut, 3f, "Donut Relleno de Crema", listOf("1", "2", "3") ),
                        Dish("Café", R.drawable.coffee, .75f, "Café con leche o café solo", listOf("1")),
                        Dish("Cerveza", R.drawable.cerveza_jarra, 1.5f, "Jarra de cerveza fresca", listOf("1") )
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