package com.learning.exp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.learning.exp.databinding.LahangaListActivityBinding
import com.learning.exp.view.adapter.LahangaRecyclerViewAdapter
import com.learning.exp.viewmodel.ApiCallState
import com.learning.exp.viewmodel.ApiCallViewModel

class LahangaListActivity : AppCompatActivity() {

    companion object {
        const val TAG = "LahangaListActivity"
    }

    private lateinit var searchView: SearchView
    private var isLoading = false
    private lateinit var mBinding: LahangaListActivityBinding
    private val apiCallViewModel: ApiCallViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = LahangaListActivityBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        searchView = mBinding.searchView
        handleSearchList()

        // Ensure keyboard is hidden when screen first loads
        // Clear focus from the SearchView first so it won't request keyboard
        searchView.clearFocus()
        hideKeyboard()

        apiCallViewModel.getLahangaList()


        val recyclerView = mBinding.computerRV

        recyclerView.layoutManager = GridLayoutManager(this, 2)


        val adapter = LahangaRecyclerViewAdapter(arrayListOf()) {

            startActivity(
                Intent(
                    this,
                    LahangaDetailsActivity::class.java
                ).putExtra("id", it)
            )

        }


        recyclerView.adapter = adapter


        apiCallViewModel.screenState.observe(this) { state ->
            when (state) {
                is ApiCallState.Loading -> {
                    isLoading = true
                    mBinding.loaderLl.visibility = VISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    recyclerView.visibility = INVISIBLE
                }

                is ApiCallState.Success -> {
                    isLoading = false
                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = INVISIBLE
                    recyclerView.visibility = VISIBLE
                    adapter.updateData(state.articles)
                }

                is ApiCallState.Error -> {
                    isLoading = false
                    mBinding.loaderLl.visibility = INVISIBLE
                    recyclerView.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    mBinding.errorTv.text = state.message
                }

                else -> {
                    isLoading = false
                    mBinding.loaderLl.visibility = INVISIBLE
                    recyclerView.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    mBinding.errorTv.text = "Something went wrong"
                }
            }
        }
    }

    private fun handleSearchList() {
        // Set up the text change and submission listeners
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            // Triggered when the user presses the search/submit button
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            // Triggered in real-time every time a character is typed or deleted
            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrBlank() && newText.length >= 3) {
                    apiCallViewModel.searchLahangaList(newText)
                }
                return true
            }
        })
    }

    // Hide the soft keyboard if it is visible
    private fun hideKeyboard() {
        try {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            var view = currentFocus
            if (view == null) view = View(this)
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        } catch (e: Exception) {
            // ignore
        }
    }

}