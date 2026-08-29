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
            name = "Embroidered Semi Stitched Lehenga Choli",
           imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/i/9/y/free-sleeveless-sirat-purvaja-original-imah4ju5zrdh6ffg.jpeg?q=90",
            sellingPrice = 50,
            actualPrice = 100,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),
        LahangaResponseDataItem(
            id = 2,
            name = "Blue premium design lehanga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/a/4/6/free-half-sleeve-11263-hetanshimcnx-original-imahp89tkagwkhaq.jpeg?q=90",
            sellingPrice = 70,
            actualPrice = 100,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 3,
            name = "Embroidered Semi Stitched Lehenga Choli",
            imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/b/y/j/free-3-4-sleeve-11133-hetanshimcnx-original-imahz8u8krdcvpas.jpeg?q=90",
            sellingPrice = 10000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 4,
            name = "HetanshiMcnx Embroidered Semi Stitched Lehenga ",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/c/c/d/free-half-sleeve-11542-hetanshimcnx-original-imahpbuxajuygxz9.jpeg?q=90",
            sellingPrice = 10000,
            actualPrice = 15000,
            isBestSeller = true,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 5,
            name = "Self Design Stiched lehanga",
            imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/2/o/p/free-half-sleeve-11413-hetanshimcnx-original-imahp89qqgx3sdyk.jpeg?q=90",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 6,
            name = "Trendy red lehanga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/j/p/2/free-3-4-sleeve-10771-hetanshimcnx-original-imahn3svfq9wknys.jpeg?q=90",
            sellingPrice = 4000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 7,
            name = "Purple Embroidered Lehenga ",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/j/m/b/free-sleeveless-1003-teal-nividh-fashion-original-imahnuhad8bqhgfu.jpeg?q=90",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 8,
            name = "Women's Shimmer Slik Traditional lehanga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/n/y/i/free-short-sleeve-01-tablecreations-original-imahpvypkphsdwh6.jpeg?q=90",
            sellingPrice = 3000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 9,
            name = "Festive Lehenga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/z/u/j/free-na-tcdno193-odette-original-imahzhznyz4swnxg.jpeg?q=90",
            sellingPrice = 2000,
            actualPrice = 9000,
            isBestSeller = true,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 10,
            name = "Lightweight Lehenga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/1/u/j/free-sleeveless-nf-lh-1007-beige-nividh-fashion-original-imahpaz2yxfwjyqd.jpeg?q=90",
            sellingPrice = 5000,
            actualPrice = 9000,
            isBestSeller = true,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 11,
            name = "odette Embellished Semi Stitched Lehenga Choli (Purple)",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/8/y/d/free-na-dvdplus5133purple-odette-original-imahpp2mmz4qnk4t.jpeg?q=90",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 12,
            name = "Wedding Guest Lehenga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/w/9/q/free-half-sleeve-11202-hetanshimcnx-original-imahp89snqz53h4p.jpeg?q=90",
            sellingPrice = 8000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 13,
            name = "Brown Premium Lehanga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/u/g/n/free-3-4-sleeve-ay8112-odette-original-imahdygekcmfdhwy.jpeg?q=90",
            sellingPrice = 1000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 14,
            name = "odette Embellished Semi Stitched Lehenga Choli (Pink)",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/s/h/0/free-3-4-sleeve-kf29purple-odette-original-imahcvvg2yrxdhpe.jpeg?q=90",
            sellingPrice = 5000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),
        LahangaResponseDataItem(
            id = 15,
            name = "Embellished Semi Stitched Lehenga Choli (Gray)",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/d/y/q/free-3-4-sleeve-kf30grey-odette-original-imahcvvhhhngqs2g.jpeg?q=90",
            sellingPrice = 4000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 16,
            name = " Traditional Lehenga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/z/c/2/free-half-sleeve-11074-hetanshimcnx-original-imahp8a2xxhupzha.jpeg?q=90",
            sellingPrice = 4000,
            actualPrice = 9000,
            isBestSeller = true,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 17,
            name = "Designer Lehenga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/p/r/u/free-3-4-sleeve-ay96001-odette-original-imahcycha7bwkzgg.jpeg?q=90",
            sellingPrice = 9000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),

            ),
        LahangaResponseDataItem(
            id = 18,
            name = "Yellow Embroided Crop-Top Lhanga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/n/t/4/free-half-sleeve-maha-purva-1-jivuba-original-imahq3ksg3dbutq3.jpeg?q=90",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),
        LahangaResponseDataItem(
            id = 19,
            name = "DARSHIT CREATION Embroidered Semi Stitched Lehenga Choli (Light Green)",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/u/y/y/free-half-sleeve-ad-cinderella-vol11-8401-03-08-divine-original-imahba93y3qkyuhq.jpeg?q=90",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),
        LahangaResponseDataItem(
            id = 20,
            name = "Bridal Lehenga",
            imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/n/h/w/free-sleeveless-sirat-purvaja-original-imah4ju5hcmsy9zf.jpeg?q=90",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),

//        FOR SHERWANI //

        LahangaResponseDataItem(
            id = 21,
            name = "Off White Sherwani with Collar and Sleeve Embroidered",
            imageUrl = "https://ihtifal.in/cdn/shop/files/ETERNALSHERWANIFORGROOM1.webp?v=1747227369&width=1206",
            sellingPrice = 12000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),

        LahangaResponseDataItem(
            id = 22,
            name = "Off White Sherwani with Collar and Sleeve Embroidered",
            imageUrl = "https://ihtifal.in/cdn/shop/files/OffWhiteSherwaniwithCollarandSleeveEmbroidered1.webp?v=1749552360&width=1206",
            sellingPrice = 11000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),

        LahangaResponseDataItem(
            id = 23,
            name = "Cream Silk Sherwani with Zardoshi, Resham & Kasab Work",
            imageUrl = "https://shreeman.in/cdn/shop/files/1J8A1337.jpg?v=1768565237&width=1400",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),

        LahangaResponseDataItem(
            id = 24,
            name = "Off White Silk Sherwani",
            imageUrl = "https://shreeman.in/cdn/shop/files/1J8A0750.jpg?v=1740806984&width=1400",
            sellingPrice = 6000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),

        LahangaResponseDataItem(
            id = 25,
            name = "Ice Blue Silk Indo Western ",
            imageUrl = "https://shreeman.in/cdn/shop/files/1J8A1050.jpg?v=1740463593&width=1400",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),

        LahangaResponseDataItem(
            id = 26,
            name = "Black Silk Indo Western Sherwani",
            imageUrl = "https://shreeman.in/cdn/shop/files/1J8A0996.jpg?v=1740462841&width=1400",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),

        LahangaResponseDataItem(
            id = 27,
            name = "Ivory Raw Silk Sherwani ",
            imageUrl = "https://shreeman.in/cdn/shop/files/1J8A4220.jpg?v=1728558147&width=1400",
            sellingPrice = 8000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),

        LahangaResponseDataItem(
            id = 28,
            name = "Ivory Raw Silk Sherwani with Thread and Bead Cutdana Work",
            imageUrl = "https://shreeman.in/cdn/shop/files/1J8A4560.jpg?v=1733317904&width=1400",
            sellingPrice = 10000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),
        LahangaResponseDataItem(
            id = 29,
            name = "Ivory Silk Indo Western with Jungle-Themed Thread Work",
            imageUrl = "https://shreeman.in/cdn/shop/files/1J8A4456.jpg?v=1728561297&width=1400",
            sellingPrice = 7000,
            actualPrice = 9000,
            isBestSeller = false,
            isLehanga = false,
            colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
        ),

        LahangaResponseDataItem(
            id = 30,
            name = "Golden Silk Tissue Sherwani with Resham Work",
            imageUrl = "https://shreeman.in/cdn/shop/files/1J8A3260.jpg?v=1769776211&width=1400",
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
                name = "Embroidered Semi Stitched Lehenga Choli",
                description = "PURVAJA Self Design Semi Stitched Lehenga Choli (Light Green)",
                "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/i/9/y/free-sleeveless-sirat-purvaja-original-imah4ju5zrdh6ffg.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/i/9/y/free-sleeveless-sirat-purvaja-original-imah4ju5zrdh6ffg.jpeg?q=90",
                   "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/y/k/h/free-sleeveless-sirat-purvaja-original-imah4ju5frwpkgc3.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/4/3/s/free-sleeveless-sirat-purvaja-original-imah4ju5sgujs425.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/3/h/p/free-sleeveless-sirat-purvaja-original-imah4ju5c6mby7h7.jpeg?q=90"
                ),
                price = 4000,
                sizes = listOf(32, 34, 36, 38, 40),
                colors = listOf(R.color.red, R.color.black, R.color.purple, R.color.yellow),
            )

            2 -> LahangaDetails(
                id = 2,
                name = "Blue premium design lehanga",
                description = "PURVAJA Self Design Semi Stitched Lehenga Choli (Light Green)",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/a/4/6/free-half-sleeve-11263-hetanshimcnx-original-imahp89tkagwkhaq.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/7/a/r/free-half-sleeve-11263-hetanshimcnx-original-imahp89tnwfpbnfs.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/m/o/i/free-half-sleeve-11263-hetanshimcnx-original-imahp89tuhnmwtbh.jpeg?q=90",
                   "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/o/k/l/free-half-sleeve-11263-hetanshimcnx-original-imahp89tvagvwn7p.jpeg?q=90"
                ),
                price = 5000,

                )

            3 -> LahangaDetails(
                id = 3,
                name = "HetanshiMcnx Embroidered Semi Stitched Lehenga Choli (Multicolor)",
                description = "HetanshiMcnx Embroidered Semi Stitched Lehenga Choli (Multicolor)",
                imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/b/y/j/free-3-4-sleeve-11133-hetanshimcnx-original-imahz8u8krdcvpas.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/b/y/j/free-3-4-sleeve-11133-hetanshimcnx-original-imahz8u8krdcvpas.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/7/q/d/free-3-4-sleeve-11133-hetanshimcnx-original-imahz8ushzz3c5fh.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/e/b/k/free-3-4-sleeve-11133-hetanshimcnx-original-imahz8u7nffsbxha.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/f/g/b/free-3-4-sleeve-11133-hetanshimcnx-original-imahz8u7h9uzq7fg.jpeg?q=90"
                ),
                price = 10000,
            )

            4 -> LahangaDetails(
                id = 4,
                name = "HetanshiMcnx Embroidered Semi Stitched Lehenga ",
                description = "Emborded lehnga made with Hand & Crop Top (Purple)",
                imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/c/c/d/free-half-sleeve-11542-hetanshimcnx-original-imahpbuxajuygxz9.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/c/c/d/free-half-sleeve-11542-hetanshimcnx-original-imahpbuxajuygxz9.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/9/v/a/free-half-sleeve-11542-hetanshimcnx-original-imahpbuwzdmjrbyq.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/z/1/e/free-half-sleeve-11542-hetanshimcnx-original-imahpbuxq6v5fgyj.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/d/l/b/free-half-sleeve-11542-hetanshimcnx-original-imahpbuw6rrxvumz.jpeg?q=90"
                ),
                price = 10000,
            )

            5 -> LahangaDetails(
                id = 5,
                name = "Self Design Stiched lehanga",
                description = "Self Design Stiched lehanga, HetanshiMcnx Embroidered Semi Stitched Lehenga Choli (Pink)",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/2/o/p/free-half-sleeve-11413-hetanshimcnx-original-imahp89qqgx3sdyk.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/2/o/p/free-half-sleeve-11413-hetanshimcnx-original-imahp89qqgx3sdyk.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/t/2/z/free-half-sleeve-11413-hetanshimcnx-original-imahp89qxdgfhamh.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/e/q/l/free-half-sleeve-11413-hetanshimcnx-original-imahp89qbtm4gyzt.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/h/x/j/free-half-sleeve-11413-hetanshimcnx-original-imahp89qdrg3jnth.jpeg?q=90"
                ),
                price = 7000,
            )

            6 -> LahangaDetails(
                id = 6,
                name = "HetanshiMcnx Embroidered Semi Stitched Lehenga Choli (Pink)",
                description = "This is a detailed description for Lahanga with ID $id. It includes information about the design, fabric, and other features of the lahanga.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/j/p/2/free-3-4-sleeve-10771-hetanshimcnx-original-imahn3svfq9wknys.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/j/p/2/free-3-4-sleeve-10771-hetanshimcnx-original-imahn3svfq9wknys.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/4/k/k/free-3-4-sleeve-10771-hetanshimcnx-original-imahn3sz5xamtyhg.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/i/2/j/free-3-4-sleeve-10771-hetanshimcnx-original-imahn3ssunfyf68q.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/g/c/e/free-3-4-sleeve-10771-hetanshimcnx-original-imahn3szpshrue8s.jpeg?q=90"
                ),
                price = 4000,
            )

            7 -> LahangaDetails(
                id = 7,
                name = "Purple Embroidered Lehenga ",
                description = "A stunning bridal lehenga designed for brides who want to make a statement on their special day.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/j/m/b/free-sleeveless-1003-teal-nividh-fashion-original-imahnuhad8bqhgfu.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/j/m/b/free-sleeveless-1003-teal-nividh-fashion-original-imahnuhad8bqhgfu.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/o/g/w/free-sleeveless-1003-teal-nividh-fashion-original-imahnuhamkgzj3aw.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/c/4/q/free-sleeveless-1003-teal-nividh-fashion-original-imahnuhadz3jmzde.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/k/t/c/free-sleeveless-1003-teal-nividh-fashion-original-imahnuha2c3kp4mc.jpeg?q=90"
                ),
                price = 9000,
            )

            8 -> LahangaDetails(
                id = 8,
                name = "Women's Shimmer Slik Traditional lehanga",
               description = "The luxurious fabric gives the lehenga an elegant fall, while the detailed craftsmanship adds depth and sophistication",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/n/y/i/free-short-sleeve-01-tablecreations-original-imahpvypkphsdwh6.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/n/y/i/free-short-sleeve-01-tablecreations-original-imahpvypkphsdwh6.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/s/u/m/free-short-sleeve-01-tablecreations-original-imahpvypp6xsy2wd.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/8/z/0/free-short-sleeve-01-tablecreations-original-imahpvypjejaspss.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/z/h/n/free-short-sleeve-01-tablecreations-original-imahpvypawutwhdh.jpeg?q=90"
                ),
                price = 3000,
            )

            9 -> LahangaDetails(
                id = 9,
                name = "Festive Lehenga",
                description = "Make every celebration memorable with this elegant designer lehenga featuring beautiful embroidery and sophisticated detailing.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/z/u/j/free-na-tcdno193-odette-original-imahzhznyz4swnxg.jpeg?q=90",
                imageList = listOf(
                   "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/z/u/j/free-na-tcdno193-odette-original-imahzhznyz4swnxg.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/v/d/0/free-na-tcdno193-odette-original-imahzhzn5vhhzg8y.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/a/n/t/free-na-tcdno193-odette-original-imahzhznbjggxgku.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/a/n/t/free-na-tcdno193-odette-original-imahzhznbjggxgku.jpeg?q=90"
                ),
                price = 2000,
            )

            10 -> LahangaDetails(
                id = 10,
                name = "Lightweight Lehenga",
                description = "The lightweight construction allows comfortable movement while maintaining a beautiful traditional look.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/1/u/j/free-sleeveless-nf-lh-1007-beige-nividh-fashion-original-imahpaz2yxfwjyqd.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/1/u/j/free-sleeveless-nf-lh-1007-beige-nividh-fashion-original-imahpaz2yxfwjyqd.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/i/l/j/free-sleeveless-nf-lh-1007-beige-nividh-fashion-original-imahpaz2ywxy2ghn.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/j/r/m/free-sleeveless-nf-lh-1007-beige-nividh-fashion-original-imahpaz2twyuy9a3.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/w/9/i/free-sleeveless-nf-lh-1007-beige-nividh-fashion-original-imahpaz2fehyecmc.jpeg?q=90"
                ),
                price = 5000,
            )

            11 -> LahangaDetails(
                id = 11,
                name = "odette Embellished Semi Stitched Lehenga Choli (Purple)",
                description = "Designed for those who want to look elegant without taking attention away from the bride, this wedding guest lehenga combines traditional charm with modern fashion.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/8/y/d/free-na-dvdplus5133purple-odette-original-imahpp2mmz4qnk4t.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/8/y/d/free-na-dvdplus5133purple-odette-original-imahpp2mmz4qnk4t.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/j/e/s/free-na-dvdplus5133purple-odette-original-imahpp2mgu9armcy.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/k/3/l/free-na-dvdplus5133purple-odette-original-imahpp2mgw83mwyf.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/b/g/q/free-na-dvdplus5133purple-odette-original-imahpp2mhgh2smvg.jpeg?q=90"
                ),
                price = 7000,
            )

            12 -> LahangaDetails(
                id = 12,
                name = "Wedding Guest Lehenga",
                description = "Designed for those who want to look elegant without taking attention away from the bride, this wedding guest lehenga combines traditional charm with modern fashion.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/w/9/q/free-half-sleeve-11202-hetanshimcnx-original-imahp89snqz53h4p.jpeg?q=90",
                imageList = listOf(
                   "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/w/9/q/free-half-sleeve-11202-hetanshimcnx-original-imahp89snqz53h4p.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/k/b/e/free-half-sleeve-11202-hetanshimcnx-original-imahp89sf9jnware.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/b/v/g/free-half-sleeve-11202-hetanshimcnx-original-imahp89szfrt4gcy.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/v/g/5/free-half-sleeve-11202-hetanshimcnx-original-imahp89sd2p3k7hx.jpeg?q=90"
                ),
                price = 8000,
            )

            13 -> LahangaDetails(
                id = 13,
                name = "Brown Premium Lehanga",
                description = "The coordinated blouse and dupatta provide a polished and sophisticated finish. Perfect for weddings, sangeet ceremonies, mehndi functions, engagement parties, and family celebrations.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/u/g/n/free-3-4-sleeve-ay8112-odette-original-imahdygekcmfdhwy.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/u/g/n/free-3-4-sleeve-ay8112-odette-original-imahdygekcmfdhwy.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/v/s/g/free-3-4-sleeve-ay8112-odette-original-imahdygegfaxf5s3.jpeg?q=90",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXyeP2j4b0nlOl9HUDm-_N-eje_KH88-a1Lg&s",
                    "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg"
                ),
                price = 1000,
            )

            14 -> LahangaDetails(
                id = 14,
                name = "odette Embellished Semi Stitched Lehenga Choli (Pink)",
               description = "The graceful flare creates a stunning appearance when you move, making it perfect for festive celebrations.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/s/h/0/free-3-4-sleeve-kf29purple-odette-original-imahcvvg2yrxdhpe.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/s/h/0/free-3-4-sleeve-kf29purple-odette-original-imahcvvg2yrxdhpe.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/j/g/2/free-3-4-sleeve-kf29purple-odette-original-imahcvvhheptezme.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/o/4/l/free-3-4-sleeve-kf29purple-odette-original-imahcvvgudah5fk9.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/w/p/p/free-3-4-sleeve-kf29purple-odette-original-imahcvvgmazywpj8.jpeg?q=90"
                ),
                price = 5000,
            )

            15 -> LahangaDetails(
                id = 15,
                name = "odette Embellished Semi Stitched Lehenga Choli (Grey)",
                description = "Ideal for Diwali, Navratri, Karwa Chauth, family functions, puja ceremonies, and festive gatherings.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/d/y/q/free-3-4-sleeve-kf30grey-odette-original-imahcvvhhhngqs2g.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/d/y/q/free-3-4-sleeve-kf30grey-odette-original-imahcvvhhhngqs2g.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/c/p/0/free-3-4-sleeve-kf30grey-odette-original-imahcvvg9zuzgvgu.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/q/4/g/free-3-4-sleeve-kf30grey-odette-original-imahcvvh8hmhfag5.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/l/k/q/free-3-4-sleeve-kf30grey-odette-original-imahcvvgg8ndpghh.jpeg?q=90"
                ),
                price = 4000,
            )

            16 -> LahangaDetails(
                id = 16,
                name = "Traditional Lehenga",
                description = "Perfect for weddings, sangeet ceremonies, mehndi functions, engagement parties, and family celebrations",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/z/c/2/free-half-sleeve-11074-hetanshimcnx-original-imahp8a2xxhupzha.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/z/c/2/free-half-sleeve-11074-hetanshimcnx-original-imahp8a2xxhupzha.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/v/u/5/free-half-sleeve-11074-hetanshimcnx-original-imahp8a2sjfwqyaq.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/g/9/9/free-half-sleeve-11074-hetanshimcnx-original-imahp8a27gek8mvx.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/1/o/n/free-half-sleeve-11074-hetanshimcnx-original-imahp8a2dwd5gues.jpeg?q=90"
                ),
                price = 4000,
            )

            17 -> LahangaDetails(
                id = 17,
                name = "Designer Lehenga",
                description = "This versatile outfit can be styled with delicate jewelry and neutral accessories for a classy look.",
                imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/p/r/u/free-3-4-sleeve-ay96001-odette-original-imahcycha7bwkzgg.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/p/r/u/free-3-4-sleeve-ay96001-odette-original-imahcycha7bwkzgg.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/3/w/2/free-3-4-sleeve-ay96001-odette-original-imahcychmhgh92ay.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/p/r/u/free-3-4-sleeve-ay96001-odette-original-imahcycha7bwkzgg.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/4/i/g/free-3-4-sleeve-ay96001-odette-original-imahcych6ejgtebj.jpeg?q=90"
                ),
                price = 9000,
            )

            18 -> LahangaDetails(
                id = 18,
                name = "jivuba Printed Semi Stitched Lehenga Choli (Dark Blue)",
                description = "Style and comfort come together in this beautiful lightweight lehenga, specially designed for occasions where you want to enjoy your celebration without feeling uncomfortable.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/n/t/4/free-half-sleeve-maha-purva-1-jivuba-original-imahq3ksg3dbutq3.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/n/t/4/free-half-sleeve-maha-purva-1-jivuba-original-imahq3ksg3dbutq3.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/e/d/1/free-half-sleeve-purva-ak2-a-n-blue-firoji-jivuba-original-imahpywyzxgfhgyh.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/w/y/1/free-half-sleeve-purva-ak2-a-n-blue-firoji-jivuba-original-imahpyvztsaxmz2e.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/z/n/p/free-half-sleeve-purva-ak2-a-n-blue-firoji-jivuba-original-imahpywycxanncga.jpeg?q=90"
                ),
                price = 7000,

                )

            19 -> LahangaDetails(
                id = 19,
                name = "DARSHIT CREATION Embroidered Semi Stitched Lehenga Choli (Light Green)",
                description = "The beautifully coordinated blouse and dupatta complete the outfit and make it ideal for creating a statement look.",
                imageUrl ="https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/u/y/y/free-half-sleeve-ad-cinderella-vol11-8401-03-08-divine-original-imahba93y3qkyuhq.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/u/y/y/free-half-sleeve-ad-cinderella-vol11-8401-03-08-divine-original-imahba93y3qkyuhq.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/w/v/o/free-half-sleeve-ad-cinderella-vol11-8401-03-08-divine-original-imahba93ugzfztt8.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/w/i/k/free-half-sleeve-ad-cinderella-vol11-8401-03-08-divine-original-imahba93yzahpzs7.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/y/n/d/free-half-sleeve-ad-cinderella-vol11-8401-03-08-divine-original-imahba93a22hdfzy.jpeg?q=90"
                ),
                price = 7000,

                )

            20 -> LahangaDetails(
                id = 20,
                name = "Bridal Lehenga",
                description = "Perfect for bridal events, grand weddings, receptions, engagement ceremonies, luxury parties, and other important celebrations.",
                imageUrl = "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/n/h/w/free-sleeveless-sirat-purvaja-original-imah4ju5hcmsy9zf.jpeg?q=90",
                imageList = listOf(
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/n/h/w/free-sleeveless-sirat-purvaja-original-imah4ju5hcmsy9zf.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/c/e/0/free-sleeveless-sirat-purvaja-original-imah4ju5knhrsukq.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/p/x/i/free-sleeveless-sirat-purvaja-original-imah4ju5fp2wrcgh.jpeg?q=90",
                    "https://rukminim2.flixcart.com/image/2940/2940/xif0q/lehenga-choli/7/t/z/free-sleeveless-sirat-purvaja-original-imah4ju53e6wq4rt.jpeg?q=90"

                ),
                price = 7000,

                )

