package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import dto.*;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.passenger.PassengerService;
import service.rating.RatingService;

import java.io.IOException;
import java.util.List;

/**
 * Controller class for handling the REST interface for all passenger related calls.
 *
 */
public class PassengerController extends Controller {

    private final PassengerService passengerService;
    private final RatingService ratingService;

    private ObjectMapper mapper = new ObjectMapper();

    @Inject
    public PassengerController(PassengerService passengerService, RatingService ratingService) {
        this.passengerService = passengerService;
        this.ratingService = ratingService;
    }

    /**
     * Create a new passenger.
     *
     * @return Result object
     */
    public Result addNewPassenger() {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerDTO passengerDTO = mapper.readValue(jsonNode.toString(), PassengerDTO.class);
            messageDTO = passengerService.addNewPassenger(passengerDTO);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Edit an existing passenger.
     *
     * @param passengerID ID of passenger to be edited
     * @return            Result object
     */
    public Result editPassenger(Integer passengerID) {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerDTO passengerDTO = mapper.readValue(jsonNode.toString(), PassengerDTO.class);
            messageDTO = passengerService.updatePassenger(passengerDTO, passengerID);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Delete an existing passenger.
     *
     * @param passengerID ID of passenger to be deleted
     * @return            Result object
     */
    public Result deletePassenger(Integer passengerID) {
        Result result;

        MessageDTO messageDTO = passengerService.removePassenger(passengerID);

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Retrieve passenger by ID.
     *
     * @param passengerID ID of passenger to be retrieved
     * @return            Result object
     */
    public Result getPassengerByID(Integer passengerID) {
        Result result;

        try {
            PassengerDTO passengerDTO = passengerService.getPassengerById(passengerID);
            result = ok(Json.toJson(passengerDTO));

        } catch (Exception e) {
            result = ok(Json.toJson("Retrieval failed"));
        }
        return result;
    }

    /**
     * Get passenger login details.
     *
     * @return Result object
     */
    public Result getPassengerLogin() {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerIDDTO passengerIDDTO = mapper.readValue(jsonNode.toString(), PassengerIDDTO.class);
            messageDTO = passengerService.verifyPassenger(passengerIDDTO);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Update the rating for the bus.
     *
     * @return Result object
     */
    public Result updateRating() {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            RatingDTO ratingDTO = mapper.readValue(jsonNode.toString(), RatingDTO.class);
            messageDTO = ratingService.updateRating(ratingDTO);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Retrieve the recommendations for a bus.
     *
     * @return Result object
     */
    public Result getRecommendation(String mood, String destination) {
        Result result;
        List<RecommendedBusDTO> recommendedBuses = passengerService.getRecommendedBuses(mood, destination);
        result = ok(Json.toJson(recommendedBuses));
        return result;
    }
}
