package com.example.mariamzaheer.passenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Activity class which represents the sign up page.
 *
 */
public class SignUp extends AppCompatActivity {

    /**
     * Specifies all required methods on create.
     *
     * @param savedInstanceState Saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Sign up button on click.
        Button signUp = findViewById(R.id.signupButton);
        signUp.setOnClickListener(new View.OnClickListener() {

            // TODO: Add validation.
            @Override
            public void onClick(View view) {

                // Display success message.
                Toast.makeText(getApplicationContext(),
                        "You have successfully signed up!",
                        Toast.LENGTH_LONG).show();

                // Shift to mood selecting page.
                Intent moodSelectIntent = new Intent(SignUp.this, MoodSelect.class);
                startActivity(moodSelectIntent);
            }
        });
    }
}
