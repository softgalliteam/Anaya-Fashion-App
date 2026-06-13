package com.learning.exp.model.dataprovider

import com.learning.exp.R
import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem

object LahangaDataProvider {


    fun getLahangaList() = arrayListOf(
        LahangaResponseDataItem(
            id = 1,
            name = "Purple Embroidered Lehenga 1",
            imageUrl = "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823"
        ),
        LahangaResponseDataItem(
            id = 2,
            name = "Purple Embroidered Lehenga 2",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s"
        ),
        LahangaResponseDataItem(
            id = 3,
            name = "Purple Embroidered Lehenga 3",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s"
        ),
        LahangaResponseDataItem(
            id = 5,
            name = "Purple Embroidered Lehenga 4",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 6,
            name = "Purple Embroidered Lehenga 5",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 7,
            name = "Purple Embroidered Lehenga 6",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 8,
            name = "Purple Embroidered Lehenga 7",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 9,
            name = "Purple Embroidered Lehenga 8",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 10,
            name = "Purple Embroidered Lehenga 9",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 11,
            name = "Purple Embroidered Lehenga 10",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 12,
            name = "Purple Embroidered Lehenga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 13,
            name = "Purple Embroidered Lehenga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 14,
            name = "Purple Embroidered Lehenga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 15,
            name = "Purple Embroidered Lehenga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 16,
            name = "Purple Embroidered Lehenga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 17,
            name = "Purple Embroidered Lehenga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),
        LahangaResponseDataItem(
            id = 18,
            name = "Purple Embroidered Lehenga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
        ),


        )

    fun getLahangaDetailsById(id: Int): LahangaDetails? {
        return when (id) {
            1 -> LahangaDetails(
                id = 1,
                imageUrl = "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                name = "Purple Embroidered Lehenga 1",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 4000,
                sizes = listOf(32, 34, 36, 38, 40),
                colors = listOf(R.color.red, R.color.black, R.color.purple),
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
                ),
                price = 5000
            )

            3 -> LahangaDetails(
                id = 3,
                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 10000
            )

            4 -> LahangaDetails(
                id = 4,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            5 -> LahangaDetails(
                id = 5,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            6 -> LahangaDetails(
                id = 6,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            7 -> LahangaDetails(
                id = 7,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            8 -> LahangaDetails(
                id = 8,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            9 -> LahangaDetails(
                id = 9,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            10 -> LahangaDetails(
                id = 10,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            11 -> LahangaDetails(
                id = 11,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            12 -> LahangaDetails(
                id = 12,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            13 -> LahangaDetails(
                id = 13,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            14 -> LahangaDetails(
                id = 14,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            15 -> LahangaDetails(
                id = 16,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            17 -> LahangaDetails(
                id = 17,
//                name = "Description for Computer 2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                )
            )

            18 -> LahangaDetails(
                id = 18,
//                name = "Description for Computer 2",
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

    fun getCartList(productId: String): ArrayList<LahangaDetails> {
        val list = arrayListOf<LahangaDetails>()
        //productId = "1,2,3,4"
        val productIds = productId.split(",")
        productIds.forEach {
            if (it.isNotEmpty()) {
                val details = getLahangaDetailsById(it.toInt())
                println("Product ID: ${details?.id}, Description: ${details?.description}")
                list.add(details!!)
            }
        }

        return list
    }
}