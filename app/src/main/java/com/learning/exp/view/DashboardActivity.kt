package com.learning.exp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.exp.databinding.DashboardActivityBinding

class DashboardActivity : AppCompatActivity() {
    companion object {
        const val TAG = "DashboardActivity"
    }


    private lateinit var mBinding: DashboardActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mBinding = DashboardActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.lehengaFL.setOnClickListener {
            startActivity(Intent(this, LahangaListActivity::class.java))
        }

        mBinding.sherwaniFl.setOnClickListener {
        //    startActivity(Intent(this, LahangaListActivity::class.java))
        }

        mBinding.bottomNav.homeBtn.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        mBinding.bottomNav.cartBtn.setOnClickListener {

            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)

        }

        mBinding.bottomNav.cartBtn.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }



    }
}