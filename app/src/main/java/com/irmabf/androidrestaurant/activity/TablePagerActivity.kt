package com.irmabf.androidrestaurant.activity

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v13.app.FragmentPagerAdapter

import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.fragment.DishFragment
import com.irmabf.androidrestaurant.model.Tables
import kotlinx.android.synthetic.main.activity_table_pager.*

class TablePagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_pager)
        //Paginaremos mesas, con lo que instanciamos el modelo de mesas
        val tables = Tables()
        val adapter = object: FragmentPagerAdapter(fragmentManager){
            //Returns a fragment, a table fragment
            override fun getItem(position: Int): Fragment {
                return DishFragment.newInstance(tables.getTable(position))
            }
            override fun getCount() = tables.count

            override fun getPageTitle(position: Int): CharSequence? {
                return tables.getTable(position).name
            }
        }

        view_pager.adapter = adapter
    }
}
