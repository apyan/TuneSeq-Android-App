package com.example.spectrum.tuneseq.AppFunctions

import android.content.Context
import android.net.ConnectivityManager

/**
 * This class is used for connection purposes.
 */

class KtlnAppConnect constructor(context: Context ?) {

    // Variables for the class
    internal var eContext: Context ? = null

    // Constructor
    init {
        eContext = context
    }

    // Checking for Internet Connectivity
    fun connectionAvailable(): Boolean {
        val connectivityManager = eContext ?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}