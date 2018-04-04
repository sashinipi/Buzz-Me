package dto;

import java.util.Date;

/**
 * Created by Sashinip on 3/25/2018.
 */
public class RideDTO {

    private int rideID;
    private int busID;
    private String location;
    private String speed;
    private String peopleCounter;

    public int getRideID() {
        return rideID;
    }

    public void setRideID(int rideID) {
        this.rideID = rideID;
    }

    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPeopleCounter() {
        return peopleCounter;
    }

    public void setPeopleCounter(String peopleCounter) {
        this.peopleCounter = peopleCounter;
    }
}