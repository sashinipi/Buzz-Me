package dao.driver;

import io.ebean.Ebean;
import models.DriverModel;
import play.Logger;

/**
 * Created by Sashinip on 3/25/2018.
 */
public class DriverDaoImpl implements DriverDao{

    /**
     * Add new Driver
     * @param driverModel
     * @return driverID
     * @throws Exception
     */
    @Override
    public int addDriver(DriverModel driverModel) throws Exception {

        try {
            driverModel.save();
            return driverModel.getId();
        } catch (Exception e){
            Logger.error("Failed to add driver" + e);
            throw new Exception("Failed to add driver");
        }
    }

    /**
     * Edit Driver
     * @param driverModel
     * @throws Exception
     */
    @Override
    public void editDriver(DriverModel driverModel) throws Exception {

        try {
            driverModel.update();
        } catch (Exception e){
            Logger.error("Failed to update driver" + e);
            throw new Exception("Failed to update driver");
        }

    }

    /**
     * Delete Driver
     * @param driverModel
     * @throws Exception
     */
    @Override
    public void deleteDriver(DriverModel driverModel) throws Exception {

        try {
            driverModel.delete();
        } catch (Exception e){
            Logger.error("Failed to delete driver" + e);
            throw new Exception("Failed to delete driver");
        }

    }

    /**
     * Get driver details
     * @param passengerID
     * @return DriverModel
     * @throws Exception
     */
    @Override
    public DriverModel getDriverByID(int passengerID) throws Exception {
        try {
            return Ebean.find(DriverModel.class, passengerID);
        } catch (Exception e) {
            Logger.error("Failed to get passenger by ID " + e);
            throw new Exception("Failed to get passenger by ID");
        }
    }
}
