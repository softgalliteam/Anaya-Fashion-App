package com.anaya.fasion.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.anaya.fashion.databinding.ItemCartBinding
import com.anaya.fashion.view.BaseActivity
import com.anaya.fasion.model.CartRepository
import com.anaya.fasion.model.lahanga.LahangaDetails
import com.anaya.fasion.view.adapter.CartRecyclerViewAdapter

class CartActivity : BaseActivity(){

    private lateinit var binding: ItemCartBinding
    private lateinit var adapter: CartRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ItemCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar("Cart")

        val cartList = ArrayList(CartRepository.getCartItems())

        binding.cartRecycler.layoutManager = LinearLayoutManager(this)

        adapter = CartRecyclerViewAdapter(
            cartList,
            onItemClick = { id ->
                startActivity(
                    Intent(this, LahangaDetailsActivity::class.java)
                        .putExtra("id", id)
                )
            },
            onDeleteClickListener = { item ->
                CartRepository.removeFromCart(item)

                val updatedList = ArrayList(CartRepository.getCartItems())
                adapter.updateData(updatedList)
                calculateTotal(updatedList)
            }
        )

        binding.cartRecycler.adapter = adapter

        calculateTotal(cartList)

        binding.checkoutBtn.setOnClickListener {
            binding.cartCard.visibility = View.GONE
        }
    }

    private fun calculateTotal(list: List<LahangaDetails>) {
        var total = 0
        for (item in list) {
            total += item.price
        }
        binding.totalPrice.text = "₹ $total"
    }
}