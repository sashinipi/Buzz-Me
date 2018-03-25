package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sashinip on 3/25/2018.
 */

@Entity
@Table(name = "driver", schema = "Buzz_Me")
public class DriverModel extends Model{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false , name = "Driver_Id")
    private int id;

    @Column(nullable = false , name = "Driver_Name")
    private String name;

    @Column(nullable = false , name = "Driver_NIC")
    private String NICNumber;

    @Column(nullable = false , name = "Driver_address")
    private String address;

    @Column(nullable = false , name = "driver_password")
    private String password;

    @Column(nullable = false , name = "time_stamp")
    private Date timeStamp;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNICNumber() {
        return NICNumber;
    }

    public void setNICNumber(String NICNumber) {
        this.NICNumber = NICNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
