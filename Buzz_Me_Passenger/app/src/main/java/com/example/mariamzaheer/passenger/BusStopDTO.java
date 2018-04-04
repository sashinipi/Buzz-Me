package com.example.mariamzaheer.passenger;

/**
 * Created by MariamZaheer on 3/31/18.
 */

public class BusStopDTO {

    private int busStopID;
    private String longitude;
    private String latitude;
    private String busStopName;
    private String routeDirection;

    public int getBusStopID() {
        return busStopID;
    }

    public void setBusStopID(int busStopID) {
        this.busStopID = busStopID;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

    public String getRouteDirection() {
        return routeDirection;
    }

    public void setRouteDirection(String routeDirection) {
        this.routeDirection = routeDirection;
    }
}
