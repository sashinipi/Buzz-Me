package service.driver;

/**
 * Created by Sashinip on 3/24/2018.
 */

import dto.DriverDTO;

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
    String addNewDriver(DriverDTO driverDTO);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    String editDriver(DriverDTO driverDTO);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    String deleteDriver(DriverDTO driverDTO);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    String getBusbyId(DriverDTO driverDTO);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    String loginDriver(DriverDTO driverDTO);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    String startRideDriver(DriverDTO driverDTO);


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    String updateSpeedOfTheBus(DriverDTO driverDTO);
}
