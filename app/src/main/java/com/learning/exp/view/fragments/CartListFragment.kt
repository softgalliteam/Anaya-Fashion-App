package com.learning.exp.view.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.learning.exp.R
import com.learning.exp.databinding.FragmentCartListBinding
import com.learning.exp.databinding.HomeFragmentBinding
import com.learning.exp.model.ApiCalRepository
import com.learning.exp.model.roomdb.DatabaseBuilder
import com.learning.exp.model.roomdb.DatabaseHelper
import com.learning.exp.model.roomdb.DatabaseHelperImpl
import com.learning.exp.view.LahangaDetailsActivity
import com.learning.exp.view.LahangaListActivity.Companion.TAG
import com.learning.exp.view.adapter.CartRecyclerViewAdapter
import com.learning.exp.view.adapter.LahangaRecyclerViewAdapter
import com.learning.exp.viewmodel.ApiCallState
import com.learning.exp.viewmodel.CartAndWishListViewModel
import com.learning.exp.viewmodel.Status
import kotlin.getValue

class CartListFragment : Fragment() {

    val cartDb by lazy { DatabaseBuilder.getCartDbInstance(requireActivity()) }
    val dbHelper: DatabaseHelper by lazy { DatabaseHelperImpl(cartDb) }
    val repository by lazy { ApiCalRepository(dbHelper) }

    val apiCallViewModel: CartAndWishListViewModel by viewModels {
        CartAndWishListViewModel.CartAndWishListViewModelFactory(repository)
    }

    private var _binding: FragmentCartListBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartListBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiCallViewModel.getCartList()

        val computerRV = mBinding.computerRV
        computerRV.layoutManager = LinearLayoutManager(requireActivity())
        // Set in recycler view adapter
        val adapter = CartRecyclerViewAdapter(arrayListOf(), {
            startActivity(
                Intent(
                    requireActivity(),
                    LahangaDetailsActivity::class.java
                ).putExtra("id", it)
            )
        })
        // Setting the Adapter with the recyclerview
        computerRV.adapter = adapter

        apiCallViewModel.cartState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is Status.Loading -> {
                    // Show loading indicator
                    mBinding.loaderLl.visibility = VISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    Snackbar.make(mBinding.root, "Loading...", Snackbar.LENGTH_LONG).show()
                }

                is Status.Success -> {

                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    // Update UI with the list of computers
                    val cartList = state.cartList

                    Log.d(TAG, "Received cart list: $cartList")
                    Snackbar.make(mBinding.root, "Success", Snackbar.LENGTH_LONG).show()

                    // For example, you can set the articles to a RecyclerView adapter here
                    adapter.updateData(cartList)
                }

                is Status.Error -> {
                    // Show error message
                    val errorMessage = state.message
                    mBinding.errorTv.text = errorMessage
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    // For example, you can show a Toast or a Snackbar with the error message
                    Snackbar.make(mBinding.root, errorMessage, Snackbar.LENGTH_LONG).show()
                }

                else -> {
                    // Show error message
                    val errorMessage = "Something went wrong"
                    mBinding.errorTv.text = errorMessage
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    // For example, you can show a Toast or a Snackbar with the error message
                    Snackbar.make(mBinding.root, errorMessage, Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}