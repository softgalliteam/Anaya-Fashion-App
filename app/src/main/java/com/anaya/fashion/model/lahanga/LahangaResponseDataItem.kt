package com.anaya.fashion.model.lahanga

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lahanga_list")
data class LahangaResponseDataItem(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
    val sellingPrice: Int,
    val actualPrice:Int,
    val isBestSeller: Boolean,
    val isLehanga: Boolean = true,
    val color: String = "",
    val colors: List<Int>
)
