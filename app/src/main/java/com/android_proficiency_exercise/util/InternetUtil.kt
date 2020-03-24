package com.android_proficiency_exercise.util

import android.content.Context
import android.net.ConnectivityManager

class InternetUtil(private val context: Context) {
    var isInternetConnectivity = false
        private set

    fun connectivityAvailable() {
        val connectivityManager = context.applicationContext
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        isInternetConnectivity = activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}