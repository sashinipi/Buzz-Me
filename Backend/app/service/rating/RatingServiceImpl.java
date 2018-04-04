package service.rating;

import com.google.inject.Inject;
import dao.rating.RatingDao;
import dto.MessageDTO;
import dto.RatingDTO;
import io.ebean.Ebean;
import models.RatingModel;

import java.util.Date;

/**
 * Implementation of rating service.
 *
 */
public class RatingServiceImpl implements RatingService {

    private final RatingDao ratingDao;

    @Inject
    public RatingServiceImpl(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    /**
     * Update the rating.
     *
     * @param ratingDTO DTO containing rating information
     * @return          Message DTO containing the status
     */
    @Override
    public MessageDTO updateRating(RatingDTO ratingDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            Ebean.beginTransaction();

            // Retrieve the existing rating model for the bus ID.
            RatingModel ratingByBusID = ratingDao.getRatingByBusID(ratingDTO.getBusID());

            // Increase the passenger count who has given the rating for that particular bus.
            int newCount = ratingByBusID.getCount() + 1;

            // Get the existing rating for that bus.
            int existingRating = ratingByBusID.getRating();

            // Get the new rating for that bus.
            int newRating = ratingDTO.getRating();

            // Get modified average rating.
            int modifiedRating = (existingRating + newRating) / newCount;

            // Set the new rating to the model to be saved.
            ratingByBusID.setRating(modifiedRating);

            // Set the time stamps for the modification.
            ratingByBusID.setTimeStamp(new Date());

            // Update the rating.
            ratingDao.updateRating(ratingByBusID);
            messageDTO.setMessage("Success");


        } catch (Exception e) {
            Ebean.rollbackTransaction();
            messageDTO.setMessage("Fail");
        }
        return null;
    }
}
