package com.learning.exp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.exp.model.CartRepository

import com.learning.exp.databinding.ItemCartBinding
import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem
import com.learning.exp.view.adapter.LahangaRecyclerViewAdapter

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ItemCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ItemCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkoutBtn.setOnClickListener {
            binding.cartCard.visibility = View.GONE
        }



        binding.bottomNav.cartBtn.setOnClickListener {

            val intent = Intent(
                this@CartActivity,
                CartActivity::class.java
            )

            startActivity(intent)
        }

            binding.bottomNav.homeBtn.setOnClickListener {
                startActivity(Intent(this, DashboardActivity::class.java))
            }


        val cartList = CartRepository.getCartItems()

        binding.cartRecycler.layoutManager =
            LinearLayoutManager(this)
                val adapter = LahangaRecyclerViewAdapter(
                arrayListOf()
            ){id ->
                    startActivity(
                        Intent(this, LahangaDetailsActivity ::class.java)
                            .putExtra("id",id)
                    )
                }
        binding.cartRecycler.adapter = adapter
        calculateTotal(cartList)
    }

    private fun calculateTotal(list: List<LahangaDetails>) {

        var total = 0

        for (item in list) {
            total += item.price
        }

        binding.totalPrice.text = "₹$total"

    }
}