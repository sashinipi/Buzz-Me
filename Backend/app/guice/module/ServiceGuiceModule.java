package guice.module;

import com.google.inject.AbstractModule;
import service.passenger.PassengerService;
import service.passenger.PassengerServiceImpl;

/**
 * Bindings for service classes.
 *
 */
public class ServiceGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PassengerService.class).to(PassengerServiceImpl.class);
    }
}
