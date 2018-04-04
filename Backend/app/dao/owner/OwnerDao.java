package dao.owner;

import models.OwnerModel;

/**
 * Interface defining calls to the owner DAO.
 *
 */
public interface OwnerDao {

    /**
     * Add a new Owner.
     *
     * @param ownerModel Model containing the details of the new owner
     * @return               Owner ID
     * @throws Exception     Exception to throw
     */
    int addNewOwner(OwnerModel ownerModel) throws Exception;

    /**
     * Retrieve owner by ID.
     *
     * @param ownerID ID of owner
     * @return            Owner model
     * @throws Exception  Exception to throw
     */
    OwnerModel getOwnerByID(int ownerID) throws Exception;

    /**
     * Update a passenger.
     *
     * @param ownerModel Model containing the details of the owner to be updated
     * @throws Exception     Exception to throw
     */
    void updateOwner(OwnerModel ownerModel) throws Exception;

    /**
     * Delete owner.
     *
     * @param ownerModel Model containing the details of the owner to be deleted
     * @throws Exception     Exception to throw
     */
    void removeOwner(OwnerModel ownerModel) throws Exception;
}