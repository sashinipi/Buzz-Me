package guice.module;

import com.google.inject.AbstractModule;
import dao.passenger.PassengerDao;
import dao.passenger.PassengerDaoImpl;

/**
 * Bindings for DAO classes.
 *
 */
public class DaoGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PassengerDao.class).to(PassengerDaoImpl.class);
    }
}
