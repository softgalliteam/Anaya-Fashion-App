package com.anaya.fashion.model.dataprovider

import android.content.Context

object WishlistManager {

    private const val PREF_NAME = "wishlist_pref"
    private const val KEY_WISHLIST = "wishlist_ids"

    fun addToWishlist(context: Context, id: Int) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val set = prefs.getStringSet(KEY_WISHLIST, mutableSetOf())?.toMutableSet() ?: mutableSetOf()
        set.add(id.toString())
        prefs.edit().putStringSet(KEY_WISHLIST, set).apply()
    }

    fun removeFromWishlist(context: Context, id: Int) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val set = prefs.getStringSet(KEY_WISHLIST, mutableSetOf())?.toMutableSet() ?: mutableSetOf()
        set.remove(id.toString())
        prefs.edit().putStringSet(KEY_WISHLIST, set).apply()
    }

    fun isWishListed(context: Context, id: Int): Boolean {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val set = prefs.getStringSet(KEY_WISHLIST, mutableSetOf()) ?: mutableSetOf()
        return set.contains(id.toString())
    }

    fun getWishlist(context: Context): List<Int> {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getStringSet(KEY_WISHLIST, mutableSetOf())
            ?.map { it.toInt() } ?: emptyList()
    }
}