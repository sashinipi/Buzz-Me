package service.driver;

/**
 * Created by Sashinip on 3/24/2018.
 */

import dto.DriverDTO;
import dto.MessageDTO;

/**
 * Interface defining driver related calls.
 *
 */


public interface DriverService {

    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Status
     */
    MessageDTO addNewDriver(DriverDTO driverDTO);


    /**
     * Edit driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Status
     */
    MessageDTO editDriver(DriverDTO driverDTO, int driverID);


    /**
     * Delete driver.
     *
     * @param driverID DTO containing passenger information
     * @return             Status
     */
    MessageDTO deleteDriver(int driverID);


    /**
     * get Bus by ID.
     *
     * @param busID DTO containing passenger information
     * @return             Bus Details
     * @throws Exception
     */
    MessageDTO getBusbyId(int busID) throws Exception;


    /**
     * Login Driver
     *
     * @param driverDTO DTO containing passenger information
     * @return             Status
     */
    MessageDTO loginDriver(DriverDTO driverDTO);

    /**
     * Get Driver By ID
     * @param driverID
     * @return            Driver Details
     * @throws Exception
     */
    DriverDTO getDriverByID(int driverID) throws Exception;
}
