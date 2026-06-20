package com.anaya.fashion.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

object UserProfileManager {

    lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences("UserProfileManager", MODE_PRIVATE)
    }

    var userName: String?
        get() = preferences.getString("UserName", null)
        set(value) = preferences.edit().putString("UserName", value).apply()

    var userMobileNo: String?
        get() = preferences.getString("MobileNo", null)
        set(value) = preferences.edit().putString("MobileNo", value).apply()

    var userEmail: String?
        get() = preferences.getString("UserEmail", null)
        set(value) = preferences.edit().putString("UserEmail", value).apply()

    var userAddress: String?
        get() = preferences.getString("UserAddress", null)
        set(value) = preferences.edit().putString("UserAddress", value).apply()
}