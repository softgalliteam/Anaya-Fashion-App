package com.learning.exp.view

import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
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

        handleSliderView()

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
                    /* val imageView = mBinding.imageIv
                     Picasso.get()
                         .load(lahangaDetails.imageUrl)
                         .placeholder(R.drawable.loading_spinner)
                         .error(R.drawable.transparent_logo)
                         .into(imageView)*/

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

    private fun handleSliderView() {
        val imageSlider = mBinding.imageSlider
        val imageList = ArrayList<SlideModel>()

        imageList.add(
            SlideModel(
                "https://images.immediate.co.uk/production/volatile/sites/3/2019/04/Avengers-Endgame-Banner-2-de7cf60.jpg?quality=90&resize=620,413",
                "Avengers Endgame"
            )
        )
        imageList.add(
            SlideModel(
                "https://img.cinemablend.com/filter:scale/quill/3/7/0/0/8/e/37008e36e98cd75101cf1347396eac8534871a19.jpg?mw=600",
                "Jumanji"
            )
        )
        imageList.add(
            SlideModel(
                "https://www.adgully.com/img/800/201711/spider-man-homecoming-banner.jpg",
                "Spider Man"
            )
        )
        imageList.add(
            SlideModel(
                "https://live.staticflickr.com/1980/29996141587_7886795726_b.jpg",
                "Venom"
            )
        )

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
    }
}