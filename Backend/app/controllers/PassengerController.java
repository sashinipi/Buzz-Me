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
 * Controller class for handling the REST interface for all passenger related calls.
 *
 */
public class PassengerController extends Controller{

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Create a new passenger.
     *
     * @return Result object
     */
    public Result addNewPassenger() {
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
