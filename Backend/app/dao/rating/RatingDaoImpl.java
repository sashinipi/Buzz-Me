package dao.rating;

import io.ebean.Ebean;
import models.RatingModel;
import play.Logger;

/**
 * Implementation of the calls to the rating DAO.
 *
 */
public class RatingDaoImpl implements RatingDao {

    /**
     * Get the rating by bus ID.
     *
     * @param busID      Bus ID
     * @throws Exception Exception to throw
     */
    @Override
    public RatingModel getRatingByBusID(int busID) throws Exception {
        try {
            return Ebean.find(RatingModel.class).where().eq("Bus_ID", busID).findOne();
        } catch (Exception e) {
            Logger.error("Failed to get rating by bus ID " + e);
            throw new Exception("Failed to get rating by bus ID");
        }
    }

    /**
     * Update the rating.
     *
     * @param ratingModel Model containing the details of the rating to be updated
     * @throws Exception  Exception to throw
     */
    @Override
    public void updateRating(RatingModel ratingModel) throws Exception {
        try {
            ratingModel.update();
        } catch (Exception e) {
            Logger.error("Failed to update the rating" + e);
            throw new Exception("Failed to update the rating");
        }
    }
}
