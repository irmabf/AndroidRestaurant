package com.irmabf.androidrestaurant.adapter

import android.app.AlertDialog
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.irmabf.androidrestaurant.R
import com.irmabf.androidrestaurant.model.Dish


/*class DishRecyclerViewAdapter(private val dish: List<Dish>): RecyclerView.Adapter<DishRecyclerViewAdapter.DishViewHolder>() {

    /*OnClickListener

    *📌 1. El RecyclerViewAdapter va a guardar un clickListener, alguien que
    * se va a enterar de cuándo se pulsan alguno de los elementos de la lista
      */
    var onClickListener: View.OnClickListener? = null
    var buttonListener: ButtonListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_dish, parent, false)
        view.setOnClickListener { onClickListener?.onClick(it) }
        /**
         * 📌 2. Decimos a este view que cuando lo pulsen avise a nuestro onClickListener
         * 3. Vamos al DishFragmente para suscribirnos
         * */

        return DishViewHolder(view)
    }

    override fun getItemCount() = dish.size

    /**
    *OnBindViewHolder es llamado cuando tenemos datos para mostrar la fila
     * y necesitamos saber como mostrar la fila con esos datos
     * equivale al CellForRowAtIndexPath de iOS
    * */
    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bindDish(dish[position])
    }

    inner class DishViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val dishName = itemView.findViewById<TextView?>(R.id.dish_name)
        val dishImage = itemView.findViewById<ImageView?>(R.id.dish_image)
        val dishPrice = itemView.findViewById<TextView?>(R.id.dish_price)
        val dishDescription = itemView.findViewById<TextView?>(R.id.dish_description)

        fun bindDish(dish: Dish){
            //Actualizamos la vista con el modelo, la vista es itemView y el modelo dish

            dishImage?.setImageResource(dish.image)
            dishName?.text = dish.name
            dishDescription?.text = dish.description
            dishPrice?.text = dish.price.toString()
        }
    }
    interface ButtonListener {
        fun addDish(dish: Dish)
        fun removeDish(dish: Dish)
        fun addNotes(position: Int)
    }
}*/

class DishRecyclerViewAdapter(val dish: List<Dish>) : RecyclerView.Adapter<DishRecyclerViewAdapter.DishViewHolder>(){

    // Me creo un atributo onClickListener para ir a la actividad de Detalle
    var onClickListener: View.OnClickListener? = null
    var buttonListener: ButtonListener? = null


    //Se crea el viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        // Creo la vista y inflo el Layout Content_dish
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.content_dish, parent, false)
        // le decimos que nos informe cuando se pulse un ViewHolder
        view.setOnClickListener(onClickListener)

        val viewHolder = DishViewHolder(view)
        viewHolder.buttonListener = buttonListener

        return viewHolder
    }
    //Se le pasa el modelo al viewholder
    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        if (dish != null){
            holder?.bindDish(dish[position], position)
        }
    }
    override fun getItemCount(): Int {
        return dish.size
    }

    inner class DishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        // Accedemos a las vistas

        val dishImage = itemView.findViewById<ImageView>(R.id.dish_image)
        val dishName = itemView.findViewById<TextView>(R.id.dish_name)
        //val dishDescription = itemView.findViewById<TextView>(R.id.dish_description)
        val dishPrice = itemView.findViewById<TextView>(R.id.dish_price)
        val addDishButton = itemView.findViewById<Button>(R.id.add_dish_button)
        val removeDishButton = itemView.findViewById<Button>(R.id.remove_dish_button)
        val addNotesButton = itemView.findViewById<Button>(R.id.notes_button)
        var buttonListener: ButtonListener? = null
        val ordersNumber = itemView.findViewById<TextView>(R.id.orders_number)
        var orderList: MutableList<Dish> = mutableListOf()
        var dishNotes = itemView.findViewById<TextView>(R.id.dish_notes)


        fun reloadOrderNumber(number: Int){
            ordersNumber.setText(number.toString());
        }

        fun bindDish(dish: Dish, position: Int) {
            // Necesitamos el contexto de una vista para hacer getString
            val context = itemView.context

            // Actualizo la vista(itemView) con el modelo (Dish)
            dishImage.setImageResource(dish.image)
            dishName.text = dish.name
            //dishDescription.text = dish.description

            val priceString = context.getString(R.string.dish_price, dish.price)
            dishPrice.text = priceString

            reloadOrderNumber(orderList.count())


            addDishButton.setOnClickListener(){
                orderList.add(dish)
                reloadOrderNumber(orderList.count())
                if (orderList.count() >= 1){
                    removeDishButton.isEnabled = true
                    addNotesButton.isEnabled = true
                }
                buttonListener?.addDish(dish)
            }

            removeDishButton.setOnClickListener(){
                orderList.remove(dish)
                reloadOrderNumber(orderList.count())
                if (orderList.count() < 1){
                    removeDishButton.isEnabled = false
                    addNotesButton.isEnabled = false
                }
                buttonListener?.removeDish(dish)

            }

            addNotesButton.setOnClickListener(){
                val editText = EditText(context)
                AlertDialog.Builder(context)
                        .setTitle("NOTAS")
                        .setMessage("Cambios a tener en cuenta")
                        .setView(editText)
                        .setPositiveButton(android.R.string.ok, { _, _ ->
                            var notes = editText.getText().toString()
                            dishNotes.setText("Notas: ${notes}")
                        })
                        .setNegativeButton(android.R.string.cancel, null)
                        .show()
                buttonListener?.addNotes(position)
            }


        }
    }

    interface ButtonListener {
        fun addDish(dish: Dish)
        fun removeDish(dish: Dish)
        fun addNotes(position: Int)
    }

}