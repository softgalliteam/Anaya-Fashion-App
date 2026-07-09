package com.anaya.fashion.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.anaya.fashion.R

import com.anaya.fashion.model.lahanga.WishlistEntity
import com.squareup.picasso.Picasso


class WishlistAdapter(
    private val list: List<WishlistEntity>
) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val image: ImageView =
            view.findViewById(R.id.wishImage)
        val name: TextView =
            view.findViewById(R.id.wishName)


        val price: TextView =
            view.findViewById(R.id.wishPrice)

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {


        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.wishlist_item,
                parent,
                false
            )


        return ViewHolder(view)

    }


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {


        val item = list[position]


        holder.name.text = item.name

        holder.price.text = item.price


        Picasso.get()
            .load(item.imageUrl)
            .into(holder.image)


    }


    override fun getItemCount(): Int {

        return list.size

    }

}