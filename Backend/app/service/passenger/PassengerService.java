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

    /**
     * Edit an existing passenger.
     *
     * @param passengerDTO DTO containing passenger information
     * @param passengerID  ID of passenger to be updated
     * @return             Message DTO containing the status
     */
    MessageDTO updatePassenger(PassengerDTO passengerDTO, int passengerID);

    /**
     * Delete an existing passenger.
     *
     * @param passengerID  ID of passenger to be deleted
     * @return             Message DTO containing the status
     */
    MessageDTO removePassenger(int passengerID);

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

    /**
     * Retrieve filtered recommended buses.
     *
     * @param mood        Mood of the passenger
     * @param destination Destination
     * @return            List of bus recommendations
     */
    List<RecommendedBusDTO> getRecommendedBuses(String mood, String destination);
}
