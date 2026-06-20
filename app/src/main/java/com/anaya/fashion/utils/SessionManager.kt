package com.anaya.fashion.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

object SessionManager {
    lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences("UserSession", MODE_PRIVATE)
    }

    fun saveLogin() {
        preferences.edit()
            .putBoolean("isLoggedIn", true)
            .apply()
    }

    fun checkLogin(): Boolean {
        return preferences.getBoolean(
            "isLoggedIn",
            false
        )
    }

    fun logout() {
        preferences.edit()
            .clear()
            .apply()
    }
}