package com.irmabf.androidrestaurant.activity

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v13.app.FragmentPagerAdapter

import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.model.Tables

class TablePagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_pager)

        //Paginaremos mesas, con lo que instanciamos el modelo de mesas
        val tables = Tables()

        val adapter = object: FragmentPagerAdapter(fragmentManager){
            override fun getItem(position: Int): Fragment {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getCount(): Int {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }


    }

}
