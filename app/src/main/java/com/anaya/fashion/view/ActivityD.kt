package com.anaya.fashion.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.anaya.fashion.databinding.ActivityABinding
import com.anaya.fashion.databinding.LoginActivityBinding

class ActivityD: AppCompatActivity() {
    private lateinit var binding: ActivityABinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.activityNameTv.text = "Activity D"
        binding.goToNextScreenBtn.text = "Go To Activity A"

        Log.d("LAUNCH_MODES", "D")

        binding.goToNextScreenBtn.setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }
    }
}