package com.swingers.app.resources;

import com.swingers.app.config.AppConfiguration;
import com.swingers.app.config.ScorerApplication;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by nileshpagar on 7/12/16.
 */
public class ScorerResourceTest {

    @ClassRule
    public static final DropwizardAppRule<AppConfiguration> RULE =
            new DropwizardAppRule<AppConfiguration>(ScorerApplication.class, ResourceHelpers.resourceFilePath("./scorer.yml"));

    @Test
    public void shouldCreateTeam(){
        Client client = new JerseyClientBuilder(RULE.getEnvironment()).build("swingers test client");

        Response response = client.target(
                String.format("http://localhost:%d/swingers?teamName=TCC", RULE.getLocalPort()))
                .request().get();

        assertEquals(200, response.getStatus());
    }

}
