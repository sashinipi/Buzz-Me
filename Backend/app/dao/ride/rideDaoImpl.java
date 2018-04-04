package dao.ride;

import io.ebean.Ebean;
import models.RideModel;
import play.Logger;

/**
 * Created by Sashinip on 3/25/2018.
 */
public class RideDaoImpl implements RideDao {

    /**
     * Start Ride
     * @param rideModel
     * @return RideID
     * @throws Exception
     */
    @Override
    public int startRide(RideModel rideModel) throws Exception {
        try {
            rideModel.save();
            return rideModel.getRideID();
        } catch (Exception e) {
            Logger.error("Failed to add the passenger" + e);
            throw new Exception("Failed to add the passenger");
        }
    }

    /**
     * Update Speed
     * @param rideModel
     * @throws Exception
     */
    @Override
    public void updateSpeed(RideModel rideModel) throws Exception {
        try {
            rideModel.update();
        } catch (Exception e) {
            Logger.error("Failed to update the passenger" + e);
            throw new Exception("Failed to update the passenger");
        }
    }

    /**
     * Update Location
     * @param rideModel
     * @throws Exception
     */
    @Override
    public void updateLocation(RideModel rideModel) throws Exception {
        try {
            rideModel.update();
        } catch (Exception e) {
            Logger.error("Failed to update the passenger" + e);
            throw new Exception("Failed to update the passenger");
        }
    }

    /**
     * Update PeopleCounter
     * @param rideModel
     * @throws Exception
     */
    @Override
    public void updateNoOfPeople(RideModel rideModel) throws Exception {
        try {
            rideModel.update();
        } catch (Exception e) {
            Logger.error("Failed to update the passenger" + e);
            throw new Exception("Failed to update the passenger");
        }
    }

    /**
     * Shoe Rating
     * @param rideModel
     * @return
     * @throws Exception
     */
    @Override
    public String showRating(RideModel rideModel) throws Exception {
        return null;
    }

    /**
     * Get Ride Details
     * @param rideID
     * @return RideModel
     * @throws Exception
     */
    @Override
    public RideModel getRideByID(int rideID) throws Exception {
        try {
            return Ebean.find(RideModel.class, rideID);
        } catch (Exception e) {
            Logger.error("Failed to get passenger by ID " + e);
            throw new Exception("Failed to get passenger by ID");
        }
    }


}