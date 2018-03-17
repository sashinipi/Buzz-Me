package com.buzz_me.sashinip.buzz_me_driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartRideActivity extends AppCompatActivity {

    Button btnDriverStartRide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ride);

        btnDriverStartRide = (Button) findViewById(R.id.btnDriverStartRide);

        btnDriverStartRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startRideToDuringRide = new Intent(StartRideActivity.this, DuringRideActivity.class);
                startActivity(startRideToDuringRide);


            }
        });
    }
}
