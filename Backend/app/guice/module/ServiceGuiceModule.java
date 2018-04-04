package guice.module;

import com.google.inject.AbstractModule;
import service.driver.DriverService;
import service.driver.DriverServiceImpl;
import service.passenger.PassengerService;
import service.passenger.PassengerServiceImpl;

import service.ride.RideService;
import service.ride.RideServiceImpl;

import service.rating.RatingService;
import service.rating.RatingServiceImpl;

/**
 * Bindings for service classes.
 *
 */
public class ServiceGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PassengerService.class).to(PassengerServiceImpl.class);

        bind(DriverService.class).to(DriverServiceImpl.class);
        bind(RideService.class).to(RideServiceImpl.class);
        bind(RatingService.class).to(RatingServiceImpl.class);
        bind(RideService.class).to(RideServiceImpl.class);

    }
}
