package com.anaya.fashion.view

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import com.anaya.fashion.R
import com.anaya.fashion.databinding.LahangaDetailsActivityBinding
import com.anaya.fashion.model.lahanga.LahangaDetails
import com.anaya.fashion.utils.Utilz
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


    private lateinit var currentProduct: LahangaDetails
    private var isWishListed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = LahangaDetailsActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        // Toolbar back arrow activate here
        setupToolbar("")

        productId = intent.getIntExtra("id", 0)
        apiCallViewModel.getLahangaDetails(productId)

        handleButtonClicks()

        apiCallViewModel.wishListStateState.observe(this) { isWishListed ->
            if (isWishListed) {
                mBinding.wishListBtn.setImageResource(R.drawable.heart_fill_icon)
            } else {
                mBinding.wishListBtn.setImageResource(R.drawable.heart_icon)
            }
        }

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



    private fun handleButtonClicks() {

        mBinding.addCartBtn.setOnClickListener {
            apiCallViewModel.addToCart()
        }

        mBinding.wishListBtn.setOnClickListener {
            apiCallViewModel.handleWishList()
        }

        mBinding.shareBtn.setOnClickListener {
            val imageUrl = currentProduct.imageUrl
            val shareTitle =
                "Check out this product: ${currentProduct.name} at ${currentProduct.price}"
            //share product details name price and image
            /*val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
               shareTitle
            )
            startActivity(Intent.createChooser(shareIntent, "Share via"))*/

            Utilz.shareProductDetails(this, imageUrl, shareTitle)
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

    fun updateUI(lahangaDetails: LahangaDetails) {

        currentProduct = lahangaDetails

        mBinding.priceTv.text = lahangaDetails.price.toString()
        mBinding.titleTv.text = lahangaDetails.name
        mBinding.descriptionTv.text = lahangaDetails.description

        // Set product images dynamically
        val imageList = ArrayList<SlideModel>()

        lahangaDetails.imageList.forEach { imageUrl ->
            imageList.add(
                SlideModel(
                    imageUrl = imageUrl
                )
            )
        }

        mBinding.imageSlider.setImageList(
            imageList,
            ScaleTypes.FIT
        )
    }
}