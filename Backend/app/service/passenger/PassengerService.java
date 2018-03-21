package service.passenger;

import dto.PassengerDTO;

/**
 * Interface defining passenger related calls.
 *
 */
public interface PassengerService {

    /**
     * Add a new passenger.
     *
     * @param passengerDTO DTO containing passenger information
     * @return             Success or fail status
     */
    String addNewPassenger(PassengerDTO passengerDTO);
}
