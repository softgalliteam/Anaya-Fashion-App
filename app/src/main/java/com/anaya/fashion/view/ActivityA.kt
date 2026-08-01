package com.anaya.fashion.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.anaya.fashion.databinding.ActivityABinding
import com.anaya.fashion.databinding.LoginActivityBinding

class ActivityA: AppCompatActivity() {
    private lateinit var binding: ActivityABinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.activityNameTv.text = "Activity A"
        binding.goToNextScreenBtn.text = "Go To Activity B"
        Log.d("LAUNCH_MODES", "A")

        binding.goToNextScreenBtn.setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
    }
}