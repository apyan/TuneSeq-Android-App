package com.example.spectrum.tuneseq.AppObjects

import android.util.Log
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.ProtocolException
import java.net.URL

/**
 * Uses Http to collect Info
 */

class KtlnHttpObject {

    // Variables of the object
    private val TAG : String = ""

    // Constructor
    fun KtlnHttpObject () {

    }

    // Used upon calling service
    fun makeServiceCall(reqUrl: String): String? {

        var response: String? = null

        try {
            val url = URL(reqUrl)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"

            // Collects responses
            val `in` = BufferedInputStream(conn.inputStream)
            response = convertStreamToString(`in`)
        } catch (e: MalformedURLException) {
            Log.e(TAG, "MalformedURLException: " + e.message)
        } catch (e: ProtocolException) {
            Log.e(TAG, "ProtocolException: " + e.message)
        } catch (e: IOException) {
            Log.e(TAG, "IOException: " + e.message)
        } catch (e: Exception) {
            Log.e(TAG, "Exception: " + e.message)
        }

        return response
    }

    // For String conversion from source
    private fun convertStreamToString(`is`: InputStream): String {

        val reader = BufferedReader(InputStreamReader(`is`))
        val sb = StringBuilder()
        var line : String

        try {
            // MODIFIED
            while (reader.readLine() != null) {
                line = reader.readLine()
                sb.append(line).append('\n')
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                `is`.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        return sb.toString()
    }

}