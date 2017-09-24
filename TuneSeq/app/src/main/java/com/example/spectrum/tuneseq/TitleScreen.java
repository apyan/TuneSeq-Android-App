package com.example.spectrum.tuneseq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TitleScreen extends Activity {

    // Variables of the Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
    }

    // Proceed to the Search Screen
    public void onProceed(View v) {
        Intent eIntent = new Intent(this, SearchScreen.class);
        startActivity(eIntent);
    }

    // Proceed to the Kotlin version
    public void onKotlinProceed(View v) {

        // Announcement on Update
        //Toast.makeText(this, getResources().getString(R.string.app_update), Toast.LENGTH_SHORT).show();

        Intent eIntent = new Intent(this, KtlnSearchScreen.class);
        startActivity(eIntent);
    }
}
