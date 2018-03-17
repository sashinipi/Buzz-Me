package com.example.mariamzaheer.passenger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.net.URI;

/**
 * Activity displaying the screen to enter the destination.
 *
 */
public class Destination extends AppCompatActivity {

    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);



        SearchView destinationSearchView = (SearchView) findViewById(R.id.destinationSearchView);
        destinationSearchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int i) {
                return false;
            }

            @Override
            public boolean onSuggestionClick(int i) {
                // Shift to the next page.
                Intent mapsIntent = new Intent(Destination.this, MapsActivity.class);
                startActivity(mapsIntent);
                return true;
            }
        });
    }
}
