package com.buzz_me.sashinip.buzz_me_driver;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_ACCOUNTS = 1;
    Button onecountDown;
    Button twologin;
    Button threesignup;
    Button fourstartride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grantPermissions();
        onecountDown = (Button) findViewById(R.id.btn1);
        twologin = (Button) findViewById(R.id.btn2);
        threesignup = (Button) findViewById(R.id.btn3);
        fourstartride = (Button) findViewById(R.id.btn4);

        onecountDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent one = new Intent(MainActivity.this, CountDownActivity.class);
                startActivity(one);
            }
        });

        twologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent two = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(two);
            }
        });

        threesignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent three = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(three);
            }
        });

        fourstartride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent four = new Intent(MainActivity.this, StartRideActivity.class);
                startActivity(four);
            }
        });
    }

    private boolean grantPermissions() {
        int locationPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int writeExtrnalPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int coarseLocationPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int netwrkStatusPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE);
        int internetPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        int readExternalPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        List<String> listPermissions = new ArrayList<>();

        if (locationPerm != PackageManager.PERMISSION_GRANTED) {
            listPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (writeExtrnalPerm != PackageManager.PERMISSION_GRANTED) {
            listPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (coarseLocationPerm != PackageManager.PERMISSION_GRANTED) {
            listPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (netwrkStatusPerm != PackageManager.PERMISSION_GRANTED) {
            listPermissions.add(Manifest.permission.ACCESS_NETWORK_STATE);
        }
        if (internetPerm != PackageManager.PERMISSION_GRANTED) {
            listPermissions.add(Manifest.permission.INTERNET);
        }
        if (readExternalPerm != PackageManager.PERMISSION_GRANTED) {
            listPermissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (!listPermissions.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissions.toArray(new String[listPermissions.size()]), PERMISSION_REQUEST_ACCOUNTS);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_ACCOUNTS) {
            if (!(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(this, "Permissions needed.Please grant in the APP Settings for additional functionality.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
