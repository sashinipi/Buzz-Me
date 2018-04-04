package com.buzz_me.sashinip.buzz_me_driver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sashinip on 3/26/2018.
 */
public class DataParser {

    private HashMap<String, String> getPlace(JSONObject googlePlacesJsonObject){

        HashMap<String, String> googlePlacesMap = new HashMap<>();

        String placeName = "-NA-";
        String vicinity = "-NA-";
        String latitude = "";
        String longitude = "";
        String reference = "";

        try {
            if (!googlePlacesJsonObject.isNull("name")){

                    placeName = googlePlacesJsonObject.getString("name");
            }
            if (!googlePlacesJsonObject.isNull("vicinity")){

                vicinity = googlePlacesJsonObject.getString("vicinity");
            }

            latitude = googlePlacesJsonObject.getJSONObject("geometry").getJSONObject("locationn").getString("lat");
            longitude = googlePlacesJsonObject.getJSONObject("geometry").getJSONObject("locationn").getString("long");

            reference = googlePlacesJsonObject.getString("reference");

            googlePlacesMap.put("place_name", placeName);
            googlePlacesMap.put("vicinity", vicinity);
            googlePlacesMap.put("latitude", latitude);
            googlePlacesMap.put("longitude", longitude);
            googlePlacesMap.put("reference", reference);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return googlePlacesMap;
    }

    private List<HashMap<String, String>> getPlaces(JSONArray jsonArray){

        int count = jsonArray.length();
        List<HashMap<String, String>> placesList = new ArrayList<>();
        HashMap<String, String> placeMap = null;

        for (int i = 0; i<count;i++){
            try {
                placeMap = getPlace((JSONObject) jsonArray.get(i));
                placesList.add(placeMap);
            } catch (JSONException e){
                e.printStackTrace();
            }
        }

        return placesList;
    }

    public List<HashMap<String ,String >> parse(String jsonData){

        JSONArray jsonArray = null;
        JSONObject jsonObject;

        try {
            jsonObject = new JSONObject(jsonData);
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return getPlaces(jsonArray);
    }
}
