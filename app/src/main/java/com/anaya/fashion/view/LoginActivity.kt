package com.anaya.fashion.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anaya.fashion.databinding.LoginActivityBinding
import com.anaya.fashion.utils.SessionManager
import eightbitlab.com.blurview.RenderEffectBlur
import eightbitlab.com.blurview.RenderScriptBlur
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "LoginActivity"
    }

    private lateinit var binding: LoginActivityBinding
    private lateinit var auth: FirebaseAuth

    private var storedVerificationId: String? = null
    private var resendToken: PhoneAuthProvider.ForceResendingToken? = null
    private var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        // Auto Login
        if (SessionManager.isLoggedIn()) {
            startActivity(
                Intent(
                    this,
                    DashboardActivity::class.java
                )
            )
            finish()
            return
        }


        setupBlurView()
        setupClickListeners()
    }

    private fun setupBlurView() {
        val blurView = binding.blurView
        val radius = 20f

        blurView.setupWith(binding.root, RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setOverlayColor(0x22FFFFFF)
    }



    private fun setupClickListeners() {

        binding.sendOtpBtn.setOnClickListener {

            val phoneNumber =
                binding.phoneNumberEt.text.toString().trim()

            when {
                phoneNumber.isEmpty() -> {
                    binding.phoneNumberEt.error =
                        "Enter mobile number"
                }

                phoneNumber.length != 10 -> {
                    binding.phoneNumberEt.error =
                        "Enter valid 10 digit number"
                }

                else -> {
                    binding.sendOtpBtn.isEnabled = false
                    sendOtp("+91$phoneNumber")
                }
            }
        }

        binding.verifyOtpBtn.setOnClickListener {

            val otp =
                binding.verifyOtpEt.text.toString().trim()

            when {
                otp.isEmpty() -> {
                    binding.verifyOtpEt.error =
                        "Enter OTP"
                }

                otp.length != 6 -> {
                    binding.verifyOtpEt.error =
                        "Enter valid OTP"
                }

                else -> {
                    verifyOtp(otp)
                }
            }
        }

        binding.resendOtpBtn.setOnClickListener {

            val phoneNumber =
                binding.phoneNumberEt.text.toString().trim()

            if (phoneNumber.length == 10) {
                sendOtp("+91$phoneNumber")
            } else {
                Toast.makeText(
                    this,
                    "Enter valid mobile number",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private val callbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(
                credential: PhoneAuthCredential
            ) {
                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(
                e: FirebaseException
            ) {

                binding.sendOtpBtn.isEnabled = true

                Log.e(
                    TAG,
                    "Verification Failed: ${e.message}"
                )

                Toast.makeText(
                    this@LoginActivity,
                    e.localizedMessage ?: "Verification Failed",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {

                super.onCodeSent(
                    verificationId,
                    token
                )

                storedVerificationId = verificationId
                resendToken = token

                binding.sendOtpBtn.isEnabled = true

                binding.verifyOtpTil.visibility =
                    View.VISIBLE

                binding.verifyOtpBtn.visibility =
                    View.VISIBLE

                startOtpTimer()

                Toast.makeText(
                    this@LoginActivity,
                    "OTP Sent Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    private fun sendOtp(phoneNumber: String) {

        val options =
            PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(phoneNumber)
                .setTimeout(
                    60L,
                    TimeUnit.SECONDS
                )
                .setActivity(this)
                .setCallbacks(callbacks)
                .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyOtp(
        otpCode: String
    ) {

        if (storedVerificationId.isNullOrEmpty()) {

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

        signInWithPhoneAuthCredential(
            credential
        )
    }

    private fun signInWithPhoneAuthCredential(
        credential: PhoneAuthCredential
    ) {

        binding.verifyOtpBtn.isEnabled = false

        auth.signInWithCredential(
            credential
        ).addOnCompleteListener(this) { task ->

            binding.verifyOtpBtn.isEnabled = true

            if (task.isSuccessful) {

                SessionManager.saveLogin()

                Toast.makeText(
                    this,
                    "Login Successful"
                    ,
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

                Log.e(
                    TAG,
                    task.exception?.message ?: "OTP Error"
                )

                Toast.makeText(
                    this,
                    task.exception?.localizedMessage
                        ?: "Invalid OTP",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun startOtpTimer() {

        binding.timerTv.visibility = View.VISIBLE
        binding.resendOtpBtn.visibility = View.GONE

        countDownTimer?.cancel()

        countDownTimer =
            object : CountDownTimer(
                60000,
                1000
            ) {

                override fun onTick(
                    millisUntilFinished: Long
                ) {

                    val seconds =
                        millisUntilFinished / 1000

                    binding.timerTv.text =
                        "Resend OTP in $seconds sec"
                }

                override fun onFinish() {

                    binding.timerTv.visibility =
                        View.GONE

                    binding.resendOtpBtn.visibility =
                        View.VISIBLE
                }
            }

        countDownTimer?.start()
    }

    override fun onDestroy() {

        countDownTimer?.cancel()
        countDownTimer = null

        super.onDestroy()
    }
}