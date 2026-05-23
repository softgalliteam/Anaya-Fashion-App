package com.learning.exp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.exp.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {
    companion object {
        const val TAG = "LoginActivity"
    }


    private lateinit var mBinding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.loginBtn.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }
}