package service.passenger;

import com.google.inject.Inject;
import dao.passenger.PassengerDao;
import dto.MessageDTO;
import dto.PassengerDTO;
import dto.PassengerIDDTO;
import dto.RatingDTO;
import io.ebean.Ebean;
import models.PassengerModel;

import java.util.Date;

/**
 * Implementation of passenger service.
 *
 */
public class PassengerServiceImpl implements PassengerService {

    private final PassengerDao passengerDao;

    @Inject
    public PassengerServiceImpl(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    /**
     * Add a new passenger.
     *
     * @param passengerDTO DTO containing passenger information
     * @return             Message DTO containing the status and the passenger ID
     */
    @Override
    public MessageDTO addNewPassenger(PassengerDTO passengerDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            PassengerModel passengerModel = new PassengerModel();
            passengerModel.setPassengerName(passengerDTO.getName());
            passengerModel.setMobileNumber(passengerDTO.getMobileNumber());
            passengerModel.setPassword(passengerDTO.getPassword());
            passengerModel.setTimeStamp(new Date());

            int passengerID = passengerDao.addNewPassenger(passengerModel);
            messageDTO.setId(passengerID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            messageDTO.setMessage("Fail");
        }
        return messageDTO;
    }

    /**
     * Edit an existing passenger.
     *
     * @param passengerDTO DTO containing passenger information
     * @param passengerID  ID of passenger to be updated
     * @return             Message DTO containing the status
     */
    @Override
    public MessageDTO updatePassenger(PassengerDTO passengerDTO, int passengerID) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            Ebean.beginTransaction();

            PassengerModel passengerByID = passengerDao.getPassengerByID(passengerID);

            passengerByID.setPassengerName(passengerDTO.getName());
            passengerByID.setMobileNumber(passengerDTO.getMobileNumber());
            passengerByID.setPassword(passengerDTO.getPassword());
            passengerByID.setTimeStamp(new Date());

            passengerDao.updatePassenger(passengerByID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            Ebean.rollbackTransaction();
            messageDTO.setMessage("Fail");
        }
        return messageDTO;
    }

    /**
     * Delete an existing passenger.
     *
     * @param passengerID  ID of passenger to be deleted
     * @return             Message DTO containing the status
     */
    @Override
    public MessageDTO removePassenger(int passengerID) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            PassengerModel passengerByID = passengerDao.getPassengerByID(passengerID);
            passengerDao.removePassenger(passengerByID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            messageDTO.setMessage("Fail");
        }

        return messageDTO;
    }

    /**
     * Retrieve passenger by ID.
     *
     * @param passengerID ID of passenger to be retrieved
     * @return            Passenger DTO
     * @throws Exception  Exception to throw
     */
    @Override
    public PassengerDTO getPassengerById(int passengerID) throws Exception {
        PassengerDTO passengerDTO = new PassengerDTO();

        PassengerModel passengerByID = passengerDao.getPassengerByID(passengerID);

        passengerDTO.setName(passengerByID.getPassengerName());
        passengerDTO.setMobileNumber(passengerByID.getMobileNumber());
        return passengerDTO;
    }

    /**
     * Verify passenger.
     *
     * @param passengerIDDTO DTO containing passenger information
     * @return               Message DTO containing the status
     */
    @Override
    public MessageDTO verifyPassenger(PassengerIDDTO passengerIDDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            PassengerModel passengerByID = passengerDao.getPassengerByID(passengerIDDTO.getId());

            if (passengerIDDTO.getName().equals(passengerByID.getPassengerName())) {
                if (passengerIDDTO.getPassword().equals(passengerByID.getPassword())) {
                    messageDTO.setMessage("User is verified");

                } else {
                    messageDTO.setMessage("Password does not match");

                }
            } else  {
                messageDTO.setMessage("User name does not match");
            }

        } catch (Exception e) {
            messageDTO.setMessage("An error occurred during verification");
        }
        return messageDTO;
    }

    /**
     * Update the rating.
     *
     * @param ratingDTO DTO containing rating information
     * @return          Message DTO containing the status
     */
    @Override
    public MessageDTO updateRating(RatingDTO ratingDTO) {
        return null;
    }
}
