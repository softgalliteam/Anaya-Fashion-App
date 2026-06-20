package com.anaya.fashion.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anaya.fashion.utils.SessionManager


class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (SessionManager.checkLogin()) {
            startActivity(
                Intent(
                    this,
                    DashboardActivity::class.java
                )
            )
        } else {
            startActivity(
                Intent(
                    this,
                    LoginActivity::class.java
                )
            )
        }
        finish()
    }
}