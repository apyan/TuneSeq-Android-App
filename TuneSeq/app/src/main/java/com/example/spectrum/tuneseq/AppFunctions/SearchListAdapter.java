package com.example.spectrum.tuneseq.AppFunctions;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spectrum.tuneseq.AppObjects.TrackInfo;
import com.example.spectrum.tuneseq.R;
import com.example.spectrum.tuneseq.ViewScreen;

import java.util.ArrayList;

/**
 * Adapter for the list view searching
 */

public class SearchListAdapter  extends BaseAdapter {

    // Variables for the adapter
    public static LayoutInflater inflater = null;
    public ArrayList<TrackInfo> foundedTracks;
    Context eContext;

    // Constructor
    public SearchListAdapter(Context context, ArrayList<TrackInfo> results){
        eContext = context;
        foundedTracks = results;
        inflater = (LayoutInflater) eContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return foundedTracks.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    // List Row Attributes
    public class RowAttributes {
        ImageView image_00;
        TextView text_00, text_01, text_02;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        RowAttributes rowAttributes= new RowAttributes();
        View rowView;

        rowView = inflater.inflate(R.layout.layout_listview_000, null);
        rowAttributes.image_00 = (ImageView) rowView.findViewById(R.id.image_000);
        rowAttributes.text_00 = (TextView) rowView.findViewById(R.id.text_000);
        rowAttributes.text_01 = (TextView) rowView.findViewById(R.id.text_001);
        rowAttributes.text_02 = (TextView) rowView.findViewById(R.id.text_002);

        // Set up the display information
        rowAttributes.image_00.setImageBitmap(foundedTracks.get(position).artIcon70);
        rowAttributes.text_00.setText(foundedTracks.get(position).trackCensoredName);
        rowAttributes.text_01.setText(foundedTracks.get(position).collectionCensoredName);
        rowAttributes.text_02.setText(foundedTracks.get(position).artistName);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                // Head to the viewing screen
                Intent eIntent = new Intent(eContext, ViewScreen.class);
                eIntent.putExtra("seekTrack", foundedTracks.get(position));
                v.getContext().startActivity(eIntent);
            }
        });
        return rowView;
    }

}
