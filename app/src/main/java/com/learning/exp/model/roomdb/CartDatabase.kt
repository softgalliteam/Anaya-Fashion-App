package com.learning.exp.model.roomdb


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.model.dataclasses.lahanga.WishlistEntity


@Database(
    entities = [WishlistEntity::class, LahangaDetails::class], version = 1
)
@TypeConverters(Converters::class)
abstract class CartDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}