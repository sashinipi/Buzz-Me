package com.example.mariamzaheer.passenger;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Activity class which represents the mood select page.
 *
 */
public class MoodSelect extends AppCompatActivity {

    private String selection;

    /**
     * Specifies all required methods on create.
     *
     * @param savedInstanceState Saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_select);

        // Happy face on click.
        ImageView happyFace = findViewById(R.id.happyImageView);
        happyFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selection = "happy";
                // Shift to the next page.
                Intent mapsIntent = new Intent(MoodSelect.this, MapsActivity.class);
                startActivity(mapsIntent);
            }
        });

        // Unamused face on click.
        ImageView unAmusedFace = findViewById(R.id.unamusedImageView);
        unAmusedFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selection = "unamused";

                // Shift to the next page.
                Intent mapsIntent = new Intent(MoodSelect.this, Destination.class);
                startActivity(mapsIntent);
            }
        });
    }
}
