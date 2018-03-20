package cors;

import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Response;
import play.mvc.Result;
import play.mvc.With;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.CompletionStage;

/**
 * Following class implements the CORS support in Play Application as suggested in the Play Wiki link,
 * http://playframework.wiki/index.php?title=Access-Control-Allow-Origin
 *
 * To enable CORS in any controller, simply annotate the respective controller class with, @CorsComposition.Cors
 */
public class CorsComposition {
    private static final String RES_HEADER_CORS_ALLOW_ORIGIN_KEY = "Access-Control-Allow-Origin";
    private static final String RES_HEADER_CORS_ALLOW_ORIGIN_VALUE = "*";
    private static final String PF_RES_HEADER_CORS_ALLOW_METHODS_KEY = "Access-Control-Allow-Methods";
    private static final String PF_RES_HEADER_CORS_ALLOW_METHODS_VALUE = "POST, GET, PUT, DELETE, OPTIONS";
    private static final String PF_RES_HEADER_CORS_ALLOW_HEADERS_KEY = "Access-Control-Allow-Headers";
    private static final String PF_RES_HEADER_CORS_ALLOW_HEADERS_VALUE = "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent";
    private static final String PRE_FLIGHT_METHOD = "OPTIONS";

    /**
     * This defines the annotation that needs to be used in controllers requiring cross-origin resource sharing
     * IMPORTANT: In any controller that needs to enable CORS, annotate that controller class as @CorsComposition.Cors
     *
     */
    @With(CorsAction.class)
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Cors {
        /**
         * Retrieves the default configuration value
         *
         * @return the default configuration value
         */
        String value() default RES_HEADER_CORS_ALLOW_ORIGIN_VALUE;
    }
    /**
     * This inner class defines the action to be invoked in case OPTIONS call is received by a controller
     *
     */
    public static class CorsAction extends Action<Cors> {
        /**
         * Interception promise which cater the CORS OPTION call coming from JS running in browsers
         *
         * @param context       the context of the current REST call
         * @return              modified response promise with required CORS headers
         */
        @Override
        public CompletionStage<Result> call(Context context)  {

            Response response = context.response();

            //Set Access-Control-Allow-Origin header in any response to *
            response.setHeader(RES_HEADER_CORS_ALLOW_ORIGIN_KEY, configuration.value());

            //Check whether the request is Pre-flights request
            if (context.request().method().equals(PRE_FLIGHT_METHOD)) {

                //Restrict CORS allowed HTTP methods only to GET calls
                response.setHeader(PF_RES_HEADER_CORS_ALLOW_METHODS_KEY, PF_RES_HEADER_CORS_ALLOW_METHODS_VALUE);

                //Restrict CORS allowed HTTP request headers only to known request headers
                response.setHeader(PF_RES_HEADER_CORS_ALLOW_HEADERS_KEY, PF_RES_HEADER_CORS_ALLOW_HEADERS_VALUE);
                return delegate.call(context);
            }

            return delegate.call(context);
        }
    }
}