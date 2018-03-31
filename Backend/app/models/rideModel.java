package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sashinip on 3/25/2018.
 */
@Entity

@Table(name = "ride", schema = "Buzz_Me")
public class RideModel extends Model {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false , name = "Ride_id")
    private int rideID;

    @Column(nullable = false , name = "Bus_Id")
    private int busID;

    @Column(nullable = false , name = "People_Counter")
    private int peopleCounter;

    @Column(nullable = false , name = "Current_Location")
    private String location;

    @Column(nullable = false , name = "Current_Speed")
    private String speed;

    @Column(nullable = false , name = "time_stamp")
    private Date timeStamp;

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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getPeopleCounter() {
        return peopleCounter;
    }

    public void setPeopleCounter(int peopleCounter) {
        this.peopleCounter = peopleCounter;
    }
}
