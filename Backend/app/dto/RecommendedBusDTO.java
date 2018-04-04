package dto;

/**
 * Class to represent a recommendation bus.
 *
 */
public class RecommendedBusDTO {

    private int recommendationID;
    private String busNumber;
    private String eta;
    private String speed;
    private String comment;
    private boolean bookmark;

    public int getRecommendationID() {
        return recommendationID;
    }

    public void setRecommendationID(int recommendationID) {
        this.recommendationID = recommendationID;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isBookmark() {
        return bookmark;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }
}
