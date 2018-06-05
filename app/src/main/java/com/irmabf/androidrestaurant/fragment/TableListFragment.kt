package com.irmabf.androidrestaurant.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.model.Table
import com.irmabf.androidrestaurant.model.Tables
import kotlinx.android.synthetic.main.fragment_table_list.*

class TableListFragment : Fragment() {
    companion object {
        fun newInstance() = TableListFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Instance of tables
        val tables = Tables()

        val adapter = ArrayAdapter<Table>(
                activity,
                android.R.layout.simple_list_item_1,
                tables.toArray()
        )
        table_list.adapter = adapter
    }
}
