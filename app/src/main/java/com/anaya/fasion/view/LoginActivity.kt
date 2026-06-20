package com.anaya.fasion.view

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anaya.fashion.databinding.LoginActivityBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginActivityBinding
    private lateinit var auth: FirebaseAuth

    private var verificationId: String? = null
    private var resendToken: PhoneAuthProvider.ForceResendingToken? = null

    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        showPhoneSection()
        setupClickListeners()
    }

    private fun setupClickListeners() {

        binding.sendOtpBtn.setOnClickListener {
            sendOtpClicked()
        }

        binding.verifyOtpBtn.setOnClickListener {
            verifyOtpClicked()
        }

        binding.resendOtpBtn.setOnClickListener {
            val phone = binding.phoneNumberEt.text.toString().trim()
            sendOtp("+91$phone")
        }
    }

    // ================= SEND OTP =================
    private fun sendOtpClicked() {

        val phone = binding.phoneNumberEt.text.toString().trim()

        if (phone.isEmpty()) {
            binding.phoneNumberEt.error = "Enter Phone Number"
            return
        }

        if (phone.length != 10) {
            binding.phoneNumberEt.error = "Enter Valid Phone Number"
            return
        }

        showOtpSection()
        sendOtp("+91$phone")
    }

    private fun sendOtp(phone: String) {

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phone)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    // ================= VERIFY OTP =================
    private fun verifyOtpClicked() {

        val otp = binding.verifyOtpEt.text.toString().trim()

        when {
            otp.isEmpty() -> binding.verifyOtpEt.error = "Enter OTP"
            otp.length != 6 -> binding.verifyOtpEt.error = "Enter Valid OTP"
            else -> verifyOtp(otp)
        }
    }

    private fun verifyOtp(otp: String) {

        val id = verificationId ?: run {
            showToast("OTP not received")
            return
        }

        val credential = PhoneAuthProvider.getCredential(id, otp)
        signIn(credential)
    }

    // ================= FIREBASE CALLBACK =================
    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            signIn(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            showToast(e.message ?: "Verification Failed")
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            this@LoginActivity.verificationId = verificationId
            resendToken = token

            showToast("OTP Sent")

            startTimer()   // 🔥 TIMER START HERE
        }
    }

    // ================= LOGIN =================
    private fun signIn(credential: PhoneAuthCredential) {

        auth.signInWithCredential(credential)
            .addOnCompleteListener {

                if (it.isSuccessful) {
                    showToast("Login Success")

                    startActivity(Intent(this, DashboardActivity::class.java))
                    finish()
                } else {
                    showToast("Invalid OTP")
                }
            }
    }

    // ================= UI CONTROL =================
    private fun showPhoneSection() {

        binding.phoneTil.visibility = View.VISIBLE
        binding.sendOtpBtn.visibility = View.VISIBLE

        binding.verifyOtpTil.visibility = View.GONE
        binding.verifyOtpBtn.visibility = View.GONE
        binding.timerTv.visibility = View.GONE
        binding.resendOtpBtn.visibility = View.GONE
    }

    private fun showOtpSection() {

        binding.phoneTil.visibility = View.VISIBLE
        binding.sendOtpBtn.visibility = View.VISIBLE

        binding.verifyOtpTil.visibility = View.VISIBLE
        binding.verifyOtpBtn.visibility = View.VISIBLE

        binding.timerTv.visibility = View.VISIBLE
        binding.resendOtpBtn.visibility = View.GONE

        startTimer() // 🔥 IMPORTANT FIX (UI open hote hi timer start)
    }

    // ================= TIMER =================
    private fun startTimer() {

        timer?.cancel()

        binding.resendOtpBtn.visibility = View.GONE

        timer = object : CountDownTimer(60000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val sec = millisUntilFinished / 1000
                binding.timerTv.text = "Resend in $sec sec"
            }

            override fun onFinish() {
                binding.timerTv.text = "You can resend OTP"
                binding.resendOtpBtn.visibility = View.VISIBLE
            }
        }.start()
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}