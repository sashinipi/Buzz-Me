package dao.passenger;

import models.PassengerModel;

/**
 * Interface defining calls to the passenger DAO.
 *
 */
public interface PassengerDao {

    /**
     * Add a new passenger.
     *
     * @param passengerModel Model containing the details of the new passenger
     * @return               Passenger ID
     * @throws Exception     Exception to throw
     */
    int addNewPassenger(PassengerModel passengerModel) throws Exception;

    /**
     * Retrieve passenger by ID.
     *
     * @param passengerID ID of passenger
     * @return            Passenger model
     * @throws Exception  Exception to throw
     */
    PassengerModel getPassengerByID(int passengerID) throws Exception;

    /**
     * Update a passenger.
     *
     * @param passengerModel Model containing the details of the passenger to be updated
     * @throws Exception     Exception to throw
     */
    void updatePassenger(PassengerModel passengerModel) throws Exception;

    /**
     * Delete passenger.
     *
     * @param passengerModel Model containing the details of the passenger to be deleted
     * @throws Exception     Exception to throw
     */
    void removePassenger(PassengerModel passengerModel) throws Exception;
}
