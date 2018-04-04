package guice.module;

import com.google.inject.AbstractModule;
import controllers.DriverController;
import controllers.PassengerController;

/**
 * Bindings for controllers.
 *
 */
public class ControllerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PassengerController.class).asEagerSingleton();
        bind(DriverController.class).asEagerSingleton();
    }
}
