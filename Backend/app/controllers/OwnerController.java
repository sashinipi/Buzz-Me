package controllers;

import play.mvc.Controller;
import play.mvc.Result;
//import views.html.index;

/**
 * Controller class for handling the REST interface for all owner related calls.
 *
 */
public class OwnerController extends Controller {
    private final OwnerService ownerService;

    private ObjectMapper mapper = new ObjectMapper();

    @Inject
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * Create a new owner.
     * @return Result object
     */
    public Result addNewOwner() {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            OwnerDTO ownerDTO = mapper.readValue(jsonNode.toString(), OwnerDTO.class);
            messageDTO = ownerService.addNewOwner(ownerDTO);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Edit existing owner.
     * @param OwnerID, ID of owner to be edited
     * @return            Result object
     */
    public Result editOwner(Integer ownerID) {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            OwnerDTO ownerDTO = mapper.readValue(jsonNode.toString(), OwnerDTO.class);
            messageDTO = ownerService.updateOwner(ownerDTO, ownerID);

        } catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Delete existing owner.
     * @param ownerID, ID of owner to be deleted
     * @return            Result object
     */
    public Result deleteOwner(Integer ownerID) {
        Result result;

        MessageDTO messageDTO = ownerService.removeOwner(ownerID);

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    /**
     * Retrieve owner by ID.
     * @param ownerID, ID of owner to be retrieved
     * @return            Result object
     */
    public Result getOwnerByID(Integer ownerID) {
        Result result;

        try {
            OwnerDTO ownerDTO = ownerService.getOwnerById(ownerID);
            result = ok(Json.toJson(ownerDTO));

        } catch (Exception e) {
            result = ok(Json.toJson("Retrieval failed"));
        }
        return result;
    }

    /**
     * Get owner login details.
     * @return Result object
     **/
    public Result getOwnerLogin() {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {
            JsonNode jsonNode = request().body().asJson();

            OwnerIDDTO ownerIDDTO = mapper.readValue(jsonNode.toString(), OwnerIDDTO.class);
            messageDTO = ownerService.verifyOwner(ownerIDDTO);
        }
        catch (IOException e) {
            Logger.error("Couldn't map JSON to object", e);
        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }

    // TODO: Report generation Not completed.
    {
    /**
     * Display reports sorted by month
     * @return Result object
     **/
   /** public Result displayMonthlyReport() {
        Result result;
        MessageDTO messageDTO = new MessageDTO();

        try {

        }
        catch (IOException e) {

        }

        result = ok(Json.toJson(messageDTO));
        return result;
    }
    */

    /**
     * Display reports sorted daily
     * @return Result object
     **/

    /** public Result displayDailyReport() {
     Result result;
     MessageDTO messageDTO = new MessageDTO();

     try {

     }
     catch (IOException e) {

     }

     result = ok(Json.toJson(messageDTO));
     return result;
     }
     */}
}
