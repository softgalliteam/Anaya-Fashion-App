package com.learning.exp.view.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.learning.exp.databinding.FragmentCartListBinding
import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.view.BuyActivity
import com.learning.exp.view.LahangaDetailsActivity
import com.learning.exp.view.adapter.CartRecyclerViewAdapter
import com.learning.exp.viewmodel.CartAndWishListViewModel
import com.learning.exp.viewmodel.Status

class CartListFragment : Fragment() {

    private val apiCallViewModel: CartAndWishListViewModel by viewModels()

    private var _binding: FragmentCartListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CartRecyclerViewAdapter
    private var cartList: List<LahangaDetails> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupBuyButton()

        apiCallViewModel.getCartList()
        observeCartState()
    }

    private fun setupRecyclerView() {

        binding.computerRV.layoutManager =
            LinearLayoutManager(requireContext())

        adapter = CartRecyclerViewAdapter(

            arrayListOf(),

            onItemClick = { id ->
                startActivity(
                    Intent(requireActivity(), LahangaDetailsActivity::class.java)
                        .putExtra("id", id)
                )
            },

            onDeleteClickListener = { item ->

                // Delete API Call
                apiCallViewModel.deleteFromCart(item)

                // Fresh Cart List Load
                apiCallViewModel.getCartList()

                Snackbar.make(
                    binding.root,
                    "Item removed from cart",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        )

        binding.computerRV.adapter = adapter
    }

    private fun setupBuyButton() {

        binding.buyNowBtn.setOnClickListener {

            val productIds = cartList.joinToString(",") { it.id.toString() }

            startActivity(
                Intent(requireActivity(), BuyActivity::class.java)
                    .putExtra("id", productIds)
            )
        }
    }

    private fun observeCartState() {

        apiCallViewModel.cartState.observe(viewLifecycleOwner) { state ->

            when (state) {

                is Status.Loading -> {

                    binding.loaderLl.visibility = VISIBLE
                    binding.errorTv.visibility = INVISIBLE

                    Snackbar.make(
                        binding.root,
                        "Loading...",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                is Status.Success -> {

                    binding.loaderLl.visibility = INVISIBLE
                    binding.errorTv.visibility = INVISIBLE

                    cartList = state.cartList

                    binding.buyNowBtn.visibility =
                        if (cartList.isEmpty()) INVISIBLE else VISIBLE

                    Log.d("CART", "Cart List: $cartList")

                    adapter.updateData(cartList)
                }

                is Status.Error -> {

                    binding.loaderLl.visibility = INVISIBLE
                    binding.buyNowBtn.visibility = INVISIBLE
                    binding.errorTv.visibility = VISIBLE
                    binding.errorTv.text = state.message

                    Snackbar.make(
                        binding.root,
                        state.message,
                        Snackbar.LENGTH_LONG
                    ).show()
                }

                else -> {

                    binding.loaderLl.visibility = INVISIBLE
                    binding.buyNowBtn.visibility = INVISIBLE
                    binding.errorTv.visibility = VISIBLE
                    binding.errorTv.text = "Something went wrong"
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}