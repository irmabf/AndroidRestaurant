package com.irmabf.androidrestaurant.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentPagerAdapter
import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.model.Tables

class TablePagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_pager)

        //Paginaremos mesas, con lo que instanciamos el modelo de mesas
        val tables = Tables()

        val adapter = object: FragmentPagerAdapter(fragmentManager)


    }
}
