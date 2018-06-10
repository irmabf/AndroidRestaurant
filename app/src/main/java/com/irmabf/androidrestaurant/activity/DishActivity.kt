package com.irmabf.androidrestaurant.activity

import android.os.Build
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

        // Chuleta para saber detalles del dispositivo real (o emulador) que está ejecutando
        val metrics = resources.displayMetrics
        val width = metrics.widthPixels
        val height = metrics.heightPixels
        val dpWidth = (width / metrics.density).toInt()
        val dpHeight = (height / metrics.density).toInt()
        val model = Build.MODEL
        val androidVersion = Build.VERSION.SDK_INT

        // Averiguamos qué interfaz hemos cargado
        // Eso lo averiguamos preguntando si en la interfaz tnemos un FrameLayout concreto
        if (findViewById<ViewGroup>(R.id.table_list_fragment) != null) {
            // Hemos cargado una interfaz que tiene el hueco para el fragment TableListFragment
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
            // Hemos cargado una interfaz que tiene el hueco para el fragment TablePagerFragment
            if (supportFragmentManager.findFragmentById(R.id.view_pager_fragment) == null) {
                supportFragmentManager.beginTransaction()
                        .add(R.id.view_pager_fragment, TablePagerFragment.newInstance(0))
                        .commit()
            }
        }
    }

    override fun onTableSelected(table: Table, position: Int) {
        /*
        * Intento buscar el fragment de la derecha en las vistas landscape o tablet o movil grande el view_pager_fragment
        * Si no dicho fragment no existe, doy por hecho que estoy en una interfaz donde no hay un table pager,
        * con lo que lanzo la actividad en lugar de decirle algo a ese fragment
        */
        val tablePagerFragment = supportFragmentManager.findFragmentById(R.id.view_pager_fragment) as? TablePagerFragment
        /* Si se dan estas condiciones , quiere decir que estamos en una interfaz en la que existe
        * el fragment view_pager_fragment, y guardamos una referencia a este view_pager_fragment
         * en la variable tablePagerFragment para poder trabajar con el.
         * Si existe le decimos que nos queremos mover a la posicion de la mesa que nos pasan como argumento en onTableSelected**/

        if (tablePagerFragment != null){
            //Estamos en una interfaz dond existe el TablePagerFragment y le decimos que nos mueva a una mesa,
            //a la mesa que nos pasan como argumento en el metodo onTableSelected(table: Table, position)
            tablePagerFragment.moveToTable(position)
        }else{
            /*
            *Si tablePagerFragment es igual a null, estamos en una interfaz donde solo hay una lista de mesas, es decir,
            * la interfaz para móviles pequeños y lanzamos la actividad del TablePagerActivity, ya que cuando NO tengo que combinar varias
            * pantallas uso actividades y no fragments. Al tratarse de una actividad usO un intent. Iremos a parar a la mesa que pulsemos
            * */
            val intent = TablePagerActivity.intent(this, position)
            startActivity(intent)
        }

        /*val intent = TablePagerActivity.intent(this, position)
        startActivity(intent)*/
    }
}
