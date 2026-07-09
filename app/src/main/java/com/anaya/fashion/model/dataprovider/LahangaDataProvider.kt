package com.anaya.fashion.model.dataprovider

import com.anaya.fashion.R
import com.anaya.fashion.model.lahanga.LahangaDetails
import com.anaya.fashion.model.lahanga.LahangaResponseDataItem

object LahangaDataProvider {


    fun getLahangaList(fromWhichScreen: String?): ArrayList<LahangaResponseDataItem> {
        val resultList = arrayListOf<LahangaResponseDataItem>()
        when (fromWhichScreen) {
            "LEHANGA" -> {
                resultList.addAll(allProductList.filter { it.isLehanga })
            }

            "SHERWANI" -> {
                resultList.addAll(allProductList.filter { !it.isLehanga })
            }

            "OFFERS" -> {
                resultList.addAll(allProductList.filter {
                    // return if offer percentage is greater than 30%
                    val offerPercentage =
                        ((it.actualPrice - it.sellingPrice).toDouble() / it.actualPrice) * 100
                    offerPercentage >= 30
                })
            }

            else -> {
                resultList.addAll(allProductList)
            }
        }
        return resultList
    }

    private val allProductList = arrayListOf(
        LahangaResponseDataItem(
            id = 1,
            name = "Pink Embroided lehanga",
            imageUrl = "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
            sellingPrice = 50,
            actualPrice = 100,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),
        LahangaResponseDataItem(
            id = 2,
            name = "Blue premium design lehanga",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
            sellingPrice = 70,
            actualPrice = 100,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 3,
            name = "Purple Embroidered Lehenga ",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
            sellingPrice = 10000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 4,
            name = "Purple Embroidered Lehenga ",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
            sellingPrice = 10000,
            actualPrice = 15000,
            isBestSeller = true,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 5,
            name = "Self Design Stiched lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 6,
            name = "Trendy red lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 4000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 7,
            name = "Purple Embroidered Lehenga ",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 8,
            name = "Women's Shimmer Slik Traditional lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 3000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 9,
            name = "Pink Stain Embellished lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 2000,
            actualPrice = 9000,
            isBestSeller = true,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 10,
            name = "Women Red Floral Viscose Lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 5000,
            actualPrice = 9000,
            isBestSeller = true,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 11,
            name = "Chanda Sitara Purple Embroided lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 12,
            name = "Off-White Jackquard Chex Lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 8000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 13,
            name = "Brown Premium Lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 1000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 14,
            name = "Purple Embroidered Suite",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 5000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),
        LahangaResponseDataItem(
            id = 15,
            name = "Navy Blue Floral Print Lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 4000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 16,
            name = "Orange Embroided Top lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 4000,
            actualPrice = 9000,
            isBestSeller = true,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 17,
            name = "Maroon Brasso Floral Printed Lehanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 9000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 18,
            name = "Yellow Embroided Crop-Top Lhanga",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),
        LahangaResponseDataItem(
            id = 18,
            name = "My Dummy Sherwani",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),
        LahangaResponseDataItem(
            id = 18,
            name = "My Dummy Sherwani 2",
            imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),


        )

    fun getLahangaDetailsById(id: Int): LahangaDetails? {
        return when (id) {
            1 -> LahangaDetails(
                id = 1,
                imageUrl = "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                name = "Pink Embroided lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 4000,
                sizes = listOf(32, 34, 36, 38, 40),
                colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
            )

            2 -> LahangaDetails(
                id = 2,
                name = "Blue premium design lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 5000,

                )

            3 -> LahangaDetails(
                id = 3,
                name = "Description for Computer 2",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 10000,
            )

            4 -> LahangaDetails(
                id = 4,
                name = "Purple Embroidered Lehenga ",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 10000,
            )

            5 -> LahangaDetails(
                id = 5,
                name = "Self Design Stiched lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 7000,
            )

            6 -> LahangaDetails(
                id = 6,
                name = "Trendy red lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 4000,
            )

            7 -> LahangaDetails(
                id = 7,
                name = "Purple Embroidered Lehenga ",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 9000,
            )

            8 -> LahangaDetails(
                id = 8,
                name = "Women's Shimmer Slik Traditional lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 3000,
            )

            9 -> LahangaDetails(
                id = 9,
                name = "Pink Stain Embellished lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 2000,
            )

            10 -> LahangaDetails(
                id = 10,
                name = "Women Red Floral Viscose Lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 5000,
            )

            11 -> LahangaDetails(
                id = 11,
                name = "Chanda Sitara Purple Embroided lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 7000,
            )

            12 -> LahangaDetails(
                id = 12,
                name = "Off-White Jackquard Chex Lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 8000,
            )

            13 -> LahangaDetails(
                id = 13,
                name = "Brown Premium Lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 1000,
            )

            14 -> LahangaDetails(
                id = 14,
                name = "Purple Embroidered Suite",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 5000,
            )

            15 -> LahangaDetails(
                id = 15,
                name = "Navy Blue Floral Print Lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 4000,
            )

            16 -> LahangaDetails(
                id = 16,
                name = "Orange Embroided Top lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 4000,
            )


            17 -> LahangaDetails(
                id = 17,
                name = "Maroon Brasso Floral Printed Lehanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 9000,
            )

            18 -> LahangaDetails(
                id = 18,
                name = "Yellow Embroided Crop-Top Lhanga",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 7000,

                )

            else -> null
        }
    }

    fun getCartList(productId: String): ArrayList<LahangaDetails> {
        val list = arrayListOf<LahangaDetails>()
        //productId = "1,2,3,4"
        val productIds = productId.split(",")
        productIds.forEach {
            val trimmedId = it.trim()
            if (trimmedId.isNotEmpty()) {
                val id = trimmedId.toIntOrNull()
                if (id != null) {
                    val details = getLahangaDetailsById(id)
                    println("Product ID: ${details?.id}, Description: ${details?.description}")
                    details?.let { item ->
                        list.add(item)
                    }
                }
            }
        }

        return list
    }


    fun searchProduct(fromWhichScreen: String, search: String): ArrayList<LahangaResponseDataItem> {
        //TODO Use fromWhichScreen to filter the list based on the screen from which the search is initiated
        val searchList = arrayListOf<LahangaResponseDataItem>()
        val list = getLahangaList(fromWhichScreen)
        list.forEach {
            if (it.name.contains(search, ignoreCase = true)) {
                searchList.add(it)
            }
        }
        return searchList
    }

    fun searchProduct2(
        fromWhichScreen: String,
        search: String
    ): ArrayList<LahangaResponseDataItem> {
        val list = getLahangaList(fromWhichScreen).filter {
            it.name.contains(search, ignoreCase = true)
        } as ArrayList<LahangaResponseDataItem>
        return list
    }


    private val wishlist = arrayListOf<LahangaDetails>()

    fun addToWishlist(item: LahangaDetails) {
        if (!wishlist.any { it.id == item.id }) {
            wishlist.add(item)
        }
    }

    fun getWishlist(): ArrayList<LahangaDetails> {
        return ArrayList(wishlist)
    }

    fun removeFromWishlist(item: LahangaDetails) {
        wishlist.removeAll { it.id == item.id }
    }
}