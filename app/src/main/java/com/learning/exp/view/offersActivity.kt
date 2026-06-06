package com.learning.exp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.exp.databinding.OffersActivityBinding

class OffersActivity : AppCompatActivity() {

    private lateinit var binding: OffersActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = OffersActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.homeBtn.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        binding.bottomNav.cartBtn.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        binding.bottomNav.offerBtn.setOnClickListener {
            startActivity(Intent(this, OffersActivity::class.java))
        }
    }
}