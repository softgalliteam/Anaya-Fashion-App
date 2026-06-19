package com.anaya.fasion.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anaya.fashion.databinding.HomeFragmentBinding
import com.anaya.fasion.view.LahangaListActivity

class HomeFragment : Fragment() {
    private var _binding: HomeFragmentBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.lehengaFL.setOnClickListener {
            startActivity(Intent(requireActivity(), LahangaListActivity::class.java))

        }

        mBinding.sherwaniFl.setOnClickListener {
            //    startActivity(Intent(this, LahangaListActivity::class.java))
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}