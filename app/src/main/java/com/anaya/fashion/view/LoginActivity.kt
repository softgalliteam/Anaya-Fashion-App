package com.anaya.fashion.view

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anaya.fashion.databinding.LoginActivityBinding
import com.anaya.fashion.utils.SessionManager
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {

    companion object {
        const val TAG = "LoginActivity"
    }

    private lateinit var auth: FirebaseAuth
    private lateinit var mBinding: LoginActivityBinding

    private var storedVerificationId: String? = null
    private var resendToken: PhoneAuthProvider.ForceResendingToken? = null
    private var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        auth = FirebaseAuth.getInstance()

        mBinding.sendOtpBtn.setOnClickListener {

            val phoneNumber = mBinding.phoneNumberEt.text.toString().trim()

            if (phoneNumber.length != 10) {
                Toast.makeText(
                    this,
                    "Enter valid 10 digit mobile number",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            sendOtp("+91$phoneNumber")
            mBinding.phoneNumberEt.clearFocus()
        }

        mBinding.verifyOtpBtn.setOnClickListener {

            val otp = mBinding.verifyOtpEt.text.toString().trim()

            if (otp.length != 6) {
                Toast.makeText(
                    this,
                    "Enter valid OTP",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            verifyOtp(otp)
        }

        mBinding.resendOtpBtn.setOnClickListener {

            val phoneNumber = mBinding.phoneNumberEt.text.toString().trim()

            if (phoneNumber.length == 10) {
                sendOtp("+91$phoneNumber")
            }
        }
    }

    private val callbacks = object :
        PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(
            credential: PhoneAuthCredential
        ) {
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(
            e: FirebaseException
        ) {
            Log.e(TAG, "Verification Failed: ${e.message}")

            Toast.makeText(
                this@LoginActivity,
                "Verification Failed: ${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            super.onCodeSent(verificationId, token)

            storedVerificationId = verificationId
            resendToken = token

            mBinding.verifyOtpTil.visibility = View.VISIBLE
            mBinding.verifyOtpBtn.visibility = View.VISIBLE

            startOtpTimer()

            Toast.makeText(
                this@LoginActivity,
                "OTP Sent Successfully",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun sendOtp(phoneNumber: String) {

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyOtp(otpCode: String) {

        if (storedVerificationId == null) {
            Toast.makeText(
                this,
                "Session expired. Resend OTP.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val credential =
            PhoneAuthProvider.getCredential(
                storedVerificationId!!,
                otpCode
            )

        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(
        credential: PhoneAuthCredential
    ) {

        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {

                    SessionManager.saveLogin()

                    Toast.makeText(
                        this,
                        "Login Successful!",
                        Toast.LENGTH_SHORT
                    ).show()

                    startActivity(
                        Intent(
                            this,
                            DashboardActivity::class.java
                        )
                    )

                    finish()

                } else {

                    Toast.makeText(
                        this,
                        "Invalid OTP Code",
                        Toast.LENGTH_SHORT
                    ).show()

                    Log.e(
                        TAG,
                        "OTP Verification Failed: ${task.exception?.message}"
                    )
                }
            }
    }

    private fun startOtpTimer() {

        mBinding.timerTv.visibility = View.VISIBLE
        mBinding.resendOtpBtn.visibility = View.GONE

        countDownTimer?.cancel()

        countDownTimer = object : CountDownTimer(
            60000,
            1000
        ) {

            override fun onTick(
                millisUntilFinished: Long
            ) {
                val seconds = millisUntilFinished / 1000

                mBinding.timerTv.text = "Resend OTP in ${seconds} sec"
            }

            override fun onFinish() {

                mBinding.timerTv.visibility =
                    View.GONE

                mBinding.resendOtpBtn.visibility =
                    View.VISIBLE
            }
        }

        countDownTimer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer?.cancel()
    }
}