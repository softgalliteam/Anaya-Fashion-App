package com.anaya.fasion.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anaya.fashion.R
import com.anaya.fasion.model.lahanga.LahangaDetails
import com.squareup.picasso.Picasso

class BuyRecyclerViewAdapter(
    private val list: ArrayList<LahangaDetails>,
    private val onClickListener: (Int) -> Unit

) : RecyclerView.Adapter<BuyRecyclerViewAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.buy_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val cartItem = list[position]

        holder.titleTv?.text = cartItem.name
        holder.descTv?.text = cartItem.description
        holder.priceTv.text = "₹ ${cartItem.price}"


        Picasso.get()
            .load(cartItem.imageUrl)
            .placeholder(R.drawable.loading_spinner)
            .error(R.drawable.transparent_logo)
            .into(holder.productIv)


        holder.itemView.setOnClickListener {
            onClickListener(cartItem.id)
        }
    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return list.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productIv = itemView.findViewById<ImageView>(R.id.imageIv)
        val titleTv = itemView.findViewById<TextView>(R.id.titleTv)
        val descTv = itemView.findViewById<TextView>(R.id.descTv)

        val priceTv = itemView.findViewById<TextView>(R.id.priceTv)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<LahangaDetails>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}