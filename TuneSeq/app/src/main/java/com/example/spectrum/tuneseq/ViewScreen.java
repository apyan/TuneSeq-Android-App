package com.example.spectrum.tuneseq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spectrum.tuneseq.AppFunctions.AsyncTaskFirstView;
import com.example.spectrum.tuneseq.AppObjects.TrackInfo;

public class ViewScreen extends Activity {

    // Variables of the Activity
    Context context;
    TrackInfo trackInfo;
    ImageView image_00;
    TextView text_00, text_01, text_02;
    TextView price_00, price_01;
    TextView label_00, label_01, label_02, label_03, label_04, label_05, label_06;
    TextView info_00, info_01, info_02, info_03, info_04, info_05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_screen);
        context = this;

        // Gather the track information
        //Intent intent = getIntent();
        //trackInfo = (TrackInfo) intent.getSerializableExtra("seekTrack");
        trackInfo = (TrackInfo) getIntent().getParcelableExtra("seekTrack");

        // Set up the XML UI attributes
        image_00 = (ImageView) findViewById(R.id.image_000);
        text_00 = (TextView) findViewById(R.id.text_000);
        text_01 = (TextView) findViewById(R.id.text_001);
        text_02 = (TextView) findViewById(R.id.text_002);
        price_00 =  (TextView) findViewById(R.id.price_000);
        price_01 =  (TextView) findViewById(R.id.price_001);
        label_00 =  (TextView) findViewById(R.id.label_000);
        label_01 =  (TextView) findViewById(R.id.label_001);
        label_02 =  (TextView) findViewById(R.id.label_002);
        label_03 =  (TextView) findViewById(R.id.label_003);
        label_04 =  (TextView) findViewById(R.id.label_004);
        label_05 =  (TextView) findViewById(R.id.label_005);
        label_06 =  (TextView) findViewById(R.id.label_006);
        info_00 =  (TextView) findViewById(R.id.info_000);
        info_01 =  (TextView) findViewById(R.id.info_001);
        info_02 =  (TextView) findViewById(R.id.info_002);
        info_03 =  (TextView) findViewById(R.id.info_003);
        info_04 =  (TextView) findViewById(R.id.info_004);
        info_05 =  (TextView) findViewById(R.id.info_005);

        // Execute Asynchronous Task
        AsyncTaskFirstView seeker = new AsyncTaskFirstView(context, trackInfo, image_00);
        seeker.execute();

        // Set up track info
        text_00.setText(trackInfo.trackCensoredName);
        text_01.setText(trackInfo.collectionCensoredName);
        text_02.setText(trackInfo.artistName);
        price_00.setText(trackInfo.trackPrice + " " + trackInfo.currency);
        price_01.setText(trackInfo.collectionPrice + " " + trackInfo.currency);
        label_00.setText(trackInfo.discCount + "");
        label_01.setText(trackInfo.discNumber + "");
        label_02.setText(trackInfo.trackCount + "");
        label_03.setText(trackInfo.trackNumber + "");
        label_04.setText(trackInfo.artistId + "");
        label_05.setText(trackInfo.trackId + "");
        label_06.setText(trackInfo.collectionId + "");
        info_00.setText(trackInfo.kind.substring(0, 1).toUpperCase() + trackInfo.kind.substring(1));
        info_01.setText(trackInfo.primaryGenreName);
        info_02.setText(trackInfo.collectionName);
        info_03.setText(trackInfo.trackName);

        // Rounding the minutes to two decimal places
        double minuteCount = (trackInfo.trackTimeMillis / 60000.00);
        minuteCount = Math.round(minuteCount * 100);
        minuteCount = minuteCount / 100;
        info_04.setText(minuteCount + " " + getString(R.string.duration_var));
        info_05.setText(trackInfo.releaseDate.substring(5,7) + "/"
                + trackInfo.releaseDate.substring(8,10) + "/"
                + trackInfo.releaseDate.substring(0,4));
    }

    // To Artist via Internet
    public void onArtistLink(View v) {
        Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(trackInfo.artistViewUrl));
        startActivity(browseIntent);
    }

    // To Collection via Internet
    public void onCollectionLink(View v) {
        Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(trackInfo.collectionViewUrl));
        startActivity(browseIntent);
    }

    // To Track via Internet
    public void onTrackLink(View v) {
        Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(trackInfo.trackViewUrl));
        startActivity(browseIntent);
    }

    // To Track Sample via Internet
    public void onSampleLink(View v) {
        Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(trackInfo.previewUrl));
        startActivity(browseIntent);
    }

    // Custom Back Button is pressed
    public void onBackButton(View v) {
        finish();
    }

}
