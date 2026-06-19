package com.anaya.fasion.model.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anaya.fasion.model.lahanga.WishlistEntity


@Dao
interface WishlistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWishlist(item: WishlistEntity)


    @Query("SELECT * FROM wishlist_table")
    suspend fun getWishlist(): List<WishlistEntity>


    @Query("DELETE FROM wishlist_table WHERE id = :id")
    suspend fun removeWishlist(id: Int)

}