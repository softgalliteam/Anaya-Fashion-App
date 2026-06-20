package com.anaya.fashion

import android.app.Application
import com.anaya.fashion.utils.SessionManager
import com.anaya.fashion.utils.UserProfileManager

class AnayaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Pass applicationContext to prevent activity memory leaks
        SessionManager.init(this)
        UserProfileManager.init(this)
    }
}