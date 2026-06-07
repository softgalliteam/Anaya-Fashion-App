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
import com.learning.exp.databinding.LahangaDetailsActivityBinding
import com.learning.exp.model.ApiCalRepository
import com.learning.exp.model.roomdb.DatabaseBuilder
import com.learning.exp.model.roomdb.DatabaseHelper
import com.learning.exp.model.roomdb.DatabaseHelperImpl
import com.learning.exp.viewmodel.ApiCallViewModel
import com.learning.exp.viewmodel.DetailsApiCallState

class LahangaDetailsActivity : AppCompatActivity() {
    companion object {
        const val TAG = "LahangaDetailsActivity"
    }


    val cartDb by lazy { DatabaseBuilder.getCartDbInstance(this) }
    val dbHelper: DatabaseHelper by lazy { DatabaseHelperImpl(cartDb) }
    val repository by lazy { ApiCalRepository(dbHelper) }

    val apiCallViewModel: ApiCallViewModel by viewModels {
        ApiCallViewModel.ApiCallViewModelFactory(repository)
    }

    private lateinit var mBinding: LahangaDetailsActivityBinding
    private var productId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = LahangaDetailsActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
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

                    Log.d(TAG, "Received computer list: $lahangaDetails")
                    Snackbar.make(mBinding.root, "Success", Snackbar.LENGTH_LONG).show()

                    mBinding.titleTv.text = lahangaDetails.name
                    mBinding.descriptionTv.text = lahangaDetails.description

                    mBinding.titleTv.text = lahangaDetails.name
                    mBinding.descriptionTv.text = lahangaDetails.description


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
        mBinding.addToCartBtn.setOnClickListener {
            apiCallViewModel.addToCart()
        }
    }

    private fun handleSliderView() {
        val imageSlider = mBinding.imageSlider
        val imageList = ArrayList<SlideModel>()

        imageList.add(
            SlideModel(
                imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
                "lehanga"
            )
        )
        imageList.add(
            SlideModel(
                imageUrl = "https://www.royalexport.in/product-img/heavy-faux-georgette-lehenga-c-1685429071.jpg",
                "Premium Look"
            )
        )
        imageList.add(
            SlideModel(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpl2oVGj-WU14UHxKPxkM2KAj3g6cB55uO3Q&s",
                "Embroidered Lehanga"
            )
        )
        imageList.add(
            SlideModel(
                imageUrl = "https://www.papadontpreach.com/cdn/shop/files/Website-resized-kinjal-1.jpg?v=1750320811&width=823",
                "Pink Premium Lehanga"
            )
        )

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
    }
}