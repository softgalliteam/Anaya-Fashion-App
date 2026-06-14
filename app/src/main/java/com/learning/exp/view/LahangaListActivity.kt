package com.learning.exp.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
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
        const val TAG = "LahangaListActivity"
    }

    private lateinit var mBinding: LahangaListActivityBinding
    private val apiCallViewModel: ApiCallViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = LahangaListActivityBinding.inflate(layoutInflater)

        setContentView(mBinding.root)


        val searchView = mBinding.searchView

        searchView.isIconified = false

        searchView.queryHint = "Search here..."

        val searchText = searchView.findViewById<EditText>(
            androidx.appcompat.R.id.search_src_text
        )

        searchText.setHintTextColor(Color.GRAY)

        searchText.setTextColor(Color.BLACK)

        searchText.textSize = 15f


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


        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    adapter.filterList(newText ?: "")

                    return true
                }

            }
        )


        apiCallViewModel.screenState.observe(this) { state ->

            when (state) {

                is ApiCallState.Loading -> {

                    mBinding.loaderLl.visibility = VISIBLE
                    mBinding.errorTv.visibility = INVISIBLE

                }

                is ApiCallState.Success -> {

                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = INVISIBLE

                    adapter.updateData(state.articles)

                }

                is ApiCallState.Error -> {

                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    mBinding.errorTv.text = state.message

                }

                else -> {

                    mBinding.loaderLl.visibility = INVISIBLE
                    mBinding.errorTv.visibility = VISIBLE
                    mBinding.errorTv.text = "Something went wrong"

                }

            }

        }

    }

}