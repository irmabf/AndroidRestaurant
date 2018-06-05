package com.irmabf.androidrestaurant.activity


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.fragment.DishFragment
import com.irmabf.androidrestaurant.model.Tables
import kotlinx.android.synthetic.main.activity_table_pager.*

/**Implementamos un view pager para poder deslizar entre pantallas,
 * El view pager entre fragments, porque en android
 * no puedo tener más de una actividad en la pantalla
 * Para implementar eso, el ViewPager se sirve del fragmentPagerAdapter
 * Un adaptador sirve para a una vista darle su modelo y con el modelo
 * darle los datos que necesita*/
class TablePagerActivity : AppCompatActivity() {

    //Paginaremos mesas, con lo que instanciamos el modelo de mesas
    private val tables = Tables()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_pager)
        //Set up my custom  toolbar as action bar
        setSupportActionBar(toolbar)
        //Set toolbar logo
        toolbar.setLogo(R.mipmap.ic_launcher_round)
        //TODO Add custom logo

        val adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            //Returns a fragment, a table fragment
            override fun getItem(position: Int): Fragment {
                return DishFragment.newInstance(tables.getTable(position))
            }

            override fun getCount() = tables.count

            override fun getPageTitle(position: Int): CharSequence? {
                return tables.getTable(position).name
            }
        }
        //Important!! Don´t forget this line or it wont work
        view_pager.adapter = adapter

        view_pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                updateTableInfo(position)
            }
        })
        updateTableInfo(0)
    }
    private fun updateTableInfo(position: Int){
        supportActionBar?.title = tables.getTable(position).name
    }

    //Pager Navigation menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.pager_navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.previous -> {
            view_pager.currentItem--
            true
        }
        R.id.next -> {
            view_pager.currentItem++
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        super.onPrepareOptionsMenu(menu)
        //1. Save menu item to a variable
        //We cant´t use kotlin extensions here
        val previousMenu = menu?.findItem(R.id.previous)
        val nextMenu = menu?.findItem(R.id.next)

        //To know total number of tables in the app I need the adapter
        val adapter = view_pager.adapter!!
        previousMenu?.isEnabled = view_pager.currentItem > 0

        nextMenu?.isEnabled = view_pager.currentItem < adapter.count - 1
        return true
    }

}