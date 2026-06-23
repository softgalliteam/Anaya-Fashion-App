package com.anaya.fashion.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anaya.fashion.R
import com.anaya.fashion.model.lahanga.LahangaResponseDataItem
import com.squareup.picasso.Picasso


class LahangaRecyclerViewAdapter(
    private var list: ArrayList<LahangaResponseDataItem>, private val onClickListener: (Int) -> Unit
) : RecyclerView.Adapter<LahangaRecyclerViewAdapter.ViewHolder>() {
    // copy of complete data for search
    private var originalList = ArrayList<LahangaResponseDataItem>(list)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.lahanga_list_item, parent, false
        )
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: ViewHolder, position: Int
    ) {


        val lahanga = list[position]

        val actualPrice = lahanga.actualPrice
        val sellingPrice = lahanga.sellingPrice
        val discountPercentage =
            calculateDiscountPercentage(actualPrice.toDouble(), sellingPrice.toDouble())

        holder.compNameTextView.text = lahanga.name
        holder.actualPriceTv.text = "₹${lahanga.actualPrice}"
        holder.priceTv.text = " ₹${lahanga.sellingPrice}"
        holder.discountTv.text = "$discountPercentage% off"
        holder.badgeTv.text =
            if (lahanga.isBestSeller) "BEST SELLER" else "$discountPercentage% off"

        Picasso.get()
            .load(lahanga.imageUrl)
            .placeholder(
                R.drawable.loading_spinner
            )
            .error(
                R.drawable.transparent_logo
            )
            .into(holder.compIamge)

        holder.compIamge.setOnClickListener {
            onClickListener(
                lahanga.id
            )
        }

        holder.favBtn.setOnClickListener {
            val isFav = holder.favBtn.tag as? Boolean ?: false
            if (isFav) {
                holder.favBtn.setImageResource(
                    R.drawable.heart_icon
                )
                holder.favBtn.tag = false
            } else {
                holder.favBtn.setImageResource(
                    R.drawable.red_heart
                )
                holder.favBtn.tag = true
            }
        }
    }

    fun calculateDiscountPercentage(actualPrice: Double, sellingPrice: Double): Int {
        if (actualPrice <= 0 || sellingPrice >= actualPrice) {
            return 0
        }
        val discount = ((actualPrice - sellingPrice) / actualPrice) * 100

        return discount.toInt()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val compIamge = itemView.findViewById<ImageView>(
            R.id.imageIv
        )

        val compNameTextView = itemView.findViewById<TextView>(
            R.id.titleTv
        )

        val priceTv = itemView.findViewById<TextView>(R.id.priceTv)
        val actualPriceTv = itemView.findViewById<TextView>(R.id.actualPriceTv)

        val badgeTv = itemView.findViewById<TextView>(R.id.badgeTv)
        val discountTv = itemView.findViewById<TextView>(R.id.discountTv)

        val favBtn = itemView.findViewById<ImageView>(
            R.id.favBtn
        )
    }

    // API data update
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(
        newList: List<LahangaResponseDataItem>
    ) {
        list.clear()
        list.addAll(newList)
        // save complete data for searching
        originalList.clear()
        originalList.addAll(newList)
        notifyDataSetChanged()
    }

    // SEARCH FUNCTION
    @SuppressLint("NotifyDataSetChanged")
    fun filterList(
        text: String
    ) {
        if (text.isEmpty()) {
            list.clear()
            list.addAll(originalList)
        } else {
            val filteredList = originalList.filter {
                it.name.contains(
                    text, ignoreCase = true
                )
            }
            list.clear()
            list.addAll(
                filteredList
            )
        }
        notifyDataSetChanged()
    }
}
