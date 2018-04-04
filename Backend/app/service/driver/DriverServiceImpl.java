package service.driver;

import com.google.inject.Inject;
import dao.driver.DriverDao;
import dto.DriverDTO;
import dto.MessageDTO;
import io.ebean.Ebean;
import models.DriverModel;

import java.util.Date;

/**
 * Created by Sashinip on 3/24/2018.
 */

/**
 * Implementation of driver service.
 *
 */

public class DriverServiceImpl implements DriverService {

    private final DriverDao driverDao;

    @Inject
    public DriverServiceImpl(DriverDao driverDao) {
        this.driverDao = driverDao;
    }


    /**
     * Add a new driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    @Override
    public MessageDTO addNewDriver(DriverDTO driverDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            DriverModel driverModel = new DriverModel();
            driverModel.setName(driverDTO.getName());
            driverModel.setAddress(driverDTO.getAddress());
            driverModel.setNICNumber(driverDTO.getNICNumber());
            driverModel.setPassword(driverDTO.getPassword());
            driverModel.setTimeStamp(new Date());

            int driverID = driverDao.addDriver(driverModel);
            messageDTO.setId(driverID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            messageDTO.setMessage("Fail");
        }
        return messageDTO;
    }

    /**
     * Edit driver.
     *
     * @param driverDTO DTO containing passenger information
     * @return             Success or fail status
     */
    @Override
    public MessageDTO editDriver(DriverDTO driverDTO, int driverID) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            Ebean.beginTransaction();

            DriverModel driverByID = driverDao.getDriverByID(driverID);

            driverByID.setName(driverDTO.getName());
            driverByID.setAddress(driverDTO.getAddress());
            driverByID.setNICNumber(driverDTO.getNICNumber());
            driverByID.setPassword(driverDTO.getPassword());
            driverByID.setTimeStamp(new Date());

            driverDao.editDriver(driverByID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            Ebean.rollbackTransaction();
            messageDTO.setMessage("Fail");
        }
        return messageDTO;
    }

    /**
     * Delete driver.
     *
     * @param driverID DTO containing passenger information
     * @return             Success or fail status
     */
    @Override
    public MessageDTO deleteDriver(int driverID) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            DriverModel passengerByID = driverDao.getDriverByID(driverID);
            driverDao.deleteDriver(passengerByID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            messageDTO.setMessage("Fail");
        }

        return messageDTO;
    }

    /**
     * Get bus by ID.
     *
     * @param busID DTO containing passenger information
     * @return             Success or fail status
     */
    @Override
    public MessageDTO getBusbyId(int busID) {
        return null;
    }

    /**
     * Login Driver
     * @param driverDTO DTO containing passenger information
     * @return
     */
    @Override
    public MessageDTO loginDriver(DriverDTO driverDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            DriverModel driverByID = driverDao.getDriverByID(driverDTO.getId());

            if (driverDTO.getName().equals(driverByID.getName())) {
                if (driverDTO.getPassword().equals(driverByID.getPassword())) {
                    messageDTO.setMessage("User is verified");

                } else {
                    messageDTO.setMessage("Password does not match");

                }
            } else  {
                messageDTO.setMessage("User name does not match");
            }

        } catch (Exception e) {
            messageDTO.setMessage("An error occurred during verification");
        }
        return messageDTO;
    }

    /**
     * Get driver by ID.
     *
     * @param driverID DTO containing passenger information
     * @return             Success or fail status
     */
    @Override
    public DriverDTO getDriverByID(int driverID) throws Exception {
        DriverDTO driverDTO = new DriverDTO();

        DriverModel driverByID = driverDao.getDriverByID(driverID);

        driverDTO.setName(driverByID.getName());
        driverDTO.setAddress(driverByID.getAddress());
        driverDTO.setNICNumber(driverByID.getNICNumber());
        return driverDTO;
    }
}