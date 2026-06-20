package com.anaya.fashion.view

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import com.anaya.fashion.databinding.LahangaDetailsActivityBinding
import com.anaya.fashion.model.lahanga.LahangaDetails
import com.anaya.fashion.viewmodel.ApiCallViewModel
import com.anaya.fashion.viewmodel.DetailsApiCallState
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.snackbar.Snackbar

class LahangaDetailsActivity : BaseActivity() {
    companion object {
        const val TAG = "LahangaDetailsActivity"
    }

    val apiCallViewModel: ApiCallViewModel by viewModels()

    private lateinit var mBinding: LahangaDetailsActivityBinding
    private var productId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = LahangaDetailsActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        // Toolbar back arrow activate here
        setupToolbar("Lehenga Details")

        productId = intent.getIntExtra("id", 0)
        apiCallViewModel.getLahangaDetails(productId)

        handleSliderView()

        handleButtonClicks()

        apiCallViewModel.detailScreenState.observe(this) { state ->
            when (state) {
                is DetailsApiCallState.Loading -> {
                    // Show loading indicator
                    mBinding.loaderLl.visibility = VISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    mBinding.detailsLL.visibility = INVISIBLE
                }

                is DetailsApiCallState.SuccessWithMessage -> {
                    Snackbar.make(mBinding.root, state.message, Snackbar.LENGTH_LONG).show()
                }

                is DetailsApiCallState.Success -> {

                    mBinding.detailsLL.visibility = VISIBLE
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    // Update UI with the list of computers
                    val lahangaDetails = state.articles

                    updateUI(lahangaDetails)
                }

                is DetailsApiCallState.Error -> {
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.detailsLL.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    mBinding.errorTv.text = state.message
                }

                else -> {
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.detailsLL.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    mBinding.errorTv.text = "Something went wrong"
                }

            }
        }
    }

    fun updateUI(lahangaDetails: LahangaDetails) {
        mBinding.priceTv.text = lahangaDetails.price.toString()
        mBinding.titleTv.text = lahangaDetails.name
        mBinding.descriptionTv.text = lahangaDetails.description
    }


    private fun handleButtonClicks() {

        mBinding.addCartBtn.setOnClickListener {
            apiCallViewModel.addToCart()
        }


        mBinding.wishListBtn.setOnClickListener {
            apiCallViewModel.addToWish()
        }

        mBinding.buyNowBtn.setOnClickListener {
            startActivity(
                Intent(this@LahangaDetailsActivity, BuyActivity::class.java)
                    .putExtra(
                        "id",
                        "$productId,"
                    )
            )
        }

        mBinding.txtViewMore.setOnClickListener {
            startActivity(
                Intent(
                    this@LahangaDetailsActivity,
                    LahangaListActivity::class.java
                )
            )
        }
    }

//

    private fun handleSliderView() {
        val imageSlider = mBinding.imageSlider
        val imageList = ArrayList<SlideModel>()

        imageList.add(
            SlideModel(
                imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",

                )
        )
        imageList.add(
            SlideModel(
                imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",

                )
        )
        imageList.add(
            SlideModel(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",

                )
        )
        imageList.add(
            SlideModel(
                imageUrl = "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",

                )
        )

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
    }
}