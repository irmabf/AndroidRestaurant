package com.irmabf.androidrestaurant.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.fragment.TableListFragment
import com.irmabf.androidrestaurant.fragment.TablePagerFragment
import com.irmabf.androidrestaurant.model.Table


class DishActivity : AppCompatActivity(), TableListFragment.OnTableSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish)
        // Averiguamos qué interfaz hemos cargado
        // Eso lo averiguamos preguntando si en la interfaz tnemos un FrameLayout concreto
        if (findViewById<ViewGroup>(R.id.table_list_fragment) != null) {
            // Hemos cargado una interfaz que tiene el hueco para el fragment CityListFragment
            // Comprobamos primero que no tenemos ya añadido el fragment a nuestra jerarquía
            if (supportFragmentManager.findFragmentById(R.id.table_list_fragment) == null) {
                // Añadiremos el fragment de forma dinámica
                val fragment = TableListFragment.newInstance()

                supportFragmentManager.beginTransaction()
                        .add(R.id.table_list_fragment, fragment)
                        .commit()
            }
        }

        if (findViewById<ViewGroup>(R.id.view_pager_fragment) != null) {
            // Hemos cargado una interfaz que tiene el hueco para el fragment CityPagerFragment
            if (supportFragmentManager.findFragmentById(R.id.view_pager_fragment) == null) {
                supportFragmentManager.beginTransaction()
                        .add(R.id.view_pager_fragment, TablePagerFragment.newInstance(0))
                        .commit()
            }
        }
    }

    override fun onTableSelected(city: Table, position: Int) {
        val intent = TablePagerActivity.intent(this, position)
        startActivity(intent)
    }
}
