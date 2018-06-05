package com.irmabf.androidrestaurant.model

import com.irmabf.androidrestaurant.R
import java.io.Serializable

object Tables {
    private val tables: List<Table> = listOf(
            Table("Mesa 1", listOf(
                    Dish("Donut", R.drawable.donut, 3f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 6f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 9f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 10f, "Donut relleno de crema","Ninguno"),
                    Dish("Donut", R.drawable.donut, 7f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 15f, "Donut relleno de crema", "Ninguno")
            )),
            Table("Mesa 1", listOf(
                    Dish("Donut", R.drawable.donut, 17f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 30f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 31f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 32f, "Donut relleno de crema","Ninguno"),
                    Dish("Donut", R.drawable.donut, 33f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 34f, "Donut relleno de crema", "Ninguno")
            )),
            Table("Mesa 1", listOf(
                    Dish("Donut", R.drawable.donut, 35f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 36f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 37f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 389f, "Donut relleno de crema","Ninguno"),
                    Dish("Donut", R.drawable.donut, 39f, "Donut relleno de crema", "Ninguno"),
                    Dish("Donut", R.drawable.donut, 388f, "Donut relleno de crema", "Ninguno")
            ))
    )

    val count
            get() = tables.size

    fun getTable(index: Int) = tables[index]
    fun getIndex(table: Table) = tables.indexOf(table)
    operator fun get(index: Int) = tables[index]

    fun toArray() = tables.toTypedArray()
}