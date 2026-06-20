package com.anaya.fashion.view.fragments

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
import com.anaya.fashion.databinding.FragmentWishListBinding
import com.anaya.fashion.model.lahanga.LahangaDetails
import com.anaya.fashion.view.BuyActivity
import com.anaya.fashion.view.LahangaDetailsActivity
import com.anaya.fashion.view.LahangaListActivity
import com.anaya.fashion.view.adapter.WishRecyclerViewAdapter
import com.anaya.fashion.viewmodel.CartAndWishListViewModel
import com.anaya.fashion.viewmodel.Status
import com.google.android.material.snackbar.Snackbar

class WishListFragment : Fragment() {

    val apiCallViewModel: CartAndWishListViewModel by viewModels()

    private var _binding: FragmentWishListBinding? = null
    private val mBinding get() = _binding!!
    private var wishList: List<LahangaDetails> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishListBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiCallViewModel.getWishList()


        mBinding.buyNowBtn.setOnClickListener {
            var productIds = ""
            wishList.forEach {
                productIds += "${it.id}," // "1,2,3,"
            }
            startActivity(
                Intent(requireActivity(), BuyActivity::class.java)
                    .putExtra(
                        "id",
                        productIds
                    )
            )
        }

        mBinding.wishListRV.layoutManager = LinearLayoutManager(requireActivity())
        // Set in recycler view adapter
        val adapter = WishRecyclerViewAdapter(
            arrayListOf(),
            {
                startActivity(
                    Intent(
                        requireActivity(),
                        LahangaDetailsActivity::class.java
                    ).putExtra("id", it)
                )
            }, { item ->
                apiCallViewModel.deleteFromWish(item)
            }
        )
        // Setting the Adapter with the recyclerview
        mBinding.wishListRV.adapter = adapter

        apiCallViewModel.wishState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is Status.Loading -> {
                    // Show loading indicator
                    mBinding.loaderLl.visibility = VISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    mBinding.buyNowBtn.visibility = INVISIBLE
                    Snackbar.make(mBinding.root, "Loading...", Snackbar.LENGTH_LONG).show()
                }

                is Status.WishSuccess -> {

                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    mBinding.buyNowBtn.visibility = VISIBLE
                    // Update UI with the list of computers
                    wishList = state.wishList

                    Log.d(LahangaListActivity.Companion.TAG, "Received cart list: $wishList")
                    Snackbar.make(mBinding.root, "Success", Snackbar.LENGTH_LONG).show()

                    // For example, you can set the articles to a RecyclerView adapter here
                    adapter.updateData(wishList)
                }

                is Status.Error -> {
                    // Show error message
                    val errorMessage = state.message
                    mBinding.errorTv.text = errorMessage
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.buyNowBtn.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    // For example, you can show a Toast or a Snackbar with the error message
                    Snackbar.make(mBinding.root, errorMessage, Snackbar.LENGTH_LONG).show()
                }

                else -> {
                    // Show error message
                    val errorMessage = "Something went wrong"
                    mBinding.errorTv.text = errorMessage
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.buyNowBtn.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    // For example, you can show a Toast or a Snackbar with the error message
                    Snackbar.make(mBinding.root, errorMessage, Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}