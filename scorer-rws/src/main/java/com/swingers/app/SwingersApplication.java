package com.swingers.app;

import com.swingers.app.config.SwingersRootConfig;
import com.swingers.app.resources.ScorerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

/**
 * Created by nileshpagar on 7/12/16.
 */
public class SwingersApplication extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new SwingersApplication().run(args);
    }

    public void run(AppConfiguration appConfiguration, Environment environment) throws Exception {
        AnnotationConfigApplicationContext springContainer = getApplicationContext(appConfiguration);
        environment.jersey().register(springContainer.getBean("scorerResource", ScorerResource.class));
    }

    private AnnotationConfigApplicationContext getApplicationContext(AppConfiguration appConfiguration) {

        GenericApplicationContext parentContext = new StaticApplicationContext();
        parentContext.getBeanFactory().registerSingleton("appConfiguration", appConfiguration);
        parentContext.refresh();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.setParent(parentContext);
        context.register(SwingersRootConfig.class);
        context.refresh();

        return context;
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
