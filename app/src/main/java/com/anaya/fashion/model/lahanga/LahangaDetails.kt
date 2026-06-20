package com.anaya.fashion.model.lahanga

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "lahanga_cart")
data class LahangaDetails(
    @PrimaryKey var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var imageUrl: String = "",
    var imageList: List<String> = emptyList(),
    var price: Int = 0,
    var actualPrice: Int = 0,
    var discount: Int = 0,

    @Ignore
    var sizes: List<Int> = emptyList(),

    @Ignore
    var colors: List<Int> = emptyList()

)