package com.buzz_me.sashinip.buzz_me_driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    TextView lblNavigateToSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnDriverLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginToStartPage = new Intent(LoginActivity.this, StartRideActivity.class);
                startActivity(LoginToStartPage);
            }
        });

        lblNavigateToSignUp = (TextView) findViewById(R.id.lblDriverSignUp);

        lblNavigateToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginToSignUp = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(loginToSignUp);
            }
        });
    }
}
