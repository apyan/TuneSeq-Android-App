package com.example.spectrum.tuneseq

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.spectrum.tuneseq.AppFunctions.AppConnect
import com.example.spectrum.tuneseq.AppFunctions.AsyncTaskSearch
import com.example.spectrum.tuneseq.AppObjects.TrackInfo

class KtlnSearchScreen : Activity() {

    // Variables of the Activity (Kotlin)
    internal var jsonURL : String = "https://itunes.apple.com/search?term="
    internal var jsonURLFix : String = "https://itunes.apple.com/search?term=Michael+jackson"

    internal var searchConnect : AppConnect ? = null
    internal var context : Context ? = null
    internal var list_000 : ListView ? = null
    internal var trackListing : ArrayList<TrackInfo> ? = null
    internal var editText_00 : EditText ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_screen)

        context = this
        trackListing = java.util.ArrayList()
        searchConnect = AppConnect(context)
        list_000 = findViewById<View>(R.id.listView_00) as ListView
        editText_00 = findViewById<View>(R.id.edittext_00) as EditText
    }

    // Search for the fixed results of the given artist
    fun onSearch(v : View) {

        // Checks for Internet Connection
        if (searchConnect ?.connectionAvailable() != true) {
            Toast.makeText(this, resources.getString(R.string.connect_001), Toast.LENGTH_SHORT).show()
            return
        }

        // Gets the user's query
        var seekQuery = editText_00 ?.getText().toString().trim { it <= ' ' }

        // Checks for empty query
        if (seekQuery == "") {
            Toast.makeText(this, resources.getString(R.string.search_empty), Toast.LENGTH_SHORT).show()
            return
        }

        seekQuery = seekQuery.replace(' ', '+')

        // Execute Asynchronous Task
        val seeker = AsyncTaskSearch(context, list_000)
        // seeker.execute(jsonURLFix);
        seeker.execute(jsonURL + seekQuery)
        trackListing = seeker.getTracksFound()
    }
}
