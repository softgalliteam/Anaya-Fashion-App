package com.learning.exp.model.dataclasses.lahanga

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lahanga_list")
data class LahangaResponseDataItem(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
    val price: Int
)
