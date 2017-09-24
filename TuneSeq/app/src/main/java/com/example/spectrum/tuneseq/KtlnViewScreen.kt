package com.example.spectrum.tuneseq

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.spectrum.tuneseq.AppFunctions.AsyncTaskFirstView
import com.example.spectrum.tuneseq.AppObjects.TrackInfo

class KtlnViewScreen : Activity() {

    // Variables of the Activity (Kotlin)
    internal var context: Context ? = null
    internal var trackInfo: TrackInfo ? = null
    internal var image_00: ImageView ? = null
    internal var text_00 : TextView ? = null
    internal var text_01 : TextView ? = null
    internal var text_02 : TextView ? = null
    internal var price_00 : TextView ? = null
    internal var price_01 : TextView ? = null
    internal var label_00 : TextView ? = null
    internal var label_01 : TextView ? = null
    internal var label_02 : TextView ? = null
    internal var label_03 : TextView ? = null
    internal var label_04 : TextView ? = null
    internal var label_05 : TextView ? = null
    internal var label_06 : TextView ? = null
    internal var info_00 : TextView ? = null
    internal var info_01 : TextView ? = null
    internal var info_02 : TextView ? = null
    internal var info_03 : TextView ? = null
    internal var info_04 : TextView ? = null
    internal var info_05 : TextView ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_screen)

        context = this

        // Gather the track information
        //Intent intent = getIntent();
        //trackInfo = (TrackInfo) intent.getSerializableExtra("seekTrack");
        trackInfo = intent.getParcelableExtra<Parcelable>("seekTrack") as TrackInfo ?

        // Set up the XML UI attributes
        image_00 = findViewById<View>(R.id.image_000) as ImageView
        text_00 = findViewById<View>(R.id.text_000) as TextView
        text_01 = findViewById<View>(R.id.text_001) as TextView
        text_02 = findViewById<View>(R.id.text_002) as TextView
        price_00 = findViewById<View>(R.id.price_000) as TextView
        price_01 = findViewById<View>(R.id.price_001) as TextView
        label_00 = findViewById<View>(R.id.label_000) as TextView
        label_01 = findViewById<View>(R.id.label_001) as TextView
        label_02 = findViewById<View>(R.id.label_002) as TextView
        label_03 = findViewById<View>(R.id.label_003) as TextView
        label_04 = findViewById<View>(R.id.label_004) as TextView
        label_05 = findViewById<View>(R.id.label_005) as TextView
        label_06 = findViewById<View>(R.id.label_006) as TextView
        info_00 = findViewById<View>(R.id.info_000) as TextView
        info_01 = findViewById<View>(R.id.info_001) as TextView
        info_02 = findViewById<View>(R.id.info_002) as TextView
        info_03 = findViewById<View>(R.id.info_003) as TextView
        info_04 = findViewById<View>(R.id.info_004) as TextView
        info_05 = findViewById<View>(R.id.info_005) as TextView

        // Execute Asynchronous Task
        val seeker = AsyncTaskFirstView(context, trackInfo, image_00)
        seeker.execute()

        // Set up track info
        text_00 ?.setText(trackInfo ?.trackCensoredName)
        text_01 ?.setText(trackInfo ?.collectionCensoredName)
        text_02 ?.setText(trackInfo ?.artistName)
        price_00 ?.setText(trackInfo ?.trackPrice.toString() + " " + trackInfo ?.currency)
        price_01 ?.setText(trackInfo ?.collectionPrice.toString() + " " + trackInfo ?.currency)
        label_00 ?.setText(trackInfo ?.discCount.toString() + "")
        label_01 ?.setText(trackInfo ?.discNumber.toString() + "")
        label_02 ?.setText(trackInfo ?.trackCount.toString() + "")
        label_03 ?.setText(trackInfo ?.trackNumber.toString() + "")
        label_04 ?.setText(trackInfo ?.artistId.toString() + "")
        label_05 ?.setText(trackInfo ?.trackId.toString() + "")
        label_06 ?.setText(trackInfo ?.collectionId.toString() + "")
        info_00 ?.setText(trackInfo ?.kind ?.substring(0, 1) ?.toUpperCase() + trackInfo ?.kind ?.substring(1))
        info_01 ?.setText(trackInfo ?.primaryGenreName)
        info_02 ?.setText(trackInfo ?.collectionName)
        info_03 ?.setText(trackInfo ?.trackName)

        // Rounding the minutes to two decimal places
        var minuteCount : Double = (trackInfo ?.trackTimeMillis) ?.div(60000.00) as Double
        minuteCount = Math.round(minuteCount.times(100)).toDouble()
        minuteCount = minuteCount / 100
        info_04 ?.setText(minuteCount.toString() + " " + getString(R.string.duration_var))
        info_05 ?.setText(trackInfo ?.releaseDate ?.substring(5, 7) + "/"
                + trackInfo ?.releaseDate ?.substring(8, 10) + "/"
                + trackInfo ?.releaseDate ?.substring(0, 4))
    }

    // To Artist via Internet
    fun onArtistLink(v : View) {
        val browseIntent = Intent(Intent.ACTION_VIEW, Uri.parse(trackInfo ?.artistViewUrl))
        startActivity(browseIntent)
    }

    // To Collection via Internet
    fun onCollectionLink(v : View) {
        val browseIntent = Intent(Intent.ACTION_VIEW, Uri.parse(trackInfo ?.collectionViewUrl))
        startActivity(browseIntent)
    }

    // To Track via Internet
    fun onTrackLink(v : View) {
        val browseIntent = Intent(Intent.ACTION_VIEW, Uri.parse(trackInfo ?.trackViewUrl))
        startActivity(browseIntent)
    }

    // To Track Sample via Internet
    fun onSampleLink(v : View) {
        val browseIntent = Intent(Intent.ACTION_VIEW, Uri.parse(trackInfo ?.previewUrl))
        startActivity(browseIntent)
    }

    // Custom Back Button is pressed
    fun onBackButton(v : View) {
        finish()
    }

}
