package com.example.spectrum.tuneseq.AppFunctions

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.widget.ImageView
import com.example.spectrum.tuneseq.AppObjects.BitmapObject
import com.example.spectrum.tuneseq.AppObjects.KtlnBitmapObject
import com.example.spectrum.tuneseq.AppObjects.KtlnTrackInfo
import com.example.spectrum.tuneseq.AppObjects.TrackInfo
import com.example.spectrum.tuneseq.R

/**
 * Asynchronous Task for the start View
 */
class KtlnAsyncTaskFirstView constructor(context: Context ?, ti: KtlnTrackInfo ?, imageView: ImageView ?)
    : AsyncTask <String, String, String> () {

    // Variables of the Asynchronous Task
    private val errorMessage = ""
    internal var trackInfo: KtlnTrackInfo? = null
    internal var eContext: Context ? = null
    internal var progressDialog: ProgressDialog ? = null
    internal var image_00: ImageView ? = null

    // Constructor
    init {
        eContext = context
        trackInfo = ti
        image_00 = imageView

    }

    override fun onPreExecute() {
        progressDialog = ProgressDialog.show(eContext,
                eContext ?.resources ?.getString(R.string.loading_002),
                eContext ?.resources ?.getString(R.string.loading_003))
    }

    override fun doInBackground(vararg params: String): String {

        // Download needed contents
        val bitmapObject = KtlnBitmapObject()
        trackInfo ?.artIcon = bitmapObject.getBitmapFromURL(trackInfo ?.artworkUrl100)
        trackInfo ?.artIcon = bitmapObject.getResizedBitmap(trackInfo ?.artIcon, 100, 100)

        return errorMessage
    }

    override fun onPostExecute(args: String) {

        image_00 ?.setImageBitmap(trackInfo ?.artIcon)

        // Dismiss Progress Dialog
        progressDialog ?.dismiss()
    }

}