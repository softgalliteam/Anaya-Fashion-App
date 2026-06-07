package com.learning.exp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.learning.exp.R
import com.learning.exp.model.ApiCalRepository
import com.learning.exp.model.roomdb.DatabaseBuilder
import com.learning.exp.model.roomdb.DatabaseHelper
import com.learning.exp.model.roomdb.DatabaseHelperImpl
import com.learning.exp.viewmodel.ApiCallViewModel
import kotlin.getValue

class CartListFragment : Fragment() {

    val cartDb by lazy { DatabaseBuilder.getCartDbInstance(requireActivity()) }
    val dbHelper: DatabaseHelper by lazy { DatabaseHelperImpl(cartDb) }
    val repository by lazy { ApiCalRepository(dbHelper) }

    val apiCallViewModel: ApiCallViewModel by viewModels {
        ApiCallViewModel.ApiCallViewModelFactory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_cart_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiCallViewModel.getCartList()
    }
}