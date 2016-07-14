package com.swingers.app.resources;

import com.swingers.app.AppConfiguration;
import com.swingers.app.SwingersApplication;
import com.swingers.app.model.Team;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by nileshpagar on 7/12/16.
 */
public class ScorerResourceITCase {

    @ClassRule
    public static final DropwizardAppRule<AppConfiguration> RULE = new DropwizardAppRule<AppConfiguration>(SwingersApplication.class, ResourceHelpers.resourceFilePath("scorer-test-config.yml"));

    private static String baseUrl;
    private static Client client;

    @BeforeClass
    public static void setup(){
        baseUrl = String.format("http://localhost:%d/swingers", RULE.getLocalPort());
        client = new JerseyClientBuilder(RULE.getEnvironment()).build("swingers test client");
    }

    @Test
    public void shouldCreateTeam(){
        Response response = client.target(baseUrl + "/create/team").request().post(Entity.json(createTestTeam("TCC")));
        assertEquals(200, response.getStatus());
        Team team = response.readEntity(Team.class);

        response = client.target(baseUrl + "/get/team?id="+team.getId()).request().get();
        assertEquals(200, response.getStatus());
        assertEquals(team, response.readEntity(Team.class));
    }

    private Team createTestTeam(String name) {
        Team team = new Team();
        team.setName(name);
        team.setSize(11);
        team.setNumberOfExtras(4);
        return team;
    }

}
