package com.learning.exp.view.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.learning.exp.R
import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem
import com.squareup.picasso.Picasso

class LahangaRecyclerViewAdapter(
    private val list: ArrayList<LahangaResponseDataItem>,
    private val onClickListener: (Int) -> Unit

) : RecyclerView.Adapter<LahangaRecyclerViewAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lahanga_list_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val lahanga = list[position]

        Log.d("IMG_CHECK", "Image URL = ${lahanga.imageUrl}")
        holder.compNameTextView?.text = lahanga.name
        holder.priceTv.text = "₹2500"


        Picasso.get()
            .load(lahanga.imageUrl)
            .placeholder(R.drawable.loading_spinner)
            .error(R.drawable.transparent_logo)
            .into(holder.compIamge)


        holder.itemView.setOnClickListener {
            onClickListener(lahanga.id)
        }

//        for add to cat button

        holder.cartBtn.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "${lahanga.name}Added To Cart",
                Toast.LENGTH_SHORT
            ).show()
        }

//        for favbtn
        holder.favBtn.setOnClickListener {
            val isFav = holder.favBtn.tag as? Boolean ?: false
            if (isFav) {
                holder.favBtn.setImageResource(R.drawable.logo)
                holder.favBtn.tag = false
            } else {
                holder.favBtn.setImageResource(R.drawable.logo) // change if you have filled heart icon
                holder.favBtn.tag = true
            }

        }
    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return list.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val compIamge = itemView.findViewById<ImageView>(R.id.imageIv)
        val compNameTextView = itemView.findViewById<TextView>(R.id.titleTv)

        val priceTv =itemView.findViewById<TextView>(R.id.priceTv)

        val cartBtn =  itemView.findViewById<com.google.android.material.button.MaterialButton>(R.id.cartBtn)

        val favBtn =  itemView.findViewById<ImageView>(R.id.favBtn)



    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<LahangaResponseDataItem>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }


}