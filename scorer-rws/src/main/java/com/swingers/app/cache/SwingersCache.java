package com.swingers.app.cache;

import com.google.common.cache.Cache;
import com.swingers.app.model.Team;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by nileshpagar on 7/14/16.
 */
public class SwingersCache {

    @Autowired
    Cache<String, Team> teamsCache;

    public void storeTeam(Team team){
        teamsCache.put(team.getId(), team);
    }

    public Team getTeam(String id){
        return teamsCache.getIfPresent(id);
    }

}
