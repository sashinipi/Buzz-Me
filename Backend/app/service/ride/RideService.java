package service.ride;

import dto.DriverDTO;
import dto.MessageDTO;
import dto.RideDTO;

/**
 * Created by Sashinip on 3/25/2018.
 */
public interface RideService {

    /**
     * Start new Ride
     * @param rideDTO
     * @return
     */
    MessageDTO startRide(RideDTO rideDTO);

    /**
     * Update speed of each ride
     * @param rideDTO
     * @param rideID
     * @param speed
     * @return
     */
    MessageDTO updateSpeed(RideDTO rideDTO, int rideID, String speed);

    /**
     * Update location of each ride
     * @param rideDTO
     * @param rideID
     * @param location
     * @return
     */
    MessageDTO updateLocation(RideDTO rideDTO, int rideID, String location);

    /**
     * Update no of people of each ride
     * @param rideDTO
     * @param rideID
     * @param location
     * @return
     */
    MessageDTO updateNoOfPeople(RideDTO rideDTO, int rideID, String location);

    /**
     * Show Rating
     * @param rideDTO
     * @param driverID
     * @return
     */
    MessageDTO showRating(RideDTO rideDTO, int driverID);

    /**
     * Get Ride By ID
     * @param driverID
     * @return            Driver Details
     * @throws Exception
     */
    RideDTO getRideByID(int driverID) throws Exception;
}
