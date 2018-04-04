package com.example.mariamzaheer.passenger;

import android.Manifest;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Class representing the map screen.
 *
 */
public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private EditText currentEditText;
    private AutoCompleteTextView destinationAutoComplete;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private Object destination;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Get the bus stops.
        ArrayList<String> busStops = getBusStops();

        destinationAutoComplete = findViewById(R.id.destinationAutoComplete);
        destinationAutoComplete.setThreshold(1);
        destinationAutoComplete.setHint("Enter destination");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, busStops);
        destinationAutoComplete.setAdapter(adapter);

        destinationAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                destination = destinationAutoComplete.getAdapter().getItem(position);
            }
        });

        currentEditText = (EditText) findViewById(R.id.currentEditText);

        // Happy face on click.
        ImageView path = findViewById(R.id.path);
        path.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (destination != null) {
                    // Shift to the page showing the closest bus stop.
                    Intent closestBusStopIntent = new Intent(MapsActivity.this, ClosestBusStop.class);
                    // Pass the names of the current and destination locations.
                    closestBusStopIntent.putExtra("Current", currentEditText.getText().toString());
                    closestBusStopIntent.putExtra("Destination", destination.toString());

                    // Get latlang for the bus stop name.
                    LatLng destinationLatLang = getDestinationLatLang(destination.toString());

                    // Add them to a bundle.
                    Bundle args = new Bundle();
                    args.putParcelable("CurrentLatLong", location);
                    args.putParcelable("DestinationLatLong", destinationLatLang);

                    // Pass them via the intent.
                    closestBusStopIntent.putExtra("Location", args);
                    startActivity(closestBusStopIntent);

                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(MapsActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Enter the destination.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        // Show the current device location.
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {

            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION }, 0);
        }

        // Zoom to current location.
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        if (location != null) {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 13));

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(location.getLatitude(), location.getLongitude())) // Sets the center of the map to location user
                    .zoom(15) // Sets the zoom
                    .build(); // Creates a CameraPosition from the builder
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            // Get the current location from the latitude and longitude and display the location name.
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                String currentLocation = addresses.get(0).getAddressLine(0);

                // Make the search view text visible on load.
//                currentSearchView.setIconified(false);
                // Set the current location.
                currentEditText.setText(currentLocation);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void hideKeyboard() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * Iterate the JSON file and get all the bus stops.
     *
     * @return Array list containing all the bus stops.
     */
    private ArrayList<String> getBusStops() {
        ArrayList<String> busStops = new ArrayList<>();

        try {
            InputStream inputStream = getAssets().open("busStops.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String bus_stop_name = jsonObject.getString("Bus_Stop_Name");
                busStops.add(bus_stop_name);
            }

        } catch (IOException e) {
            Log.d("", "Couldn't open file");
        } catch (JSONException e) {
            Log.d("", "Couldn't parse json file");
        }

        return busStops;
    }

    /**
     * Method to convert to bus stop name to lat lang.
     *
     * @param busStopName Bus stop name
     * @return            LatLang value
     */
    private LatLng getDestinationLatLang(String busStopName) {
        try {
            InputStream inputStream = getAssets().open("busStops.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                if (jsonObject.optString("Bus_Stop_Name").equals(busStopName)) {
                    Double latitude = Double.parseDouble(jsonObject.optString("Lat"));
                    Double longitude = Double.parseDouble(jsonObject.optString("Long"));
                    return new LatLng(latitude, longitude);
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public void handle(View view) {
//        Fragment selectedFragment;
//
//        if (view == findViewById(R.id.path)) {
//            selectedFragment = new ClosestBusStop();
//            fragmentManager = getFragmentManager();
//            fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.map, selectedFragment);
//            fragmentTransaction.commit();
//        }
//    }
}
