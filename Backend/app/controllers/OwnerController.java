package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * Controller class for handling the REST interface for all owner related calls.
 *
 */
public class OwnerController extends Controller {

    public Result test() {
        return ok(index.render("Your new application is ready."));
    }

}
