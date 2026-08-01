package com.anaya.fashion.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.anaya.fashion.databinding.ActivityABinding
import com.anaya.fashion.databinding.LoginActivityBinding

class ActivityB: AppCompatActivity() {
    private lateinit var binding: ActivityABinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.activityNameTv.text = "Activity B"
        binding.goToNextScreenBtn.text = "Go To Activity C"

        Log.d("LAUNCH_MODES", "B")

        binding.goToNextScreenBtn.setOnClickListener {
            startActivity(Intent(this, ActivityC::class.java))
        }
    }

    /*
    * Launch Modes:
    *
    * 1. standard: This is the default launch mode. A new instance of the activity is created every time it is launched.
    * Example with arrow: Activity B -> Activity A -> Activity B -> Activity A (two instances of Activity A)
    * Example: A -> B -> C -> D -> A >>>>>>>>>>>>Back Stack>>>>>>>>>>>>> A -> B -> C -> D -> A
    *
    * 2. singleTop: If an instance of the activity already exists at the top of the task's back stack, a new instance will not be created. Instead, the existing instance will receive the new intent in its onNewIntent() method.
    * Example with arrow: A -> B -> C -> D -> D >>>>>>>>Back Stack>>>>>>>>>>>> A -> B -> C -> D
    *
    *
    * 3. singleTask: If an instance of the activity already exists in the task's back stack, a new instance will not be created. Instead, the existing instance will be brought to the front and receive the new intent in its onNewIntent() method. If no instance exists, a new one will be created.
    * Example: A -> B -> C -> D -> A(New) >>>>>>>>>>Back Stack>>>>>>>>>> A (New)
    *
    * 4. singleInstance: This is similar to singleTask, but the activity will be the only one in its task. If an instance of the activity already exists, it will be brought to the front and receive the new intent in its onNewIntent() method. If no instance exists, a new one will be created
    * Example: A -> B -> C -> D -> A(New) >>>>>>>>>>Back Stack>>>>>>>>>> Instance 1 - B -> C -> D
    *                                                                    Instance 2 - A (New)
    */
}