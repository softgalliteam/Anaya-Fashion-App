package com.anaya.fasion.model.lahanga

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lahanga_list")
data class LahangaResponseDataItem(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
    val price: Int,
//    val actualPrice:Int,
    val discount: String = "",
    val color: String = "",
    val colors: List<Int>
)
