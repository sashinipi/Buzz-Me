package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Model class representing rating.
 */
@Entity
@Table(name = "Rating", schema = "Buzz_Me")
public class RatingModel extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "Rating_Id")
    private int ratingID;

    @Column(nullable = false, name = "Rating")
    private int rating;

    @Column(nullable = false, name = "Bus_ID") // TODO: Should be FK. Fix after bus tables comes.
    private int busID;

    @Column(nullable = false, name = "Count")
    private int count;

    @Column(nullable = false, name = "Time_Stamp")
    private Date timeStamp;

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}

