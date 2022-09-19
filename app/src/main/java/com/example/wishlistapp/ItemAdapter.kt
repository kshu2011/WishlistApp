package com.example.wishlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNameTextView: TextView
        val itemPriceTextView: TextView
        val itemDescriptionTextView: TextView

        init {
            itemNameTextView = itemView.findViewById(R.id.itemNameDisplay)
            itemPriceTextView = itemView.findViewById(R.id.itemPriceDisplay)
            itemDescriptionTextView = itemView.findViewById(R.id.itemDescriptionDisplay)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_view, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val theItem = items.get(position)
        // Set item views based on views and data model
        holder.itemNameTextView.text = theItem.Name
        holder.itemPriceTextView.text = theItem.Price
        holder.itemDescriptionTextView.text = theItem.URL
    }

    override fun getItemCount(): Int {
        return items.size
    }
}