package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.PassengerDTO;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.IOException;

/**
 * Controller class for handling the REST interface for all driver related calls.
 *
 */
public class DriverController extends Controller {

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Create a new passenger.
     *
     * @return Result object
     */
    public Result addNewDriver(int driverID) {
        Result result;

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerDTO passengerDTO = mapper.readValue(jsonNode.toString(), PassengerDTO.class);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson("Sample OKay"));
        return result;
    }


    public Result editDriver(int driverID) {
        Result result;

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerDTO passengerDTO = mapper.readValue(jsonNode.toString(), PassengerDTO.class);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson("Sample OKay"));
        return result;
    }


    public Result deleteDriver(int driverID) {
        Result result;

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerDTO passengerDTO = mapper.readValue(jsonNode.toString(), PassengerDTO.class);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson("Sample OKay"));
        return result;
    }


    public Result getBusbyId(int driverID) {
        Result result;

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerDTO passengerDTO = mapper.readValue(jsonNode.toString(), PassengerDTO.class);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson("Sample OKay"));
        return result;
    }


    public Result loginDriver() {
        Result result;

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerDTO passengerDTO = mapper.readValue(jsonNode.toString(), PassengerDTO.class);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson("Sample OKay"));
        return result;
    }


    public Result startRideDriver() {
        Result result;

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerDTO passengerDTO = mapper.readValue(jsonNode.toString(), PassengerDTO.class);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson("Sample OKay"));
        return result;
    }


    public Result updateSpeedOfTheDriver(int rideID, String speed) {
        Result result;

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerDTO passengerDTO = mapper.readValue(jsonNode.toString(), PassengerDTO.class);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson("Sample OKay"));
        return result;
    }


    public Result updateLocationOfTheDriver(int rideID, String Location) {
        Result result;

        try {
            JsonNode jsonNode = request().body().asJson();

            PassengerDTO passengerDTO = mapper.readValue(jsonNode.toString(), PassengerDTO.class);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson("Sample OKay"));
        return result;
    }
}
