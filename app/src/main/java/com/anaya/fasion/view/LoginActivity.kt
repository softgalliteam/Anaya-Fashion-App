package com.anaya.fasion.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Visibility
import com.anaya.fashion.databinding.LoginActivityBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.getInstance
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {
    companion object {
        const val TAG = "LoginActivity"
    }

    private lateinit var auth: FirebaseAuth
    private var storedVerificationId: String? = null
    private var resendToken: PhoneAuthProvider.ForceResendingToken? = null

    private lateinit var mBinding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Initialize Firebase Auth
        auth = getInstance()

        mBinding.sendOtpBtn.setOnClickListener {
            val phoneNumber = mBinding.phoneNumberEt.text.toString().trim()
            sendOtp("+91 $phoneNumber")
            // Hide keyboard after sending OTP
             mBinding.phoneNumberEt.clearFocus()
        }

        mBinding.verifyOtpBtn.setOnClickListener {
            val otpToVerify = mBinding.verifyOtpEt.text.toString().trim()
            if (otpToVerify.isNotEmpty() && otpToVerify.length == 6)
                verifyOtp(otpToVerify)
        }
    }


    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        // Triggered if the device is instantly verified (rare but happens)
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            signInWithPhoneAuthCredential(credential)
        }

        // Triggered if there is an error (e.g., invalid phone format)
        override fun onVerificationFailed(e: FirebaseException) {
            Log.d(TAG, "Verification Failed: ${e.message}")
            Toast.makeText(
                this@LoginActivity,
                "Verification Failed: ${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }

        // Triggered when the SMS OTP code is successfully sent to the phone
        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            // Save these tokens to verify the user-entered OTP later
            storedVerificationId = verificationId
            resendToken = token
            Log.d(TAG, "OTP Sent Successfully")
            Toast.makeText(this@LoginActivity, "OTP Sent Successfully", Toast.LENGTH_SHORT).show()
            // TODO: Show your OTP input field here
        }
    }


    fun sendOtp(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout duration
            .setActivity(this)                 // Activity loop for callbacks
            .setCallbacks(callbacks)           // Your callback instance
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    // Step 7A: Create the credential using the received SMS code
    fun verifyOtp(otpCode: String) {
        if (storedVerificationId != null) {
            val credential = PhoneAuthProvider.getCredential(storedVerificationId!!, otpCode)
            signInWithPhoneAuthCredential(credential)
        } else {
            Toast.makeText(this, "Session expired. Resend OTP.", Toast.LENGTH_SHORT).show()
        }
    }

    // Step 7B: Authenticate the user into Firebase
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Login Successful!")
                    // Login Success! Navigate to MainActivity
                    Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, DashboardActivity::class.java))
                    finish()
                } else {
                    // Login Failed
                    Log.d(TAG, "Invalid OTP Code")
                    Toast.makeText(this, "Invalid OTP Code", Toast.LENGTH_SHORT).show()
                }
            }
    }
}