package com.example.spectrum.tuneseq;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.spectrum.tuneseq.AppFunctions.AppConnect;
import com.example.spectrum.tuneseq.AppFunctions.AsyncTaskSearch;
import com.example.spectrum.tuneseq.AppObjects.TrackInfo;

import java.util.ArrayList;

public class SearchScreen extends Activity {

    // Variables of the Activity
    public String jsonURL = "https://itunes.apple.com/search?term=";
    public String jsonURLFix = "https://itunes.apple.com/search?term=Michael+jackson";

    public AppConnect searchConnect;
    public Context context;
    public ListView list_000;
    public ArrayList<TrackInfo> trackListing;
    public EditText editText_00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);

        context = this;
        trackListing = new ArrayList<>();
        searchConnect = new AppConnect(context);
        list_000 = (ListView) findViewById(R.id.listView_00);
        editText_00 =  (EditText) findViewById(R.id.edittext_00);
    }

    // Search for the fixed results of the given artist
    public void onSearch(View v) {

        // Checks for Internet Connection
        if(!searchConnect.connectionAvailable()) {
            Toast.makeText(this, getResources().getString(R.string.connect_001), Toast.LENGTH_SHORT).show();
            return;
        }

        // Gets the user's query
        String seekQuery = editText_00.getText().toString().trim();

        // Checks for empty query
        if(seekQuery.equals("")) {
            Toast.makeText(this, getResources().getString(R.string.search_empty), Toast.LENGTH_SHORT).show();
            return;
        }

        seekQuery = seekQuery.replace(' ', '+');

        // Execute Asynchronous Task
        AsyncTaskSearch seeker = new AsyncTaskSearch(context, list_000);
        // seeker.execute(jsonURLFix);
        seeker.execute(jsonURL + seekQuery);
        trackListing = seeker.getTracksFound();
    }

}
