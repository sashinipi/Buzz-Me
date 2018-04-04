package service.owner;

import dto.MessageDTO;
import dto.OwnerDTO;
import dto.OwnerIDDTO;
//import dto.ReportDTO;

/**
 * Interface defining owner related calls.
 *
 */
public interface OwnerService {

    /**
     * Add a new owner.
     *
     * @param ownerDTO DTO containing owner information
     * @return             Message DTO containing the status and the owner ID
     */
    MessageDTO addNewOwner(OwnerDTO ownerDTO);

    /**
     * Edit an existing owner.
     *
     * @param ownerDTO DTO containing owner information
     * @param ownerID  ID of owner to be updated
     * @return             Message DTO containing the status
     */
    MessageDTO updateOwner(OwnerDTO ownerDTO, int ownerID);

    /**
     * Delete an existing owner.
     *
     * @param ownerID  ID of owner to be deleted
     * @return             Message DTO containing the status
     */
    MessageDTO removeOwner(int ownerID);

    /**
     * Retrieve owner by ID.
     *
     * @param ownerID ID of owner to be retrieved
     * @return            owner DTO
     * @throws Exception  Exception to throw
     */
    OwnerDTO getOwnerById(int ownerID) throws Exception;

    /**
     * Verify owner.
     *
     * @param ownerIDDTO DTO containing owner information
     * @return               Message DTO containing the status
     */
    MessageDTO verifyOwner(OwnerIDDTO ownerIDDTO);

    /**
     * Update the rating.
     *
     * @param ratingDTO DTO containing rating information
     * @return          Message DTO containing the status
     */

    //TODO: check reporting
    //MessageDTO updateReport(ReportDTO reportDTO);
}