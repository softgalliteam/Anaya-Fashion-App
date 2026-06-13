package com.learning.exp.view.adapter

import android.annotation.SuppressLint
import android.util.Log
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

    private var list: ArrayList<LahangaResponseDataItem>,

    private val onClickListener: (Int) -> Unit


) : RecyclerView.Adapter<LahangaRecyclerViewAdapter.ViewHolder>() {



    // copy of complete data for search
    private var originalList =
        ArrayList<LahangaResponseDataItem>(list)




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {


        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.lahanga_list_item,
                parent,
                false
            )


        return ViewHolder(view)

    }




    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {


        val lahanga = list[position]


        Log.d(
            "IMG_CHECK",
            "Image URL = ${lahanga.imageUrl}"
        )



        holder.compNameTextView.text =
            lahanga.name



        holder.priceTv.text =
            "₹2500"




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





        holder.btnViewDetails.setOnClickListener {


            onClickListener(
                lahanga.id
            )

        }





        holder.favBtn.setOnClickListener {


            val isFav =
                holder.favBtn.tag as? Boolean ?: false



            if(isFav){


                holder.favBtn.setImageResource(
                    R.drawable.heart_icon
                )


                holder.favBtn.tag = false


            }else{


                holder.favBtn.setImageResource(
                    R.drawable.red_heart
                )
                holder.favBtn.tag = true
            }


        }



    }





    override fun getItemCount(): Int {

        return list.size

    }







    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view){



        val compIamge =
            itemView.findViewById<ImageView>(
                R.id.imageIv
            )



        val compNameTextView =
            itemView.findViewById<TextView>(
                R.id.titleTv
            )



        val priceTv =
            itemView.findViewById<TextView>(
                R.id.priceTv
            )



        val btnViewDetails =
            itemView.findViewById<com.google.android.material.button.MaterialButton>(
                R.id.btnViewDetails
            )



        val favBtn =
            itemView.findViewById<ImageView>(
                R.id.favBtn
            )



    }







    // API data update
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(
        newList: List<LahangaResponseDataItem>
    ){


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
        text:String
    ){



        if(text.isEmpty()){


            list.clear()


            list.addAll(originalList)



        }else{


            val filteredList =
                originalList.filter {


                    it.name.contains(
                        text,
                        ignoreCase = true
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