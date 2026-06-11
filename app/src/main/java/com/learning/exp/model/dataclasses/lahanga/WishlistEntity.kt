package com.learning.exp.model.dataclasses.lahanga

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wishlist_table")
data class WishlistEntity(

    @PrimaryKey
    val id:Int,

    val name:String,

    val imageUrl:String,

    val price:String
)