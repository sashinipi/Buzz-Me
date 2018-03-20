package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

//@CorsComposition.Cors
public class OwnerController extends Controller {

    public Result test() {
        return ok(index.render("Your new application is ready."));
    }

}
