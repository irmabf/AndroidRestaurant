package com.irmabf.androidrestaurant.model

import java.io.Serializable

class Tables : Serializable {
    private var tables: List<Table> = listOf(
            Table("Mesa 1"),
            Table("Mesa 2"),
            Table("Mesa 3"),
            Table("Mesa 4"),
            Table("Mesa 5"),
            Table("Mesa 6"),
            Table("Mesa 7"),
            Table("Mesa 8"),
            Table("Mesa 9"),
            Table("Mesa 10")
    )

    val count
        get() = tables.size

    operator fun get(i: Int) = tables[i]

    fun toArray() = tables.toTypedArray()

}