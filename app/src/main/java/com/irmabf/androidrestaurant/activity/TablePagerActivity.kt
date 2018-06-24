package com.irmabf.androidrestaurant.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.fragment.TablePagerFragment
import kotlinx.android.synthetic.main.activity_table_pager.*

/**Implementamos un view pager para poder deslizar entre pantallas,
 * El view pager entre fragments, porque en android
 * no puedo tener más de una actividad en la pantalla
 * Para implementar eso, el ViewPager se sirve del fragmentPagerAdapter
 * Un adaptador sirve para a una vista darle su modelo y con el modelo
 * darle los datos que necesita*/
class TablePagerActivity : AppCompatActivity() {

    companion object {

        val EXTRA_TABLE = "EXTRA_TABLE"

        fun intent(context: Context,  tableIndex: Int): Intent {
            val intent = Intent(context, TablePagerActivity::class.java)
            intent.putExtra(EXTRA_TABLE, tableIndex)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_pager)

        //toolbar.setLogo(R.mipmap.ic_launcher)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val initialTableIndex = intent.getIntExtra(EXTRA_TABLE, 0)

        // Creo, si hace falta, el CityPagerFragment pasándole la ciudad inicial
        if (supportFragmentManager.findFragmentById(R.id.fragment_table_pager) == null) {
            // Hay hueco, y habiendo hueco metemos el fragment
            val fragment = TablePagerFragment.newInstance(initialTableIndex)
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_table_pager, fragment)
                    .commit()
        }
    }

    /*override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        android.R.id.home -> { // Nos han llamado a la flecha de back
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }*/

}















