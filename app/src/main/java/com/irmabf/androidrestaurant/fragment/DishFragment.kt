package com.irmabf.androidrestaurant.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.content.Intent
import android.view.*

import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.model.Dish
import com.irmabf.androidrestaurant.model.Table
import kotlinx.android.synthetic.main.content_dish.*

import kotlinx.android.synthetic.main.fragment_dish.*

class DishFragment: Fragment() {

    companion object {

        val ARG_TABLE = "ARG_TABLE"

        //Nuevas instancias del TableFragment que devuelve un nuevo fragment
        fun newInstance(table: Table): Fragment {
            //Nos creamos el fragment, nueva instancia de DishFragment
            val fragment = DishFragment()
            //Nos creamos los argumentos del fragment
            //Para pasarle argumentos al fragment se usa el bundle metiendo valores como si fuera un diccionario
            val arguments = Bundle()
            arguments.putSerializable(ARG_TABLE, table)
            //Asignamos los argumentos al fragment
            fragment.arguments = arguments
            //Devolvemos el fragment
            return fragment
        }
    }

    private  enum class VIEW_INDEX(val index: Int){
        LOADING(0), DISH(1)
    }

    var dish: Dish? = null
        set(value) {
            field = value
            if (value != null) {
                dish_image.setImageResource(value.image)
                dish_name.text = value.name
                dish_description.text = value.description
                dish_price.text = value.price.toString()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_dish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Configuramos las animaciones para el viewswitcher
        view_switcher.setInAnimation(activity, android.R.anim.fade_in)
        view_switcher.setOutAnimation(activity, android.R.anim.fade_out)

        //Le decimos al viewswitcher que muestre la primera vista
        //Con esto sale primero el progress bar
        view_switcher.displayedChild = VIEW_INDEX.LOADING.index

        view.postDelayed({
            val table = arguments?.getSerializable(ARG_TABLE) as Table
            dish = table.dish
            //Con esto sale primero la card del dish
            view_switcher.displayedChild = VIEW_INDEX.DISH.index
        }, resources.getInteger(R.integer.default_fake_delay).toLong())
    }
}