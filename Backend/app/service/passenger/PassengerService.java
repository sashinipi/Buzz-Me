package service.passenger;

import dto.MessageDTO;
import dto.PassengerDTO;
import dto.PassengerIDDTO;
import dto.RecommendedBusDTO;

import java.util.List;

/**
 * Interface defining passenger related calls.
 *
 */
public interface PassengerService {

    /**
     * Add a new passenger.
     *
     * @param passengerDTO DTO containing passenger information
     * @return             Message DTO containing the status and the passenger ID
     */
    MessageDTO addNewPassenger(PassengerDTO passengerDTO);
    // TODO : HCI - When the proper data are note given
    // TODO : Security - Handling the passwords and mobile numbers

    /**
     * Edit an existing passenger.
     *
     * @param passengerDTO DTO containing passenger information
     * @param passengerID  ID of passenger to be updated
     * @return             Message DTO containing the status
     */
    MessageDTO updatePassenger(PassengerDTO passengerDTO, int passengerID);
    // TODO : HCI - When the proper data are note given
    // TODO : Security - Handling the passwords and mobile numbers

    /**
     * Delete an existing passenger.
     *
     * @param passengerID  ID of passenger to be deleted
     * @return             Message DTO containing the status
     */
    MessageDTO removePassenger(int passengerID);
    // TODO : Security - If the passenger wishes he will be completely removed from the system

    /**
     * Retrieve passenger by ID.
     *
     * @param passengerID ID of passenger to be retrieved
     * @return            Passenger DTO
     * @throws Exception  Exception to throw
     */
    PassengerDTO getPassengerById(int passengerID) throws Exception;

    /**
     * Verify passenger.
     *
     * @param passengerIDDTO DTO containing passenger information
     * @return               Message DTO containing the status
     */
    MessageDTO verifyPassenger(PassengerIDDTO passengerIDDTO);
    // TODO : HCI - Provide necessary error messages if the passenger cannot be verified

    /**
     * Retrieve filtered recommended buses.
     *
     * @param mood        Mood of the passenger
     * @param destination Destination
     * @return            List of bus recommendations
     */
    List<RecommendedBusDTO> getRecommendedBuses(String mood, String destination);
}
