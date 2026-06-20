package com.anaya.fashion.model.roomdb


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.anaya.fashion.model.lahanga.LahangaDetails
import com.anaya.fashion.model.lahanga.WishlistEntity


@Database(
    entities = [WishlistEntity::class, LahangaDetails::class],
    version = 3
)
@TypeConverters(Converters::class)
abstract class CartDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}