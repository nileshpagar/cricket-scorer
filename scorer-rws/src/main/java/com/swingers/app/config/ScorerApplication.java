package com.swingers.app.config;

import com.swingers.app.resources.ScorerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by nileshpagar on 7/12/16.
 */
public class ScorerApplication  extends Application<AppConfiguration> {

    public void run(AppConfiguration appConfiguration, Environment environment) throws Exception {
        final ScorerResource scorerResource = new ScorerResource(appConfiguration.getTemplate(), appConfiguration.getDefaultName());
        environment.jersey().register(scorerResource);
    }

    public static void main(String[] args) throws Exception {
        new ScorerApplication().run(args);
    }

    @Override
    public String getName() {
        return "Swingers";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

}
