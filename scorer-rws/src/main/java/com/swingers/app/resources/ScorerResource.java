package com.swingers.app.resources;

import com.codahale.metrics.annotation.Timed;
import com.swingers.app.model.Team;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by nileshpagar on 7/12/16.
 */
@Path("/swingers")
@Produces(MediaType.APPLICATION_JSON)
public class ScorerResource {

    private final String template;
    private final String defaultName;

    public ScorerResource(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    @Timed
    public Team createTeam(@QueryParam("teamName") final String teamName){
        Team team = new Team();
        team.setName(teamName);
        return team;
    }

}
