package com.android_proficiency_exercise.activity

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android_proficiency_exercise.R
import com.android_proficiency_exercise.databinding.ActivityMainBinding
import com.android_proficiency_exercise.util.InternetUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        binding.refreshButton.setOnClickListener {
            val internetUtil = InternetUtil(applicationContext)
            internetUtil.connectivityAvailable()

            if (internetUtil.isInternetConnectivity) {
                Toast.makeText(applicationContext, "Internet is Available", LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Internet is Not Available", LENGTH_LONG).show()
            }
        }
    }
}