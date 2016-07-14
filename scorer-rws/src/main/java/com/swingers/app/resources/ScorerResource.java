package com.swingers.app.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Preconditions;
import com.swingers.app.cache.SwingersCache;
import com.swingers.app.model.Team;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by nileshpagar on 7/12/16.
 */
@Path("/swingers")
@Produces(MediaType.APPLICATION_JSON)
public class ScorerResource {



    @Autowired
    SwingersCache swingersCache;

    @POST
    @Timed
    @Path("create/team")
    public Team createTeam(Team team){
        System.out.println("adding "+ team + " to guava cache");
        swingersCache.storeTeam(team);
        return team;
    }

    @GET
    @Timed
    @Path("get/team")
    public Team getTeam(@QueryParam("id")String id){
        Team team = swingersCache.getTeam(Preconditions.checkNotNull(id));
        System.out.println("querying for "+ id+ ", result" + team);
        return team;
    }

}
