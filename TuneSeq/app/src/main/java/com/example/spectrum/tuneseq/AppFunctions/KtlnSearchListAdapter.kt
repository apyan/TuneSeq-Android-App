package com.example.spectrum.tuneseq.AppFunctions

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.spectrum.tuneseq.AppObjects.TrackInfo
import com.example.spectrum.tuneseq.R
import com.example.spectrum.tuneseq.ViewScreen
import java.util.ArrayList

/**
 * Adapter for the list view searching
 */

class KtlnSearchListAdapter constructor(context: Context, results: ArrayList<TrackInfo>) : BaseAdapter () {

    // Variables for the adapter
    var inflater: LayoutInflater? = null
    var foundedTracks: ArrayList<TrackInfo>
    internal var eContext: Context

    // Constructor
    init {
        eContext = context
        foundedTracks = results
        inflater = eContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        // TODO Auto-generated method stub
        return foundedTracks.size
    }

    override fun getItem(position: Int): Any {
        // TODO Auto-generated method stub
        return position
    }

    override fun getItemId(position: Int): Long {
        // TODO Auto-generated method stub
        return position.toLong()
    }

    // List Row Attributes
    inner class RowAttributes {
        internal var image_00: ImageView? = null
        internal var text_00: TextView? = null
        internal var text_01: TextView? = null
        internal var text_02: TextView? = null
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        // TODO Auto-generated method stub
        val rowAttributes = RowAttributes()
        val rowView: View

        rowView = inflater!!.inflate(R.layout.layout_listview_000, null)
        rowAttributes.image_00 = rowView.findViewById<View>(R.id.image_000) as ImageView
        rowAttributes.text_00 = rowView.findViewById<View>(R.id.text_000) as TextView
        rowAttributes.text_01 = rowView.findViewById<View>(R.id.text_001) as TextView
        rowAttributes.text_02 = rowView.findViewById<View>(R.id.text_002) as TextView

        // Set up the display information
        rowAttributes.image_00!!.setImageBitmap(foundedTracks[position].artIcon70)
        rowAttributes.text_00!!.text = foundedTracks[position].trackCensoredName
        rowAttributes.text_01!!.text = foundedTracks[position].collectionCensoredName
        rowAttributes.text_02!!.text = foundedTracks[position].artistName

        rowView.setOnClickListener { v ->
            // TODO Auto-generated method stub

            // Head to the viewing screen
            val eIntent = Intent(eContext, ViewScreen::class.java)
            eIntent.putExtra("seekTrack", foundedTracks[position])
            v.context.startActivity(eIntent)
        }
        return rowView
    }

}