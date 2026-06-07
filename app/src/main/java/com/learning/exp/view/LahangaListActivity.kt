package com.learning.exp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.learning.exp.databinding.LahangaListActivityBinding
import com.learning.exp.model.ApiCalRepository
import com.learning.exp.model.roomdb.DatabaseBuilder
import com.learning.exp.model.roomdb.DatabaseHelper
import com.learning.exp.model.roomdb.DatabaseHelperImpl
import com.learning.exp.view.adapter.LahangaRecyclerViewAdapter
import com.learning.exp.viewmodel.ApiCallState
import com.learning.exp.viewmodel.ApiCallViewModel

class LahangaListActivity : AppCompatActivity() {
    companion object {
        const val TAG = "ApiCallActivity"
    }

    val cartDb by lazy { DatabaseBuilder.getCartDbInstance(this) }
    val dbHelper: DatabaseHelper by lazy { DatabaseHelperImpl(cartDb) }
    val repository by lazy { ApiCalRepository(dbHelper) }

    val apiCallViewModel: ApiCallViewModel by viewModels {
        ApiCallViewModel.ApiCallViewModelFactory(repository)
    }

    private lateinit var mBinding: LahangaListActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = LahangaListActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        Log.d(TAG, "onCreate: Fetching computer list")
        apiCallViewModel.getLahangaList()
        val computerRV = mBinding.computerRV
        computerRV.layoutManager = GridLayoutManager(this, 2)
        // Set in recycler view adapter
        val adapter = LahangaRecyclerViewAdapter(arrayListOf(), {
            startActivity(Intent(this, LahangaDetailsActivity::class.java).putExtra("id", it))
        })
        // Setting the Adapter with the recyclerview
        computerRV.adapter = adapter

        apiCallViewModel.screenState.observe(this) { state ->
            when (state) {
                is ApiCallState.Loading -> {
                    // Show loading indicator
                    mBinding.loaderLl.visibility = VISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    Snackbar.make(mBinding.root, "Loading...", Snackbar.LENGTH_LONG).show()
                }

                is ApiCallState.Success -> {

                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    // Update UI with the list of computers
                    val computerList = state.articles

                    Log.d(TAG, "Received computer list: $computerList")
                    Snackbar.make(mBinding.root, "Success", Snackbar.LENGTH_LONG).show()

                    // For example, you can set the articles to a RecyclerView adapter here
                    adapter.updateData(computerList)
                }

                is ApiCallState.Error -> {
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