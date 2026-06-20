package com.anaya.fashion.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.anaya.fashion.R
import com.anaya.fashion.databinding.DashboardActivityBinding
import com.anaya.fashion.view.fragments.CartListFragment
import com.anaya.fashion.view.fragments.HomeFragment
import com.anaya.fashion.view.fragments.ProfileFragment
import com.anaya.fashion.view.fragments.WishListFragment


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

                R.id.profileMenu -> {
                    replaceFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    /**
     * Select a menu tab programmatically. This will trigger the
     * BottomNavigationView listener and replace the fragment accordingly.
     */
    fun selectTab(menuItemId: Int) {
        mBinding.bottomNavigation.selectedItemId = menuItemId
    }
}