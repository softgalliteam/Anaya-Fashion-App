package com.anaya.fashion.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.anaya.fashion.databinding.BuyActivityBinding
import com.anaya.fashion.model.dataprovider.LahangaDataProvider
import com.anaya.fashion.view.adapter.BuyRecyclerViewAdapter

class BuyActivity : BaseActivity() {

    private lateinit var mBinding: BuyActivityBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = BuyActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupToolbar("Buy Now")

        // Get Intent Data
        val productId = intent.getStringExtra("id") ?: "0"
        val cartList = LahangaDataProvider.getCartList(productId)
        val computerRV = mBinding.buyNowListRv
        computerRV.layoutManager = LinearLayoutManager(this)
        // Set in recycler view adapter
        val adapter = BuyRecyclerViewAdapter(cartList, {
            startActivity(
                Intent(
                    this,
                    LahangaDetailsActivity::class.java
                ).putExtra("id", it)
            )
        })
        // Setting the Adapter with the recyclerview
        computerRV.adapter = adapter


        var totalPrice = 0
        cartList.forEach {
            totalPrice += it.price
        }

        mBinding.totalPriceTv.text = "Total Price: ₹ $totalPrice"
    }
}