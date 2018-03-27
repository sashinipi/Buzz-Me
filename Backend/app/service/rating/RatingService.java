package service.rating;

import dto.MessageDTO;
import dto.RatingDTO;

/**
 * Interface defining rating related calls.
 *
 */
public interface RatingService {

    /**
     * Update the rating.
     *
     * @param ratingDTO DTO containing rating information
     * @return          Message DTO containing the status
     */
    MessageDTO updateRating(RatingDTO ratingDTO);
}
