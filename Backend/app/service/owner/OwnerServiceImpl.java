package service.owner;

//import

import com.google.inject.Inject;
import dao.owner.OwnerDao;
import dto.MessageDTO;
import dto.OwnerDTO;
import dto.OwnerIDDTO;
import io.ebean.Ebean;
import models.OwnerModel;

import java.util.Date;

/**
 * Implementation of owner service.
 */
public class OwnerServiceImpl implements OwnerService {

    private final OwnerDao ownerDao;

    @Inject
    public OwnerServiceImpl(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    /**
     * Add new owner
     * @param ownerDTO DTO containing owner information
     * @return Message DTO containing the details including the owner ID
     */
    @Override
    public MessageDTO addNewOwner(OwnerDTO ownerDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            OwnerModel ownerModel = new OwnerModel();
            ownerModel.setOwnerName(ownerDTO.getName());
            ownerModel.setMobileNumber(ownerDTO.getMobileNumber());
            ownerModel.setPassword(ownerDTO.getPassword());
//            ownerModel.setRegNumber(ownerDTO.getRegNumber());
            ownerModel.setTimeStamp(new Date());

            int ownerID = ownerDao.addNewOwner(ownerModel);
            messageDTO.setId(ownerID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            messageDTO.setMessage("Fail");
        }
        return messageDTO;
    }

    /**
     * Edit an existing owner
     * @param ownerDTO DTO containing owner information
     * @param ownerID  ID of owner to be updated
     * @return  Message DTO containing the status
     */
    @Override
    public MessageDTO updateOwner(OwnerDTO ownerDTO, int ownerID) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            Ebean.beginTransaction();

            OwnerModel ownerByID = ownerDao.getOwnerByID(ownerID);

            ownerByID.setOwnerName(ownerDTO.getName());
            ownerByID.setMobileNumber(ownerDTO.getMobileNumber());
            ownerByID.setPassword(ownerDTO.getPassword());
//            ownerByID.setRegNumber(ownerDTO.getRegNumber());
            ownerByID.setTimeStamp(new Date());

            ownerDao.updateOwner(ownerByID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            Ebean.rollbackTransaction();
            messageDTO.setMessage("Fail");
        }
        return messageDTO;
    }

    /**
     * Delete an existing owner.
     * @param ownerID  ID of owner to be deleted
     * @return Message DTO containing the status
     */
    @Override
    public MessageDTO removeOwner(int ownerID) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            OwnerModel ownerByID = ownerDao.getOwnerByID(ownerID);
            ownerDao.removeOwner(ownerByID);
            messageDTO.setMessage("Success");

        } catch (Exception e) {
            messageDTO.setMessage("Fail");
        }

        return messageDTO;
    }

    /**
     * Retrieve Owner by ID.
     * @param ownerID ID of owner to be retrieved
     * @return            Passenger DTO
     * @throws Exception  Exception to throw
     */
    @Override
    public OwnerDTO getOwnerById(int ownerID) throws Exception {
        OwnerDTO ownerDTO = new OwnerDTO();

        OwnerModel ownerByID = ownerDao.getOwnerByID(ownerID);

        ownerDTO.setName(ownerByID.getOwnerName());
        ownerDTO.setMobileNumber(ownerByID.getMobileNumber());
        return ownerDTO;
    }

    /**
     * Verify owner.
     *
     * @param ownerIDDTO DTO containing passenger information
     * @return Message DTO containing the status
     */
    @Override
    public MessageDTO verifyOwner(OwnerIDDTO ownerIDDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            OwnerModel ownerByID = ownerDao.getOwnerByID(ownerIDDTO.getId());

            if (ownerIDDTO.getName().equals(ownerByID.getOwnerName())) {
                if (ownerIDDTO.getPassword().equals(ownerByID.getPassword())) {
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
     * TODO :  DisplayReports
     * @param ownerIDDTO DTO containing passenger information
     * @return Message DTO containing the status
     */

}