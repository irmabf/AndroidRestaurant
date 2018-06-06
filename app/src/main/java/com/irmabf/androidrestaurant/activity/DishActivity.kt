package com.irmabf.androidrestaurant.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.fragment.TableListFragment
import com.irmabf.androidrestaurant.model.Table
import kotlinx.android.synthetic.main.activity_dish.*


class DishActivity : AppCompatActivity(), TableListFragment.OnTableSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish)
        //Check that the fragment is not already loaded in our view hierarchy
        if(supportFragmentManager.findFragmentById(R.id.table_list) == null){
            //Add a fragment dynamically
            val fragment = TableListFragment.newInstance()
            supportFragmentManager
                    .beginTransaction()
                    //add(dummy gap where the fragment will go, fragment)
                    .add(R.id.table_list_fragment, fragment)
                    .commit()
        }
    }

    override fun onTableSelected(table: Table, position: Int) {
      //Cuando se seleccione una de las filas debemos lanzar la pantalla del view pager
        //con la lista mesas
        val intent = TablePagerActivity.intent(this, position)
        startActivity(intent)
    }
}
