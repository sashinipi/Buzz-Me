package dao.ride;

import models.RideModel;

/**
 * Created by Sashinip on 3/25/2018.
 */

public interface RideDao {

    /**
     * Start Ride
     * @param rideModel
     * @return RideModel
     * @throws Exception
     */
    int startRide(RideModel rideModel) throws Exception;

    /**
     * Update Speed
     * @param rideModel
     * @throws Exception
     */
    void updateSpeed(RideModel rideModel) throws Exception;

    /**
     * Update Location
     * @param rideModel
     * @throws Exception
     */
    void updateLocation(RideModel rideModel) throws Exception;

    /**
     * Update PeopleCounter
     * @param rideModel
     * @throws Exception
     */
    void updateNoOfPeople(RideModel rideModel) throws Exception;

    /**
     * Show Rating
     * @param rideModel
     * @return
     * @throws Exception
     */
    String showRating(RideModel rideModel) throws Exception;

    /**
     * Get Ride Details
     * @param rideID
     * @return
     * @throws Exception
     */
    RideModel getRideByID(int rideID) throws Exception;



}
