package com.anaya.fashion.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anaya.fashion.databinding.FragmentProfileBinding
import com.anaya.fashion.utils.UserProfileManager
import com.google.android.material.snackbar.Snackbar

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
    }

    private fun initializeViews() {
        // Edit Profile click listener
        mBinding.editProfileItem.setOnClickListener {
            showSnackbar("Edit Profile clicked")
        }

        // Payment Method click listener
        mBinding.paymentMethodItem.setOnClickListener {
            showSnackbar("Payment Method clicked")
        }

        // Old Password click listener
        mBinding.oldPasswordItem.setOnClickListener {
            showSnackbar("Old Password clicked")
        }

        // New Password click listener
        mBinding.newPasswordItem.setOnClickListener {
            showSnackbar("New Password clicked")
        }

        // Edit Address click listener
        mBinding.editAddressItem.setOnClickListener {
            showSnackbar("Edit Address clicked")
        }

        // Update button click listener
        mBinding.updateButton.setOnClickListener {
            showSnackbar("Profile updated successfully!")

            UserProfileManager.userName = "Manish Rathore" // nameEt.text
            UserProfileManager.userEmail = "manish12345@gmail.com"
            UserProfileManager.userMobileNo = "9876543210"
            UserProfileManager.userAddress = "Palwal, Haryana, India - 121105"
        }
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(mBinding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

