package dao.passenger;

import io.ebean.Ebean;
import models.PassengerModel;
import play.Logger;

/**
 * Implementation of the calls to the passenger DAO.
 *
 */
public class PassengerDaoImpl implements PassengerDao {

    /**
     * Add a new passenger.
     *
     * @param passengerModel Model containing the details of the new passenger
     * @return               Passenger ID
     * @throws Exception     Exception to throw
     */
    @Override
    public int addNewPassenger(PassengerModel passengerModel) throws Exception {
        try {
            passengerModel.save();
            return passengerModel.getPassengerID();
        } catch (Exception e) {
            Logger.error("Failed to add the passenger" + e);
            throw new Exception("Failed to add the passenger");
        }
    }

    /**
     * Retrieve passenger by ID.
     *
     * @param passengerID ID of passenger
     * @return            Passenger model
     * @throws Exception  Exception to throw
     */
    @Override
    public PassengerModel getPassengerByID(int passengerID) throws Exception {
        try {
            return Ebean.find(PassengerModel.class, passengerID);
        } catch (Exception e) {
            Logger.error("Failed to get passenger by ID " + e);
            throw new Exception("Failed to get passenger by ID");
        }
    }

    /**
     * Update a passenger.
     *
     * @param passengerModel Model containing the details of the passenger to be updated
     * @throws Exception     Exception to throw
     */
    @Override
    public void updatePassenger(PassengerModel passengerModel) throws Exception {
        try {
            passengerModel.update();
        } catch (Exception e) {
            Logger.error("Failed to update the passenger" + e);
            throw new Exception("Failed to update the passenger");
        }
    }

    /**
     * Delete passenger.
     *
     * @param passengerModel Model containing the details of the passenger to be deleted
     * @throws Exception     Exception to throw
     */
    @Override
    public void removePassenger(PassengerModel passengerModel) throws Exception {
        try {
            passengerModel.delete();
        } catch (Exception e) {
            Logger.error("Failed to delete the passenger" + e);
            throw new Exception("Failed to delete the passenger");
        }
    }
}
