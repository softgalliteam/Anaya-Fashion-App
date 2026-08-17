package com.anaya.fashion.view

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import androidx.lifecycle.lifecycleScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.anaya.fashion.R
import com.anaya.fashion.databinding.LoginActivityBinding
import com.anaya.fashion.utils.SessionManager
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import android.text.TextWatcher
import android.view.KeyEvent

class LoginActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "LoginActivity"
    }

    lateinit var binding: LoginActivityBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private var storedVerificationId: String? = null
    private var resendToken: PhoneAuthProvider.ForceResendingToken? = null
    private var countDownTimer: CountDownTimer? = null

    private lateinit var credentialManager: CredentialManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        // Initialize Firebase Auth and Credential Manager
        //firebaseAuth = Firebase.auth
        credentialManager = CredentialManager.create(this)

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

        setupClickListeners()
        setupOtpAutoMove()
    }

    private fun setupClickListeners() {

        binding.sendOtpBtn.setOnClickListener {

            val phoneNumber =
                binding.etMobileNumber.text.toString().trim()

            when {
                phoneNumber.isEmpty() -> {
                    binding.etMobileNumber.error =
                        "Enter mobile number"
                }

                phoneNumber.length != 10 -> {
                    binding.etMobileNumber.error =
                        "Enter valid 10 digit number"
                }

                else -> {
                    binding.sendOtpBtn.isEnabled = false
                    sendOtp("+91$phoneNumber")
                }
            }
        }

        binding.verifyOtpBtn.setOnClickListener {

            val otp = "${binding.otp1.text.toString().trim()}${
                binding.otp2.text.toString().trim()
            }${binding.otp3.text.toString().trim()}${binding.otp4.text.toString().trim()}${
                binding.otp5.text.toString().trim()
            }${binding.otp6.text.toString().trim()}"

            when {
                otp.isEmpty() -> {
                    binding.tvVerifyNumber.error =
                        "Enter OTP"
                }

                otp.length != 6 -> {
                    binding.tvVerifyNumber.error =
                        "Enter valid OTP"
                }

                else -> {
                    verifyOtp(otp)
                }
            }
        }

        binding.resendOtpBtn.setOnClickListener {

            val phoneNumber =
                binding.etMobileNumber.text.toString().trim()

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

        binding.loginWithGmail.setOnClickListener {
            triggerGoogleSignIn()
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

                binding.sendOtpContainer.visibility = View.GONE
                binding.verifyOtpContainer.visibility = View.VISIBLE

                binding.otp1.requestFocus()

                startOtpTimer()

                Toast.makeText(
                    this@LoginActivity,
                    "OTP Sent Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

//MOVE TO VERIFY OTP SCREEN

    private fun sendOtp(phoneNumber: String) {

        val options =
            PhoneAuthOptions.newBuilder(firebaseAuth)
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

    private fun verifyOtp(otpCode: String) {

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

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {

        binding.verifyOtpBtn.isEnabled = false

        firebaseAuth.signInWithCredential(
            credential
        ).addOnCompleteListener(this) { task ->

            binding.verifyOtpBtn.isEnabled = true

            if (task.isSuccessful) {

                SessionManager.saveLogin()

                Toast.makeText(
                    this,
                    "Login Successful",
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

    private fun triggerGoogleSignIn() {
        // Configure Google Sign-In options
        val googleIdOption = GetGoogleIdOption.Builder()
            .setServerClientId(getString(R.string.default_web_client_id))
            .setFilterByAuthorizedAccounts(false) // Set true to only show accounts the user has logged into before
            .build()

        // Create the Credential Manager request
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        // Launch the system UI using Coroutines
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = credentialManager.getCredential(this@LoginActivity, request)
                val credential = result.credential

                // Verify if retrieved credential matches Google Identity requirements
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    val googleIdTokenCredential =
                        GoogleIdTokenCredential.createFrom(credential.data)
                    firebaseAuthWithGoogle(googleIdTokenCredential.idToken)
                }
            } catch (e: GetCredentialException) {
                Log.e("AuthError", "Credential sign-in failed: ${e.message}")
                Toast.makeText(
                    this@LoginActivity,
                    "Sign in failed: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Toast.makeText(this, "Welcome ${user?.displayName}!", Toast.LENGTH_SHORT)
                        .show()
                    SessionManager.saveLogin()
                    startActivity(Intent(this, DashboardActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Firebase Authentication failed.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

    fun signOut() {
        // Sign out from Firebase
        firebaseAuth.signOut()

        // Clear credential cache from the device
        CoroutineScope(Dispatchers.Main).launch {
            credentialManager.clearCredentialState(ClearCredentialStateRequest()
            )
        }
    }

    // OTP AUTO MOVE
    private fun setupOtpAutoMove() {

        val otpFields = listOf(
            binding.otp1,
            binding.otp2,
            binding.otp3,
            binding.otp4,
            binding.otp5,
            binding.otp6
        )

        otpFields.forEachIndexed { index, editText ->

            editText.addTextChangedListener(
                object : TextWatcher {

                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                    }

                    override fun afterTextChanged(
                        s: Editable?
                    ) {

                        // If user enters one digit
                        if (s?.length == 1 &&
                            index < otpFields.size - 1
                        ) {

                            // Move to next OTP box
                            otpFields[index + 1].requestFocus()
                        }
                    }
                }
            )

            editText.setOnKeyListener { _, keyCode, event ->

                // Backspace
                if (
                    keyCode == KeyEvent.KEYCODE_DEL &&
                    event.action == KeyEvent.ACTION_DOWN
                ) {

                    // If current box is empty,
                    // move to previous box
                    if (
                        editText.text?.isEmpty() == true &&
                        index > 0
                    ) {

                        otpFields[index - 1].requestFocus()
                    }
                }

                false
            }
        }
    }

}


