package com.irmabf.androidrestaurant.activity


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_pager)
        //Paginaremos mesas, con lo que instanciamos el modelo de mesas
        val tables = Tables()
        val adapter = object: FragmentPagerAdapter(supportFragmentManager){
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
    }
}
