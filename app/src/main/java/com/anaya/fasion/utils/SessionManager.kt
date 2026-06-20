package com.anaya.fasion.utils

import android.content.Context

class SessionManager(context: Context) {
    private val preferences = context.getSharedPreferences(
        "UserSession",
        Context.MODE_PRIVATE
    )
    fun saveLogin(){
        preferences.edit()
            .putBoolean("isLoggedIn", true)
            .apply()
    }
    fun checkLogin(): Boolean{
        return preferences.getBoolean(
            "isLoggedIn",
            false
        )
    }

    fun logout(){
        preferences.edit()
            .clear()
            .apply()
    }
}