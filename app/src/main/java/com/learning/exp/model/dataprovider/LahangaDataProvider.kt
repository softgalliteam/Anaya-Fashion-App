package com.learning.exp.model.dataprovider

import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem

object LahangaDataProvider {

    fun getLahangaList() = arrayListOf(
        LahangaResponseDataItem(
            id = 1,
            name = "Description for Computer 1",
            imageUrl = "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823"
        ),
        LahangaResponseDataItem(
            id = 2,
            name = "Description for Computer 2",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s"
        ),
        LahangaResponseDataItem(
            id = 3,
            name = "Description for Computer 3",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s"
        ),
        LahangaResponseDataItem(
            id = 4,
            name = "Description for Computer 4",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
    )

    fun getLahangaDetailsById(id: Int): LahangaDetails? {
        return when (id) {
            1 -> LahangaDetails(
                id = 1,
                name = "Description for Computer 1",
                imageUrl = "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            2 -> LahangaDetails(
                id = 2,
                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            else -> null
        }
    }
}