package com.example.spectrum.tuneseq.AppObjects

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

/**
 * Object to hold the information of the track results
 * of the searched query.
 */

class KtlnTrackInfo : Parcelable {

    // Variables of the object
    var wrapperType : String ? = null
    var kind : String ? = null
    var artistId : Int = 0
    var collectionId : Int = 0
    var trackId : Int = 0
    var artistName : String ? = null
    var collectionName : String ? = null
    var trackName : String ? = null
    var collectionCensoredName : String ? = null
    var trackCensoredName : String ? = null
    var artistViewUrl : String ? = null
    var collectionViewUrl : String ? = null
    var trackViewUrl : String ? = null
    var previewUrl : String ? = null
    var artworkUrl30 : String ? = null
    var artworkUrl60 : String ? = null
    var artworkUrl100 : String ? = null
    var collectionPrice : Double = 0.toDouble()
    var trackPrice : Double = 0.toDouble()
    var releaseDate : String ? = null
    var collectionExplicitness : String ? = null
    var trackExplicitness : String ? = null
    var discCount : Int = 0
    var discNumber : Int = 0
    var trackCount : Int = 0
    var trackNumber : Int = 0
    var trackTimeMillis : Int = 0
    var country : String ? = null
    var currency : String ? = null
    var primaryGenreName : String ? = null
    var isStreamable : Boolean = false

    var artIcon : Bitmap ? = null
    var artIcon70 : Bitmap ? = null

    // Constructor
    fun KtlnTrackInfo () {

    }

    override fun describeContents(): Int {
        return 0
    }

    // Storing the data to Parcel object
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(wrapperType)
        dest.writeString(kind)
        dest.writeInt(artistId)
        dest.writeInt(collectionId)
        dest.writeInt(trackId)
        dest.writeString(artistName)
        dest.writeString(collectionName)
        dest.writeString(trackName)
        dest.writeString(collectionCensoredName)
        dest.writeString(trackCensoredName)
        dest.writeString(artistViewUrl)
        dest.writeString(collectionViewUrl)
        dest.writeString(trackViewUrl)
        dest.writeString(previewUrl)
        dest.writeString(artworkUrl100)
        dest.writeDouble(collectionPrice)
        dest.writeDouble(trackPrice)
        dest.writeString(releaseDate)
        dest.writeString(collectionExplicitness)
        dest.writeString(trackExplicitness)
        dest.writeInt(discCount)
        dest.writeInt(discNumber)
        dest.writeInt(trackCount)
        dest.writeInt(trackNumber)
        dest.writeInt(trackTimeMillis)
        dest.writeString(country)
        dest.writeString(currency)
        dest.writeString(primaryGenreName)
    }

    // For Creator
    private fun TrackInfo(`in` : Parcel) {
        this.wrapperType = `in`.readString()
        this.kind = `in`.readString()
        this.artistId = `in`.readInt()
        this.collectionId = `in`.readInt()
        this.trackId = `in`.readInt()
        this.artistName = `in`.readString()
        this.collectionName = `in`.readString()
        this.trackName = `in`.readString()
        this.collectionCensoredName = `in`.readString()
        this.trackCensoredName = `in`.readString()
        this.artistViewUrl = `in`.readString()
        this.collectionViewUrl = `in`.readString()
        this.trackViewUrl = `in`.readString()
        this.previewUrl = `in`.readString()
        this.artworkUrl100 = `in`.readString()
        this.collectionPrice = `in`.readDouble()
        this.trackPrice = `in`.readDouble()
        this.releaseDate = `in`.readString()
        this.collectionExplicitness = `in`.readString()
        this.trackExplicitness = `in`.readString()
        this.discCount = `in`.readInt()
        this.discNumber = `in`.readInt()
        this.trackCount = `in`.readInt()
        this.trackNumber = `in`.readInt()
        this.trackTimeMillis = `in`.readInt()
        this.country = `in`.readString()
        this.currency = `in`.readString()
        this.primaryGenreName = `in`.readString()
    }

    val CREATOR: Parcelable.Creator<TrackInfo> = object : Parcelable.Creator<TrackInfo> {
        override fun createFromParcel(source: Parcel): TrackInfo {
            return TrackInfo(source) as TrackInfo
        }

        override fun newArray(size: Int): Array<TrackInfo ?> {
            return arrayOfNulls(size)
        }
    }

}