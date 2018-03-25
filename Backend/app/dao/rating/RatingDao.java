package dao.rating;

import models.RatingModel;

/**
 * Interface defining calls to the rating DAO.
 *
 */
public interface RatingDao {

    /**
     * Get the rating by bus ID.
     *
     * @param busID      Bus ID
     * @throws Exception Exception to throw
     */
    RatingModel getRatingByBusID(int busID) throws Exception;

    /**
     * Update the rating.
     *
     * @param ratingModel Model containing the details of the rating to be updated
     * @throws Exception  Exception to throw
     */
    void updateRating(RatingModel ratingModel) throws Exception;
}
