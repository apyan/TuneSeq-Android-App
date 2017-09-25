package com.example.spectrum.tuneseq.AppObjects

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import java.io.IOException
import java.net.HttpURLConnection

/**
 * For the downloaded bitmap and attributes
 */

class KtlnBitmapObject {

    // Constructor
    fun KtlnBitmapObject() {

    }

    // Download image from a source
    fun getBitmapFromURL(src: String?): Bitmap? {
        try {
            val url = java.net.URL(src)
            val connection = url
                    .openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input = connection.inputStream
            return BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }

    }

    // Used to prevent Out of Memory
    fun getResizedBitmap(bm: Bitmap?, newHeight: Int, newWidth: Int): Bitmap? {
        val width = bm ?.width
        val height = bm ?.height
        val scaleWidth = newWidth.toFloat() / width as Int
        val scaleHeight = newHeight.toFloat() / height as Int

        // CREATE A MATRIX FOR THE MANIPULATION
        val matrix = Matrix()

        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight)

        // RECREATE THE NEW BITMAP
        return Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, false)
    }

}