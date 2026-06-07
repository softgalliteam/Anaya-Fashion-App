package com.learning.exp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.learning.exp.R
import com.learning.exp.databinding.DashboardActivityBinding
import com.learning.exp.view.fragments.CartListFragment
import com.learning.exp.view.fragments.HomeFragment
import com.learning.exp.view.fragments.WishListFragment

class DashboardActivity : AppCompatActivity() {
    companion object {
        const val TAG = "DashboardActivity"
    }

    private lateinit var mBinding: DashboardActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DashboardActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        // Default fragment
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        mBinding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.homeMenu -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.wishMenu -> {
                    replaceFragment(WishListFragment())
                    true
                }

                R.id.cartMenu -> {
                    replaceFragment(CartListFragment())
                    true
                }
//
//                R.id.profileMenu -> {
//                    replaceFragment(ProfileFragment())
//                    true
//                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}