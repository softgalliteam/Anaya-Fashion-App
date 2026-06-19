package com.anaya.fasion.model.roomdb

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    private var CART_INSTANCE: CartDatabase? = null
    fun getCartDbInstance(context: Context): CartDatabase {
        if (CART_INSTANCE == null) {
            synchronized(CartDatabase::class) {
                CART_INSTANCE = buildCartRoomDB(context)
            }
        }
        return CART_INSTANCE!!
    }

    private fun buildCartRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            CartDatabase::class.java,
            "anaya_cart_db"
        )
            .fallbackToDestructiveMigration()
            .build()


    private var WISH_INSTANCE: CartDatabase? = null
    fun getWishListDbInstance(context: Context): CartDatabase {
        if (WISH_INSTANCE == null) {
            synchronized(CartDatabase::class) {
                WISH_INSTANCE = buildWishListRoomDB(context)
            }
        }
        return WISH_INSTANCE!!
    }

    private fun buildWishListRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            CartDatabase::class.java,
            "anaya_wish_list_db"
        ).build()
}