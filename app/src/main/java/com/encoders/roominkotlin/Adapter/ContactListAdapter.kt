package com.encoders.roominkotlin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.encoders.roominkotlin.Contact
import com.encoders.roominkotlin.R

class ContactListAdapter(
    var items: List<Contact>,
    var clickListner: onContactClickListner
) :
    RecyclerView.Adapter<CartlistViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartlistViewHolder {
        return CartlistViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_contact_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CartlistViewHolder, position: Int) {
        holder.initialize(items[position], clickListner)

    }


}

class CartlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private var name: TextView? = itemView.findViewById(R.id.name)
    private var contact_id: TextView? = itemView.findViewById(R.id.contact_id)
    private var mobile_number: TextView? = itemView.findViewById(R.id.mobile_number)


    fun initialize(data: Contact, action: onContactClickListner) {

        name?.text = data.name
        contact_id?.text = data.id.toString()
        mobile_number?.text = data.phobe

        itemView?.setOnClickListener {
            action.onContactClickListner(data, adapterPosition)
        }


    }

}

interface onContactClickListner {
    fun onContactClickListner(data: Contact, position: Int)
}