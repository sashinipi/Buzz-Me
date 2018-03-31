package guice.module;

import com.google.inject.AbstractModule;
import dao.driver.DriverDao;
import dao.driver.DriverDaoImpl;
import dao.passenger.PassengerDao;
import dao.passenger.PassengerDaoImpl;
import dao.rating.RatingDao;
import dao.rating.RatingDaoImpl;
import dao.ride.RideDao;
import dao.ride.RideDaoImpl;

/**
 * Bindings for DAO classes.
 *
 */
public class DaoGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PassengerDao.class).to(PassengerDaoImpl.class);
        bind(DriverDao.class).to(DriverDaoImpl.class);
        bind(RatingDao.class).to(RatingDaoImpl.class);
        bind(RideDao.class).to(RideDaoImpl.class);
    }
}
