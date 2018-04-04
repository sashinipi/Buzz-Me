package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import dto.DriverDTO;
import dto.MessageDTO;
import dto.PassengerDTO;
import dto.RideDTO;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.driver.DriverService;
import service.ride.RideService;

import java.io.IOException;


import static play.mvc.Results.ok;
/**
 * Controller class for handling the REST interface for all driver related calls.
 *
 */
public class DriverController extends Controller {

    private final DriverService driverService;
    private final RideService rideService;

    private ObjectMapper mapper = new ObjectMapper();

    @Inject
    public DriverController(DriverService driverService, RideService rideService) {
        this.driverService = driverService;
        this.rideService = rideService;
    }

    /**
     * Add New Driver.
     * Passsword is not encrypted
     * @return Result object
     */
    public Result addNewDriver() {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            DriverDTO driverDTO = mapper.readValue(jsonNode.toString(), DriverDTO.class);
            messageDTO = driverService.addNewDriver(driverDTO);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Edit Driver
     * Password is not encrypted
     * @param driverID
     * @return Result Object
     */
    public Result editDriver(int driverID) {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            DriverDTO driverDTO = mapper.readValue(jsonNode.toString(), DriverDTO.class);
            messageDTO = driverService.editDriver(driverDTO, driverID);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Delete Driver
     * Safe Delete is used. in stead of delete a tag has been added to indicate the delete once
     * @param driverID
     * @return Result Object
     */
    public Result deleteDriver(int driverID) {
        Result result;

        MessageDTO messageDTO = driverService.deleteDriver(driverID);

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Get Driver Details
     * @param driverID
     * @return Result Object
     */
    public Result getDriverByID(int driverID) {
        Result result;

        try {
            DriverDTO messageDTO = driverService.getDriverByID(driverID);
            result = ok(Json.toJson(messageDTO));

        } catch (Exception e) {
            result = ok(Json.toJson("Driver Details Retrieval failed"));
        }
        return result;
    }

    /**
     * Get Bus Details
     * @param busID
     * @return Result Object
     */
    public Result getBusbyId(int busID) {
        Result result;

        try {
            MessageDTO messageDTO = driverService.getBusbyId(busID);
            result = ok(Json.toJson(messageDTO));

        } catch (Exception e) {
            result = ok(Json.toJson("Bus Details Retrieval failed"));
        }
        return result;
    }

    /**
     * Login Driver
     * @return Result Object
     */
    public Result loginDriver() {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            DriverDTO driverDTO = mapper.readValue(jsonNode.toString(), DriverDTO.class);
            messageDTO = driverService.loginDriver(driverDTO);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Get Driver Details
     * @param driverID
     * @return Result Object
     */
    public Result getRideByID(int rideID) {
        Result result;

        try {
            RideDTO messageDTO = rideService.getRideByID(rideID);
            result = ok(Json.toJson(messageDTO));

        } catch (Exception e) {
            result = ok(Json.toJson("Driver Details Retrieval failed"));
        }
        return result;
    }

    /**
     * Start Ride
     * @return Result Object
     */
    public Result startRideDriver() {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            RideDTO rideDTO = mapper.readValue(jsonNode.toString(), RideDTO.class);
            messageDTO = rideService.startRide(rideDTO);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Update speed
     * @param rideID
     * @param speed
     * @return Result Object
     */
    public Result updateSpeed(int rideID, String speed) {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            RideDTO rideDTO = mapper.readValue(jsonNode.toString(), RideDTO.class);
            messageDTO = rideService.updateSpeed(rideDTO, rideID, speed);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     *
     * @param rideID
     * @param location
     * @return result Object
     */
    public Result updateLocation(int rideID, String location) {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            RideDTO rideDTO = mapper.readValue(jsonNode.toString(), RideDTO.class);
            messageDTO = rideService.updateLocation(rideDTO, rideID, location);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     *
     * @param rideID
     * @param location
     * @return result Object
     */
    public Result updateNoOfPeople(int rideID, String noOfPeople) {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            RideDTO rideDTO = mapper.readValue(jsonNode.toString(), RideDTO.class);
            messageDTO = rideService.updateNoOfPeople(rideDTO, rideID, noOfPeople);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     *
     * @param driverID
     * @return Result Object
     */
    public Result showRatingOfTheDriver(int driverID) {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            RideDTO rideDTO = mapper.readValue(jsonNode.toString(), RideDTO.class);
            messageDTO = rideService.showRating(rideDTO, driverID);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }
}
