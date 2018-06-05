package com.irmabf.androidrestaurant.model

import java.io.Serializable

data class Table(val name: String, val dish: List<Dish>) : Serializable {
    //constructor(name: String) : this(name, null)

    override fun toString(): String = name
}