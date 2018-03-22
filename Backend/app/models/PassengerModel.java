package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Model class representing a passenger.
 *
 */
@Entity
@Table(name = "Passenger", schema = "Buzz_Me")
public class PassengerModel extends Model {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false , name = "Passenger_Id")
    private int passengerID;

    @Column(nullable = false , name = "Passenger_Name")
    private String passengerName;

    @Column(nullable = false , name = "Passenger_Contact_Number")
    private int mobileNumber;

    @Column(nullable = false , name = "Password")
    private String password;

    @Column(nullable = false , name = "Time_Stamp")
    private Date timeStamp;

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
