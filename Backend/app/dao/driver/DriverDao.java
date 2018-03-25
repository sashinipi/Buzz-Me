package dao.driver;

import models.DriverModel;

/**
 * Created by Sashinip on 3/25/2018.
 */

public interface DriverDao {

    int addDriver(DriverModel driverModel) throws Exception;

    void editDriver(DriverModel driverModel) throws Exception;

    void deleteDriver(DriverModel driverModel) throws Exception;

    DriverModel getDriverByID(int passengerID) throws Exception;

}
