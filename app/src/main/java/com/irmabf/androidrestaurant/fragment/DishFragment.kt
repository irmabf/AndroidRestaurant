package com.irmabf.androidrestaurant.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Toast
import android.widget.ViewSwitcher


import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.activity.DetailActivity
import com.irmabf.androidrestaurant.adapter.DishRecyclerViewAdapter
import com.irmabf.androidrestaurant.model.Dish
import com.irmabf.androidrestaurant.model.Table
import kotlinx.android.synthetic.main.dish_list.*

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.json.JSONObject
import java.net.URL
import java.util.*


class DishFragment : Fragment() {

    enum class VIEW_INDEX(val index: Int) {
        LOADING(0),
        DISH(1)
    }

    companion object {

        val ARG_TABLE = "ARG_TABLE"

        // Creo esta funcion para recibir la instancia de este Fragment, con la mesa como argumento
        fun newInstance(table: Table): Fragment {
            val fragment = DishFragment()
            val arguments = Bundle()
            arguments.putSerializable(ARG_TABLE, table)
            fragment.arguments = arguments

            return fragment
        }
    }

    lateinit var root: View
    lateinit var viewSwitcher: ViewSwitcher
    lateinit var dishList: RecyclerView

    var totalPrice = mutableListOf<Float>()


    var table: Table? = null
        set(value) {
            field = value
            if (value != null) {
                dish = value.dish
            }
        }

    var dish: List<Dish>? = null
        set(value) {
            field = value

            // Actualizo la vista con el modelo
            if (value != null) {

                // Asignamos el adapter al RecyclerView ahora que tenemos datos
                val adapter = DishRecyclerViewAdapter(value)
                dishList.adapter = adapter

                // Le digo al RecyclerViewAdapter que me informe cuando pulsen sus vistas
                adapter.onClickListener = View.OnClickListener { v: View? ->
                    // Aqui me entero de que se ha pulsado y la posicion
                    val position = dishList.getChildAdapterPosition(v)
                    val dishToShow = value[position]
                    // Lanzamos la actividad
                    startActivity(DetailActivity.intent(activity, dishToShow))

                }

                adapter.buttonListener = object : DishRecyclerViewAdapter.ButtonListener {
                    override fun addDish(dish: Dish) {

                        totalPrice.add(dish.price)
                        var totalBill = totalPrice.sum()
                        var totalBillString = String.format("Total: %.2f", totalBill).toString() + " €"
                        price_text.setText(totalBillString)

                        Toast.makeText(activity, "Plato añadido: ${dish.name}", Toast.LENGTH_SHORT)
                                .show()
                    }

                    override fun removeDish(dish: Dish) {
                        totalPrice.remove(dish.price)
                        var totalBill = totalPrice.sum()
                        var totalBillString = String.format("Total: %.2f", totalBill).toString() + " €"
                        price_text.setText(totalBillString)
                        Toast.makeText(activity, "Plato eliminado: ${dish.name}", Toast.LENGTH_SHORT)
                                .show()
                    }

                    override fun addNotes(position: Int) {
                        Toast.makeText(activity, "Notas añadidas al plato: ${position}", Toast.LENGTH_SHORT)
                                .show()
                    }

                }


                viewSwitcher.displayedChild = VIEW_INDEX.DISH.index
                // SuperCache
                table?.dish = value

                adapter.notifyDataSetChanged()

            }


        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        super.onCreateView(inflater, container, savedInstanceState)
        // Si inflater es distinto de null
        if (inflater != null) {

            root = inflater.inflate(R.layout.fragment_dish, container, false)
            viewSwitcher = root.findViewById(R.id.view_switcher)
            viewSwitcher.setInAnimation(activity, android.R.anim.fade_in)
            viewSwitcher.setOutAnimation(activity, android.R.anim.fade_out)

            // Accedemos al RecyclerView
            dishList = root.findViewById(R.id.dish_list)

            // Le decimos como debe visualizarse (LayoutManager)
            dishList.layoutManager = GridLayoutManager(activity, resources.getInteger(R.integer.recycler_view_columns))

            // Le decimos como animarse
            dishList.itemAnimator = DefaultItemAnimator()

            // El RecyclerView necesita un adapter,
            // aunque aquí aún no podemos ponerlo, ya que no tenemos los datos


            if (arguments != null) {
                table = arguments!!.getSerializable(ARG_TABLE) as? Table
            }

        }

        return root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && dish != null) {
            dishList.adapter.notifyDataSetChanged()
        }


    }
}