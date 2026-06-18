package com.learning.exp.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learning.exp.R
import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.squareup.picasso.Picasso

class CartRecyclerViewAdapter(
    private var list: ArrayList<LahangaDetails>,
    private val onItemClick: (Int) -> Unit,
    private val onDeleteClickListener: (LahangaDetails) -> Unit
) : RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_list_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        val actualPrice = 10000
        val sellingPrice = item.price
        val discount = actualPrice - sellingPrice
        val discountPercentage = (discount * 100) / actualPrice

        holder.compNameTextView.text = item.name
        holder.priceTv.text = "₹ $sellingPrice"
        holder.actualPriceTv.text = "₹ $actualPrice"
        holder.discountTv.text = "$discountPercentage% off"

        Picasso.get()
            .load(item.imageUrl)
            .placeholder(R.drawable.loading_spinner)
            .error(R.drawable.transparent_logo)
            .into(holder.compImage)

        holder.compImage.setOnClickListener {
            onItemClick(item.id)
        }

        holder.deleteTv.setOnClickListener {

            val adapterPosition = holder.bindingAdapterPosition

            if (adapterPosition != RecyclerView.NO_POSITION) {

                val deletedItem = list[adapterPosition]

                // API callback
                onDeleteClickListener(deletedItem)

                // RecyclerView se turant remove
                list.removeAt(adapterPosition)

                notifyItemRemoved(adapterPosition)
                notifyItemRangeChanged(
                    adapterPosition,
                    list.size
                )
            }
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val compImage: ImageView = view.findViewById(R.id.imageIv)
        val compNameTextView: TextView = view.findViewById(R.id.titleTv)
        val priceTv: TextView = view.findViewById(R.id.priceTv)
        val actualPriceTv: TextView = view.findViewById(R.id.actualPriceTv)
        val discountTv: TextView = view.findViewById(R.id.discountTv)
        val deleteTv: TextView = view.findViewById(R.id.deleteTv)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<LahangaDetails>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}