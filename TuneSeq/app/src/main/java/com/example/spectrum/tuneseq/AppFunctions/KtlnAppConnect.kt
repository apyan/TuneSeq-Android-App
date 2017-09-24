package com.example.spectrum.tuneseq.AppFunctions

import android.content.Context
import android.net.ConnectivityManager

/**
 * This class is used for connection purposes.
 */

class KtlnAppConnect {

    // Variables for the class
    internal var eContext: Context ? = null

    // Constructor
    fun AppConnect(context: Context) {
        eContext = context
    }

    // Checking for Internet Connectivity
    fun connectionAvailable(): Boolean {
        val connectivityManager = eContext ?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}