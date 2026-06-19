package com.anaya.fasion.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anaya.fashion.databinding.OffersActivityBinding

class OffersActivity : AppCompatActivity() {

    private lateinit var binding: OffersActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = OffersActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}