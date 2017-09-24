package com.example.spectrum.tuneseq.AppFunctions

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.example.spectrum.tuneseq.AppObjects.BitmapObject
import com.example.spectrum.tuneseq.AppObjects.HttpObject
import com.example.spectrum.tuneseq.AppObjects.TrackInfo
import com.example.spectrum.tuneseq.R
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.util.ArrayList

/**
 * Asynchronous Task for the Search List View
 */

class KtlnAsyncTaskSearch constructor(context: Context, listView: ListView)
    : AsyncTask<String, String, String>() {

    // Variables of the Asynchronous Task
    private val errorMessage = ""
    var asyncConnect: AppConnect ? = null
    var eContext: Context ? = null
    internal var progressDialog: ProgressDialog ? = null
    var tracksFound: ArrayList<TrackInfo>
    var list_00: ListView

    // Constructor
    init {
        eContext = context
        asyncConnect = AppConnect(eContext)
        tracksFound = ArrayList()
        list_00 = listView
    }

    override fun onPreExecute() {
        progressDialog = ProgressDialog.show(eContext,
                eContext ?.resources ?.getString(R.string.loading_000),
                eContext ?.resources ?.getString(R.string.loading_001))
    }

    override fun doInBackground(vararg params: String): String {

        // Initiates JSON source
        val httpObject = HttpObject()
        val jsonString = httpObject.makeServiceCall(params[0])

        if (jsonString != null) {
            try {
                // Obtain as JSON object
                val jsonObject = JSONObject(jsonString)

                // Getting JSON Array of 'results'
                val resultArray = jsonObject.getJSONArray(
                        eContext ?.resources ?.getString(R.string.label_start))

                // Scanning through the results
                for (index in 0 until resultArray.length()) {

                    // Gather data nodes
                    val resultObj = resultArray.getJSONObject(index)
                    val resultTrack = TrackInfo()

                    // Obtains data from the track
                    resultTrack.wrapperType = resultObj.getString(eContext ?.resources ?.getString(R.string.label_000))
                    resultTrack.kind = resultObj.getString(eContext ?.resources ?.getString(R.string.label_001))
                    resultTrack.artistId = resultObj.getInt(eContext ?.resources ?.getString(R.string.label_002))
                    resultTrack.collectionId = resultObj.getInt(eContext ?.resources ?.getString(R.string.label_003))
                    resultTrack.trackId = resultObj.getInt(eContext ?.resources ?.getString(R.string.label_004))
                    resultTrack.artistName = resultObj.getString(eContext ?.resources ?.getString(R.string.label_005))
                    resultTrack.collectionName = resultObj.getString(eContext ?.resources ?.getString(R.string.label_006))
                    resultTrack.trackName = resultObj.getString(eContext ?.resources ?.getString(R.string.label_007))
                    resultTrack.collectionCensoredName = resultObj.getString(eContext ?.resources ?.getString(R.string.label_008))
                    resultTrack.trackCensoredName = resultObj.getString(eContext ?.resources ?.getString(R.string.label_009))
                    resultTrack.artistViewUrl = resultObj.getString(eContext ?.resources ?.getString(R.string.label_010))
                    resultTrack.collectionViewUrl = resultObj.getString(eContext ?.resources ?.getString(R.string.label_011))
                    resultTrack.trackViewUrl = resultObj.getString(eContext ?.resources ?.getString(R.string.label_012))
                    resultTrack.previewUrl = resultObj.getString(eContext ?.resources ?.getString(R.string.label_013))
                    resultTrack.artworkUrl30 = resultObj.getString(eContext ?.resources ?.getString(R.string.label_014))
                    resultTrack.artworkUrl60 = resultObj.getString(eContext ?.resources ?.getString(R.string.label_015))
                    resultTrack.artworkUrl100 = resultObj.getString(eContext ?.resources ?.getString(R.string.label_016))

                    // Downloading the JPG into BitMap, and resize to 75 x 75
                    val bitmapObject = BitmapObject()
                    resultTrack.artIcon = bitmapObject.getBitmapFromURL(resultTrack.artworkUrl100)
                    resultTrack.artIcon = bitmapObject.getResizedBitmap(resultTrack.artIcon, 100, 100)
                    resultTrack.artIcon70 = bitmapObject.getResizedBitmap(resultTrack.artIcon, 70, 70)

                    resultTrack.collectionPrice = resultObj.getDouble(eContext ?.resources ?.getString(R.string.label_017))
                    resultTrack.trackPrice = resultObj.getDouble(eContext ?.resources ?.getString(R.string.label_018))
                    resultTrack.releaseDate = resultObj.getString(eContext ?.resources ?.getString(R.string.label_019))
                    resultTrack.collectionExplicitness = resultObj.getString(eContext ?.resources ?.getString(R.string.label_020))
                    resultTrack.trackExplicitness = resultObj.getString(eContext ?.resources ?.getString(R.string.label_021))
                    resultTrack.discCount = resultObj.getInt(eContext ?.resources ?.getString(R.string.label_022))
                    resultTrack.discNumber = resultObj.getInt(eContext ?.resources ?.getString(R.string.label_023))
                    resultTrack.trackCount = resultObj.getInt(eContext ?.resources ?.getString(R.string.label_024))
                    resultTrack.trackNumber = resultObj.getInt(eContext ?.resources ?.getString(R.string.label_025))
                    resultTrack.trackTimeMillis = resultObj.getInt(eContext ?.resources ?.getString(R.string.label_026))
                    resultTrack.country = resultObj.getString(eContext ?.resources ?.getString(R.string.label_027))
                    resultTrack.currency = resultObj.getString(eContext ?.resources ?.getString(R.string.label_028))
                    resultTrack.primaryGenreName = resultObj.getString(eContext ?.resources ?.getString(R.string.label_029))
                    resultTrack.isStreamable = resultObj.getBoolean(eContext ?.resources ?.getString(R.string.label_030))

                    // Adds new track node
                    tracksFound ?.add(resultTrack)
                }

            } catch (e: JSONException) {
                e.message
            }

        } else {
            // Notify the lack of connection
            Toast.makeText(eContext,
                    eContext ?.resources ?.getString(R.string.connect_001),
                    Toast.LENGTH_LONG).show()
        }

        return errorMessage
    }

    override fun onPostExecute(args: String) {

        // Populate ListView
        list_00.adapter = SearchListAdapter(eContext, tracksFound)

        // Checks for the result amount
        if (tracksFound ?.size == 0) {
            Toast.makeText(eContext, eContext ?.resources ?.getString(R.string.search_none),
                    Toast.LENGTH_SHORT).show()
        }

        // Dismiss Progress Dialog
        progressDialog ?.dismiss()

    }

    // Return Functions
    // Get the URL input stream
    fun getInputStream(url: URL): InputStream? {
        try {
            return url.openConnection().getInputStream()
        } catch (e: IOException) {
            return null
        }

    }

    // Kotlin Version
    fun getTracksFoundKtln(): ArrayList<TrackInfo> {
        return tracksFound
    }

}