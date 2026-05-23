package com.learning.exp.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learning.exp.R
import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem
import com.squareup.picasso.Picasso

class LahangaRecyclerViewAdapter(
    private val list: ArrayList<LahangaResponseDataItem>,
    private val onClickListener: (Int) -> Unit
) :
    RecyclerView.Adapter<LahangaRecyclerViewAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.computer_list_row_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val lahanga = list[position]

        holder.compNameTextView?.text = lahanga.name
        val imageView = holder.compIamge
        Picasso.get()
            .load(lahanga.imageUrl)
            .placeholder(R.drawable.loading_spinner)
            .error(R.drawable.transparent_logo)
            .into(imageView)

        holder.itemView.setOnClickListener {
            onClickListener(lahanga.id)
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
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<LahangaResponseDataItem>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}