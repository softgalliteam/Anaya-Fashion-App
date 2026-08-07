package com.anaya.fashion.view.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission
import androidx.fragment.app.Fragment
import com.anaya.fashion.databinding.FragmentProfileBinding
import com.anaya.fashion.utils.SessionManager
import com.anaya.fashion.utils.UserProfileManager
import com.anaya.fashion.view.LoginActivity
import com.google.android.material.snackbar.Snackbar
import java.io.File
import java.io.FileOutputStream
import androidx.core.content.edit

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val mBinding get() = _binding!!

    private val pickImage =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri ->
            if (uri != null) {
                mBinding.profileImageView.setImageURI(uri)
                saveProfileImage(uri)
            }
        }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private val requestLocationPermission =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            if (granted) {
                fetchLocation()
            } else {
                showSnackbar("Location permission is required to fetch address")
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(
            inflater,
            container,
            false
        )

        return mBinding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
    }

    private fun initializeViews() {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        mBinding.nameET.setText(
            UserProfileManager.userName ?: ""
        )

        mBinding.mobileET.setText(
            UserProfileManager.userMobileNo ?: ""
        )

        mBinding.emailET.setText(
            UserProfileManager.userEmail ?: ""
        )

        mBinding.addressET.setText(
            UserProfileManager.userAddress ?: ""
        )

        mBinding.userNameTv.text =
            UserProfileManager.userName ?: ""

        mBinding.userEmailTv.text =
            UserProfileManager.userEmail ?: ""

        mBinding.profileImageView.setOnClickListener {
            pickImage.launch("image/*")
        }

        mBinding.fetchLocationIv.setOnClickListener {
            // Check permission
            val permissionCheck = ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            )

            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                fetchLocation()
            } else {
                // Request permission
                requestLocationPermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }

        loadProfileImage()

        mBinding.updateButton.setOnClickListener {

            UserProfileManager.userName =
                mBinding.nameET.text.toString()

            UserProfileManager.userMobileNo =
                mBinding.mobileET.text.toString()

            UserProfileManager.userEmail =
                mBinding.emailET.text.toString()

            UserProfileManager.userAddress =
                mBinding.addressET.text.toString()

            mBinding.userNameTv.text =
                UserProfileManager.userName

            mBinding.userEmailTv.text =
                UserProfileManager.userEmail

            showSnackbar("Profile updated successfully!")
        }

        mBinding.tvLogout.setOnClickListener {

            SessionManager.logout(requireContext())

            val intent = Intent(
                requireContext(),
                LoginActivity::class.java
            )

            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }
    }

    //Profile Image
    private fun saveProfileImage(uri: Uri) {
        try {
            val inputStream = requireContext().contentResolver.openInputStream(uri)
            val file = File(requireContext().filesDir, "profile_image.jpg")
            val outputStream = FileOutputStream(file)
            inputStream?.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }

            val pref = requireContext()
                .getSharedPreferences(
                    "PROFILE_IMAGE",
                    Context.MODE_PRIVATE
                )

            pref.edit {
                putString(
                    "IMAGE",
                    file.absolutePath
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun loadProfileImage() {

        val pref = requireContext()
            .getSharedPreferences(
                "PROFILE_IMAGE",
                Context.MODE_PRIVATE
            )

        val imagePath = pref.getString(
            "IMAGE",
            null
        )

        if (imagePath != null) {
            val file = File(imagePath)
            if (file.exists()) {
                mBinding.profileImageView.setImageURI(
                    Uri.fromFile(file)
                )
            }
        }
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    private fun fetchLocation() {
        try {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location != null) {
                        val geocoder = Geocoder(requireContext(), Locale.getDefault())
                        val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                        if (!addresses.isNullOrEmpty()) {
                            val addressLine = addresses[0].getAddressLine(0)
                            mBinding.addressET.setText(addressLine)
                        } else {
                            showSnackbar("Unable to get address from location")
                        }
                    } else {
                        showSnackbar("Unable to fetch current location")
                    }
                }
                .addOnFailureListener { ex ->
                    ex.printStackTrace()
                    showSnackbar("Failed to get location: ${ex.message}")
                }
        } catch (e: Exception) {
            e.printStackTrace()
            showSnackbar("Error fetching location")
        }
    }

    private fun showSnackbar(message: String) {

        Snackbar.make(
            mBinding.root,
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}