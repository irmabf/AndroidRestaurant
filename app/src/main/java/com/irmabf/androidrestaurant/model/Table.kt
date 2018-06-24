package com.irmabf.androidrestaurant.model

import java.io.Serializable

data class Table(val name: String, var dish: List<Dish>) : Serializable {
    //constructor(name: String) : this(name, null)
    //Handles issues with data class in listView
    override fun toString(): String = name
}
