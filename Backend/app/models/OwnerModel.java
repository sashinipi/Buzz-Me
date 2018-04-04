package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Model class for Owner.
 */

@Entity
@Table(name = "Owner", schema = "Buzz_Me")
public class OwnerModel extends Model {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false , name = "Owner_Id")
    private int ownerID;

    @Column(nullable = false , name = "Owner_Name")
    private String ownerName;

    @Column(nullable = false , name = "Owner_Contact_Number")
    private int mobileNumber;

    @Column(nullable = false , name = "Password")
    private String password;

    @Column(nullable = false , name = "Registration_Number")
    private String regNumber;

    @Column(nullable = false , name = "Time_Stamp")
    private Date timeStamp;

    //get and set all owner variables

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
