package com.learning.exp.model.dataclasses.lahanga

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lahanga_cart")
data class LahangaDetails(
    @PrimaryKey var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var imageUrl: String = "",
    var imageList: List<String> = emptyList(),
    var price: Int = 0
)

