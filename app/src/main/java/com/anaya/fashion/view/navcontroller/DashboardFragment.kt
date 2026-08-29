package com.anaya.fashion.view.navcontroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.anaya.fashion.R
import com.anaya.fashion.databinding.DashboardFragmentBinding

class DashboardFragment : Fragment() {
    private var _binding: DashboardFragmentBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DashboardFragmentBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.goToNextScreenBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
    }
}