//            FOR SHERWANI //

            21 -> LahangaDetails(
                id = 21,
                name = "Off White Sherwani with Collar and Sleeve Embroidered",
                description = "Perfect for bridal events, grand weddings, receptions, engagement ceremonies, luxury parties, and other important celebrations.",
                imageUrl = "https://ihtifal.in/cdn/shop/files/ETERNALSHERWANIFORGROOM1.webp?v=1747227369&width=1206",
                imageList = listOf(
                    "https://ihtifal.in/cdn/shop/files/ETERNALSHERWANIFORGROOM1.webp?v=1747227369&width=1206",
                    "https://ihtifal.in/cdn/shop/files/ETERNALSHERWANIFORGROOM2.webp?v=1747227369&width=1206",
                    "https://ihtifal.in/cdn/shop/files/ETERNALSHERWANIFORGROOM3.webp?v=1747227369&width=1206",
                    "https://ihtifal.in/cdn/shop/files/ETERNALSHERWANIFORGROOM1.webp?v=1747227369&width=12060"

                ),
                price = 12000,

                )

            22 -> LahangaDetails(
                id = 22,
                name = "Off White Sherwani with Collar and Sleeve Embroidered",
                description = "Perfect for bridal events, grand weddings, receptions, engagement ceremonies, luxury parties, and other important celebrations.",
                imageUrl = "https://ihtifal.in/cdn/shop/files/OffWhiteSherwaniwithCollarandSleeveEmbroidered1.webp?v=1749552360&width=1206",
                imageList = listOf(
                    "https://ihtifal.in/cdn/shop/files/OffWhiteSherwaniwithCollarandSleeveEmbroidered1.webp?v=1749552360&width=1206",
                    "https://ihtifal.in/cdn/shop/files/OffWhiteSherwaniwithCollarandSleeveEmbroidered2.webp?v=1749552360&width=1206",
                    "https://ihtifal.in/cdn/shop/files/OffWhiteSherwaniwithCollarandSleeveEmbroidered3.webp?v=1749552360&width=1206",
                    "https://ihtifal.in/cdn/shop/files/OffWhiteSherwaniwithCollarandSleeveEmbroidered3.webp?v=1749552360&width=1206"

                ),
                price = 11000,

                )

            23 -> LahangaDetails(
                id = 23,
                name = "Cream Silk Sherwani with Zardoshi, Resham & Kasab Work",
                description = "Perfect for bridal events, grand weddings, receptions, engagement ceremonies, luxury parties, and other important celebrations.",
                imageUrl = "https://shreeman.in/cdn/shop/files/1J8A1337.jpg?v=1768565237&width=1400",
                imageList = listOf(
                    "https://shreeman.in/cdn/shop/files/1J8A1337.jpg?v=1768565237&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A1333.jpg?v=1768565237&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A1347.jpg?v=1768565219&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A1349.jpg?v=1768565219&width=1400"

                ),
                price = 7000,

                )

            24 -> LahangaDetails(
                id = 24,
                name = "Groom Sherwani For Man Wedding",
                description = "Off White Silk Sherwani with Resham, Aari & Sequence Work",
                imageUrl = "https://shreeman.in/cdn/shop/files/1J8A0750.jpg?v=1740806984&width=1400",
                imageList = listOf(
                    "https://shreeman.in/cdn/shop/files/1J8A0750.jpg?v=1740806984&width=1400aja-original-imah4ju5hcmsy9zf.jpeg?q=90",
                    "https://shreeman.in/cdn/shop/files/1J8A0746.jpg?v=1740806984&width=1400riginal-imah4ju5knhrsukq.jpeg?q=90",
                    "https://shreeman.in/cdn/shop/files/1J8A0755.jpg?v=1740806983&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A0776.jpg?v=1740806983&width=1400"

                ),
                price = 6000,

                )

            25 -> LahangaDetails(
                id = 25,
                name = "Ice Blue Silk Indo Western ",
                description = "Ice Blue Silk Indo Western with Silver Thread Aari Work",
                imageUrl = "https://shreeman.in/cdn/shop/files/1J8A1050.jpg?v=1740463593&width=1400",
                imageList = listOf(
                    "https://shreeman.in/cdn/shop/files/1J8A1046.jpg?v=1740463593&width=1400inal-imah4ju5hcmsy9zf.jpeg?q=90",
                    "https://shreeman.in/cdn/shop/files/1J8A1052.jpg?v=1740463310&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A1055.jpg?v=1740463310&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A1065.jpg?v=1740463310&width=1400"

                ),
                price = 7000,

                )

            26 -> LahangaDetails(
                id = 26,
                name = "Black Silk Indo Western Sherwani",
                description = "Perfect for Groom events, grand weddings, receptions, engagement ceremonies, luxury parties, and other important celebrations.",
                imageUrl = "https://shreeman.in/cdn/shop/files/1J8A0996.jpg?v=1740462841&width=1400",
                imageList = listOf(
                    "https://shreeman.in/cdn/shop/files/1J8A0996.jpg?v=1740462841&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A1023.jpg?v=1740462841&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A1038.jpg?v=1740462841&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A1042.jpg?v=1740462841&width=1400"

                ),
                price = 7000,

                )

            27 -> LahangaDetails(
                id = 27,
                name = "Ivory Raw Silk Sherwani ",
                description = "Perfect for Groom Ivory Raw Silk Sherwani with Thread, Bead Work events, grand weddings, receptions, engagement  celebrations.",
                imageUrl = "https://shreeman.in/cdn/shop/files/1J8A4220.jpg?v=1728558147&width=1400",
                imageList = listOf(
                    "https://shreeman.in/cdn/shop/files/1J8A4220.jpg?v=1728558147&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A4239.jpg?v=1728558147&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A4242.jpg?v=1728558147&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A4249.jpg?v=1728558147&width=1400"

                ),
                price = 8000,

                )

            28 -> LahangaDetails(
                id = 28,
                name = "Ivory Raw Silk Sherwani with Thread and Bead Cutdana Work",
                description = " Groom events, grand weddings, receptions, engagement ceremonies, luxury parties, and other important celebrations.",
                imageUrl = "https://shreeman.in/cdn/shop/files/1J8A4560.jpg?v=1733317904&width=1400",
                imageList = listOf(
                    "https://shreeman.in/cdn/shop/files/1J8A4560.jpg?v=1733317904&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A4556_24dfd671-8abb-4695-8d81-7c634bb70f1e.jpg?v=1733317904&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A4569.jpg?v=1733317904&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A4574.jpg?v=1733317904&width=1400"

                ),
                price = 10000,

                )

            29 -> LahangaDetails(
                id = 29,
                name = "Ivory Silk Indo Western with Jungle-Themed Thread Work",
                description = "The lightweight construction allows comfortable movement while maintaining a beautiful traditional look.",
                imageUrl = "https://shreeman.in/cdn/shop/files/1J8A4456.jpg?v=1728561297&width=1400",
                imageList = listOf(
                    "https://shreeman.in/cdn/shop/files/1J8A4456.jpg?v=1728561297&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A4445.jpg?v=1728561297&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A4461.jpg?v=1728561297&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A4484.jpg?v=1728561297&width=1400"
                ),
                price = 7000,

                )

            30 -> LahangaDetails(
                id = 30,
                name = "Golden Silk Tissue Sherwani with Resham Work",
                description = "A man's wedding day calls for a wardrobe that speaks of heritage and modern charisma. This shimmering Sherwani for Men serves as a beacon of style.",
                imageUrl = "https://shreeman.in/cdn/shop/files/1J8A3260.jpg?v=1769776211&width=1400",
                imageList = listOf(
                    "https://shreeman.in/cdn/shop/files/1J8A3260.jpg?v=1769776211&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A3263.jpg?v=1769776211&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A3273.jpg?v=1769776211&width=1400",
                    "https://shreeman.in/cdn/shop/files/1J8A3276.jpg?v=1769776211&width=1400"
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