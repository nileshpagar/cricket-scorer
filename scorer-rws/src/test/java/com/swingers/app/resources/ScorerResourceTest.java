package com.swingers.app.resources;

import com.swingers.app.config.AppConfiguration;
import com.swingers.app.config.ScorerApplication;
import com.swingers.app.model.Team;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.client.JerseyClientBuilder;
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
        Team team = new Team();
        Client client = new JerseyClientBuilder().build();
        Response response = client.target("http://localhost:8080/swingers?teamName=TCC").request().get();
        assertEquals(302, response.getStatus());
    }

}
