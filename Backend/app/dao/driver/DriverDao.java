package dao.driver;

import models.DriverModel;

/**
 * Created by Sashinip on 3/25/2018.
 */

public interface DriverDao {

    /**
     * Add new Driver.
     * @param driverModel
     * @return driver ID
     * @throws Exception
     */
    int addDriver(DriverModel driverModel) throws Exception;

    /**
     * Edit Driver.
     * @param driverModel
     * @throws Exception
     */
    void editDriver(DriverModel driverModel) throws Exception;

    /**
     * Delete Driver
     * @param driverModel
     * @throws Exception
     */
    void deleteDriver(DriverModel driverModel) throws Exception;

    /**
     * Get Driver Details
     * @param passengerID
     * @return DriverModel
     * @throws Exception
     */
    DriverModel getDriverByID(int passengerID) throws Exception;

}
