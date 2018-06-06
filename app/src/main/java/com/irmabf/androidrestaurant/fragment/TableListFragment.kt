package com.irmabf.androidrestaurant.fragment


import android.app.Activity
import android.content.Context
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
import java.text.FieldPosition

class TableListFragment : Fragment() {
    companion object {
        fun newInstance() = TableListFragment()
    }
    //Atributo listener del fragment, a quien vamos a informar de lo que haya
    //pasado en las actividades que se relacionen con el
    private  var onTableSelectedListener: OnTableSelectedListener? = null
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
                tables.toArray())
        table_list.adapter = adapter
        /*
        ¿Como nos enteramos en el fragment de que el usuario
        ha seleccionado una de las filas de esa lista?
        * */
        table_list.setOnItemClickListener{_ ,_ , index, _ ->
            //Avisamos al listener que una mesa ha sido seleccionada
            onTableSelectedListener?.onTableSelected(tables[index], index)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAtach(context as Activity?)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAtach(activity)
    }

    private fun commonAtach(activity: Activity?){
        //Solo en el caso de que la actividad que me pasen implemente
        //la interfaz OnTableSelectedListener
        if (activity is OnTableSelectedListener){
            //al listener onTableSelectedListener le asigno la actividad
            onTableSelectedListener = activity
        }else{
            onTableSelectedListener = null
        }
    }

    override fun onDetach() {
        super.onDetach()
        onTableSelectedListener = null
    }
    //Interfaz que va a tener este fragment con las actividades que se enganchen a él
    interface OnTableSelectedListener {
        fun onTableSelected(table: Table, position: Int)
    }
}
