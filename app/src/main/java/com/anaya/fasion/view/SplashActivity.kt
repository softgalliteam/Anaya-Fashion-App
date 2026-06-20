package com.anaya.fasion.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anaya.fasion.utils.SessionManager


class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val session = SessionManager(this)

        if(session.checkLogin()){
            startActivity(
                Intent(
                    this,
                    DashboardActivity::class.java
                )
            )
        }else{
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