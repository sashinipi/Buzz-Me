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
     * @return             Success or fail status
     */
    MessageDTO addNewDriver(DriverDTO driverDTO);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    MessageDTO editDriver(DriverDTO driverDTO, int driverID);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    MessageDTO deleteDriver(DriverDTO driverDTO, int driverID);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    MessageDTO getBusbyId(DriverDTO driverDTO);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    MessageDTO loginDriver(DriverDTO driverDTO);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    MessageDTO startRideDriver(DriverDTO driverDTO);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    MessageDTO updateSpeedOfTheBus(DriverDTO driverDTO);

    DriverDTO getDriverByID(int driverID) throws Exception;
}
