package com.example.mariamzaheer.passenger;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Activity class which represents the sign up page.
 */
public class SignUp extends AppCompatActivity {

    private String url = "http://192.168.43.25:9000//passenger/getPassengerByID/1";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private JSONObject jsonObject;
    private OkHttpClient okHttpClient;
    private EditText editTextName;

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

                editTextName = findViewById(R.id.nameEditText);
                final String name = editTextName.getText().toString();

                EditText mobileNumberEditText = findViewById(R.id.mobileNumberEditText);
                final String mobileNumber = mobileNumberEditText.getText().toString();

                EditText reEnterPasswordEditText = findViewById(R.id.reEnterPasswordEditText);
                final String password = reEnterPasswordEditText.getText().toString();

                jsonObject = new JSONObject();
                try {
                    jsonObject.put("name", name);
                    jsonObject.put("mobileNumber", mobileNumber);
                    jsonObject.put("password", password);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        getWebService();
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {

                    }
                };



                asyncTask.execute();


//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {

//                        getWebService();

////                        RequestBody requestBody = new FormEncodingBuilder()
//                        RequestBody requestBody = RequestBody.create(JSON, jsonObject.toString());
////                                .add("name", name)
////                                .add("mobileNumber", mobileNumber)
////                                .add("password", password)
////                                .build();
//
//                        Request request = new Request.Builder()
//                                .url(url)
//                                .post(requestBody)
//                                .build();
//
//                        OkHttpClient okHttpClient = new OkHttpClient();
//                        okHttpClient.setConnectTimeout(2, TimeUnit.MINUTES);
//                        okHttpClient.setReadTimeout(2, TimeUnit.SECONDS);
//
//                        try {
//                            Response response = okHttpClient.newCall(request).execute();
//                            String string = response.body().string();
//
//
//                            if (response.message().equals("OK")) {
//                                String toString = response.body().string();
//                                Log.d("==============1", response.message());
//                                ifSuccess();
//                            } else {
//                                Log.d("==============2", response.message());
//                                ifFail();
//                            }
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });

//                thread.start();
            }
        });

        okHttpClient = new OkHttpClient();
    }

    private Response getWebService() {
        final Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ifFail();
                    }
                });
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            editTextName.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        return null;
    }

    private void ifSuccess() {
        // Display success message.
        Toast.makeText(getApplicationContext(),
                "You have successfully signed up!",
                Toast.LENGTH_LONG).show();


        // Shift to mood selecting page.
        Intent moodSelectIntent = new Intent(SignUp.this, MoodSelect.class);
        startActivity(moodSelectIntent);
    }

    private void ifFail() {
        AlertDialog alertDialog = new AlertDialog.Builder(SignUp.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Sign up failed! Please try again.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }
}

