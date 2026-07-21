package com.anaya.fashion.view.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anaya.fashion.R
import com.anaya.fashion.model.lahanga.LahangaDetails
import com.squareup.picasso.Picasso

class WishRecyclerViewAdapter(
    private val list: ArrayList<LahangaDetails>,
    private val onClickListener: (Int) -> Unit,
    private val onDeleteClick: (LahangaDetails) -> Unit
) : RecyclerView.Adapter<WishRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_list_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lahanga = list[position]

        val actualPrice = 10000
        val sellingPrice = lahanga.price
        val discount = actualPrice - sellingPrice
        val discountPercentage = (discount * 100) / actualPrice

        Log.d("IMG_CHECK", "Image URL = ${lahanga.imageUrl}")
        holder.compNameTextView.text = lahanga.name
        holder.priceTv.text = "₹ $sellingPrice"
        holder.actualPriceTv.text = "₹ $actualPrice"
        holder.discountTv.text = "$discountPercentage% off"

        Picasso.get()
            .load(lahanga.imageUrl)
            .placeholder(R.drawable.loading_spinner)
            .error(R.drawable.transparent_logo)
            .into(holder.compIamge)

        holder.compIamge.setOnClickListener {
            onClickListener(lahanga.id)
        }

        holder.itemView.setOnClickListener {
            onClickListener(lahanga.id)
        }

        holder.delete.setOnClickListener {
            val currentPosition = holder.adapterPosition
            if (currentPosition != RecyclerView.NO_POSITION) {
                val item = list[currentPosition]
                onDeleteClick(item)
                list.removeAt(currentPosition)
                notifyItemRemoved(currentPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val compIamge = itemView.findViewById<ImageView>(R.id.imageIv)
        val compNameTextView = itemView.findViewById<TextView>(R.id.titleTv)
        val priceTv = itemView.findViewById<TextView>(R.id.priceTv)
        val actualPriceTv = itemView.findViewById<TextView>(R.id.actualPriceTv)
        val discountTv = itemView.findViewById<TextView>(R.id.discountTv)
        val delete = itemView.findViewById<TextView>(R.id.deleteTv)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<LahangaDetails>) {
        list.clear()
        list.addAll(newList.reversed())
        notifyDataSetChanged()
    }
}
