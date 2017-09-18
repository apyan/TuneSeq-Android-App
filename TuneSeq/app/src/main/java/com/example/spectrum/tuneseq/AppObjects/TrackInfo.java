package com.example.spectrum.tuneseq.AppObjects;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Object to hold the information of the track results
 * of the searched query.
 */

public class TrackInfo implements Parcelable {

    // Variables of the object
    public String wrapperType;
    public String kind;
    public int artistId;
    public int collectionId;
    public int trackId;
    public String artistName;
    public String collectionName;
    public String trackName;
    public String collectionCensoredName;
    public String trackCensoredName;
    public String artistViewUrl;
    public String collectionViewUrl;
    public String trackViewUrl;
    public String previewUrl;
    public String artworkUrl30;
    public String artworkUrl60;
    public String artworkUrl100;
    public double collectionPrice;
    public double trackPrice;
    public String releaseDate;
    public String collectionExplicitness;
    public String trackExplicitness;
    public int discCount;
    public int discNumber;
    public int trackCount;
    public int trackNumber;
    public int trackTimeMillis;
    public String country;
    public String currency;
    public String primaryGenreName;
    public boolean isStreamable;

    public Bitmap artIcon;
    public Bitmap artIcon70;

    // Constructor
    public TrackInfo() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Storing the data to Parcel object
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(wrapperType);
        dest.writeString(kind);
        dest.writeInt(artistId);
        dest.writeInt(collectionId);
        dest.writeInt(trackId);
        dest.writeString(artistName);
        dest.writeString(collectionName);
        dest.writeString(trackName);
        dest.writeString(collectionCensoredName);
        dest.writeString(trackCensoredName);
        dest.writeString(artistViewUrl);
        dest.writeString(collectionViewUrl);
        dest.writeString(trackViewUrl);
        dest.writeString(previewUrl);
        dest.writeString(artworkUrl100);
        dest.writeDouble(collectionPrice);
        dest.writeDouble(trackPrice);
        dest.writeString(releaseDate);
        dest.writeString(collectionExplicitness);
        dest.writeString(trackExplicitness);
        dest.writeInt(discCount);
        dest.writeInt(discNumber);
        dest.writeInt(trackCount);
        dest.writeInt(trackNumber);
        dest.writeInt(trackTimeMillis);
        dest.writeString(country);
        dest.writeString(currency);
        dest.writeString(primaryGenreName);
    }

    // For Creator
    private TrackInfo(Parcel in){
        this.wrapperType = in.readString();
        this.kind = in.readString();
        this.artistId = in.readInt();
        this.collectionId = in.readInt();
        this.trackId = in.readInt();
        this.artistName = in.readString();
        this.collectionName = in.readString();
        this.trackName = in.readString();
        this.collectionCensoredName = in.readString();
        this.trackCensoredName = in.readString();
        this.artistViewUrl = in.readString();
        this.collectionViewUrl = in.readString();
        this.trackViewUrl = in.readString();
        this.previewUrl = in.readString();
        this.artworkUrl100 = in.readString();
        this.collectionPrice = in.readDouble();
        this.trackPrice = in.readDouble();
        this.releaseDate = in.readString();
        this.collectionExplicitness = in.readString();
        this.trackExplicitness = in.readString();
        this.discCount = in.readInt();
        this.discNumber = in.readInt();
        this.trackCount = in.readInt();
        this.trackNumber = in.readInt();
        this.trackTimeMillis = in.readInt();
        this.country = in.readString();
        this.currency = in.readString();
        this.primaryGenreName = in.readString();
    }

    public static final Parcelable.Creator<TrackInfo> CREATOR = new Parcelable.Creator<TrackInfo>() {
        @Override
        public TrackInfo createFromParcel(Parcel source) {
            return new TrackInfo(source);
        }

        @Override
        public TrackInfo[] newArray(int size) {
            return new TrackInfo[size];
        }
    };

}
