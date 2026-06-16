package com.learning.exp.model.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.learning.exp.model.dataclasses.lahanga.LahangaDetails

@Dao
interface CartDao {

    @Query("SELECT * FROM lahanga_cart")
    suspend fun getCartList(): List<LahangaDetails>

    @Insert(onConflict = REPLACE)
    suspend fun addToCart(cartItem: LahangaDetails)

    @Delete
    suspend fun deleteFromCart(cartItem: LahangaDetails)

    //Wish list related operations
    @Query("SELECT * FROM lahanga_cart")
    suspend fun getWishList(): List<LahangaDetails>

    @Insert(onConflict = REPLACE)
    suspend fun addToWish(cartItem: LahangaDetails)

    @Delete
    suspend fun deleteFromWish(cartItem: LahangaDetails)


}