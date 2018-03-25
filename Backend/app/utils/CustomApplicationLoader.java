package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import guice.module.ControllerModule;
import guice.module.DaoGuiceModule;
import guice.module.ServiceGuiceModule;
import play.ApplicationLoader;
import play.Environment;
import play.inject.guice.GuiceApplicationBuilder;
import play.inject.guice.GuiceApplicationLoader;

public class CustomApplicationLoader extends GuiceApplicationLoader {
    @Override
    public GuiceApplicationBuilder builder(ApplicationLoader.Context context) {

        final Environment environment = context.environment();
        GuiceApplicationBuilder builder = initialBuilder.in(environment);
        Config config = ConfigFactory.load();

        return builder.in(environment).loadConfig(config)
                .bindings(new ControllerModule())
                .bindings(new DaoGuiceModule())
                .bindings(new ServiceGuiceModule());
    }
}
