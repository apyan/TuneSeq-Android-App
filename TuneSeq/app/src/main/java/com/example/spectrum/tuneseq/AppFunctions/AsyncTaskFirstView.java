package com.example.spectrum.tuneseq.AppFunctions;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.spectrum.tuneseq.AppObjects.BitmapObject;
import com.example.spectrum.tuneseq.AppObjects.TrackInfo;
import com.example.spectrum.tuneseq.R;

/**
 * Asynchronous Task for the start View
 */

public class AsyncTaskFirstView  extends AsyncTask<String, String, String> {

    // Variables of the Asynchronous Task
    private String errorMessage = "";
    TrackInfo trackInfo;
    Context eContext;
    ProgressDialog progressDialog;
    ImageView image_00;

    // Constructor
    public AsyncTaskFirstView(Context context, TrackInfo ti, ImageView imageView) {
        eContext = context;
        trackInfo = ti;
        image_00 = imageView;

    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(eContext,
                eContext.getResources().getString(R.string.loading_002),
                eContext.getResources().getString(R.string.loading_003));
    }

    @Override
    protected String doInBackground(String... params) {

        // Download needed contents
        BitmapObject bitmapObject = new BitmapObject();
        trackInfo.artIcon = bitmapObject.getBitmapFromURL(trackInfo.artworkUrl100);
        trackInfo.artIcon = bitmapObject.getResizedBitmap(trackInfo.artIcon, 100, 100);

        return errorMessage;
    }

    @Override
    protected void onPostExecute(String args) {

        image_00.setImageBitmap(trackInfo.artIcon);

        // Dismiss Progress Dialog
        progressDialog.dismiss();
    }

}
