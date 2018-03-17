package com.example.mariamzaheer.passenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

/**
 * Main activity class which represents the log in page.
 *
 */
public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;

    /**
     * Specifies all required methods on create.
     *
     * @param savedInstanceState Saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = findViewById(R.id.toolBar);
//        setSupportActionBar(toolbar);

        // Login button on click.
        Button login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {

            // TODO: Add validation.
            @Override
            public void onClick(View view) {
                // Shift to mood selecting page.
                Intent moodSelectIntent = new Intent(MainActivity.this, MoodSelect.class);
                startActivity(moodSelectIntent);
            }
        });

        TextView textView = findViewById(R.id.signUpTextView);
        textView.setOnClickListener(new View.OnClickListener() {

            // Sign up button on click.
            @Override
            public void onClick(View view) {
                // Shift to sign up page.
                Intent signUpIntent = new Intent(MainActivity.this, SignUp.class);
                startActivity(signUpIntent);
            }
        });
    }


}
