package service.ride;

import dao.ride.RideDao;
import dto.DriverDTO;
import dto.MessageDTO;
import dto.PassengerDTO;
import dto.RideDTO;
import io.ebean.Ebean;
import models.PassengerModel;
import models.RideModel;

import java.util.Date;

/**
 * Created by Sashinip on 3/25/2018.
 */
public class RideServiceImpl implements RideService {

    private final RideDao rideDao;

    public RideServiceImpl(RideDao passengerDao, RideDao rideDao) {
        this.rideDao = rideDao;
    }

    /**
     * Start Ride
     * @param rideDTO
     * @return Status
     */
    @Override
    public MessageDTO startRide(RideDTO rideDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            RideModel rideModel = new RideModel();
            rideModel.setBusID(rideDTO.getBusID());
            rideModel.setLocation(rideDTO.getLocation());
            rideModel.setSpeed(rideDTO.getSpeed());
            rideModel.setPeopleCounter(Integer.parseInt(rideDTO.getPeopleCounter()));
            rideModel.setTimeStamp(new Date());

            int rideID = rideDao.startRide(rideModel);
            messageDTO.setId(rideID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            messageDTO.setMessage("Fail");
        }
        return messageDTO;
    }

    /**
     * Update Speed
     * @param rideDTO
     * @param rideID
     * @param speed
     * @return Status
     */
    @Override
    public MessageDTO updateSpeed(RideDTO rideDTO, int rideID, String speed) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            Ebean.beginTransaction();

            RideModel rideByID = rideDao.getRideByID(rideID);

            rideByID.setSpeed(rideDTO.getSpeed());
            rideByID.setTimeStamp(new Date());

            rideDao.updateSpeed(rideByID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            Ebean.rollbackTransaction();
            messageDTO.setMessage("Fail");
        }
        return messageDTO;
    }

    /**
     * Update Location
     * @param rideDTO
     * @param rideID
     * @param location
     * @return Status
     */
    @Override
    public MessageDTO updateLocation(RideDTO rideDTO, int rideID, String location) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            Ebean.beginTransaction();

            RideModel rideByID = rideDao.getRideByID(rideID);

            rideByID.setLocation(rideDTO.getLocation());
            rideByID.setTimeStamp(new Date());

            rideDao.updateLocation(rideByID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            Ebean.rollbackTransaction();
            messageDTO.setMessage("Fail");
        }
        return messageDTO;
    }

    /**
     * Update PeopleCounter
     * @param rideDTO
     * @param rideID
     * @param location
     * @return
     */
    @Override
    public MessageDTO updateNoOfPeople(RideDTO rideDTO, int rideID, String location) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            Ebean.beginTransaction();

            RideModel rideByID = rideDao.getRideByID(rideID);

            rideByID.setPeopleCounter(Integer.parseInt(rideDTO.getPeopleCounter()));
            rideByID.setTimeStamp(new Date());

            rideDao.updateNoOfPeople(rideByID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            Ebean.rollbackTransaction();
            messageDTO.setMessage("Fail");
        }
        return messageDTO;
    }

    /**
     * Show Rating
     * @param rideDTO
     * @param driverID
     * @return Status
     */
    @Override
    public MessageDTO showRating(RideDTO rideDTO, int driverID) {
        /*PassengerDTO passengerDTO = new PassengerDTO();

        PassengerModel passengerByID = passengerDao.getPassengerByID(passengerID);

        passengerDTO.setName(passengerByID.getPassengerName());
        passengerDTO.setMobileNumber(passengerByID.getMobileNumber());
        return passengerDTO;*/

        return null;
    }

    /**
     * Get Ride Details
     * @param rideID
     * @return
     * @throws Exception
     */
    @Override
    public RideDTO getRideByID(int rideID) throws Exception {
        RideDTO rideDTO = new RideDTO();

        RideModel rideByID = rideDao.getRideByID(rideID);

        rideDTO.setSpeed(rideByID.getSpeed());
        rideDTO.setLocation(rideByID.getLocation());
        rideDTO.setPeopleCounter(String.valueOf(rideByID.getPeopleCounter()));
        rideDTO.setBusID(rideByID.getBusID());
        return rideDTO;
    }
}