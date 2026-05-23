package com.learning.exp.view

import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.learning.exp.R
import com.learning.exp.databinding.LahangaDetailsActivityBinding
import com.learning.exp.viewmodel.ApiCallViewModel
import com.learning.exp.viewmodel.DetailsApiCallState
import com.squareup.picasso.Picasso

class LahangaDetailsActivity : AppCompatActivity() {
    companion object {
        const val TAG = "LahangaDetailsActivity"
    }

    val apiCallViewModel: ApiCallViewModel by viewModels() // 1st Way to initialize view model

    private lateinit var mBinding: LahangaDetailsActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = LahangaDetailsActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        apiCallViewModel.getLahangaDetails(intent.getIntExtra("id", 0))

        apiCallViewModel.detailScreenState.observe(this) { state ->
            when (state) {
                is DetailsApiCallState.Loading -> {
                    // Show loading indicator
                    mBinding.loaderLl.visibility = VISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    mBinding.detailsLl.visibility = INVISIBLE
                }

                is DetailsApiCallState.Success -> {

                    mBinding.detailsLl.visibility = VISIBLE
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    // Update UI with the list of computers
                    val lahangaDetails = state.articles

                    Log.d(TAG, "Received computer list: $lahangaDetails")
                    Snackbar.make(mBinding.root, "Success", Snackbar.LENGTH_LONG).show()

                    mBinding.titleTv.text = lahangaDetails.name
                    mBinding.descriptionTv.text = lahangaDetails.description
                    val imageView = mBinding.imageIv
                    Picasso.get()
                        .load(lahangaDetails.imageUrl)
                        .placeholder(R.drawable.loading_spinner)
                        .error(R.drawable.transparent_logo)
                        .into(imageView)

                }

                is DetailsApiCallState.Error -> {
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.detailsLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    mBinding.errorTv.text = state.message
                }

                else -> {
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.detailsLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    mBinding.errorTv.text = "Something went wrong"
                }
            }
        }
    }
}