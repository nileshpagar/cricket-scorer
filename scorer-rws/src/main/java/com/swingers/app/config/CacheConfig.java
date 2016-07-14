package com.swingers.app.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.swingers.app.AppConfiguration;
import com.swingers.app.cache.SwingersCache;
import com.swingers.app.model.Team;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by nileshpagar on 7/14/16.
 */
@Configuration
public class CacheConfig {

    @Bean
    Cache<String, Team> teamsCache(AppConfiguration configuration){
        return CacheBuilder.newBuilder().
                maximumSize(configuration.getNumberOfTeamsSupported()).
                expireAfterWrite(365, TimeUnit.DAYS).
                build();
    }

    @Bean
    SwingersCache swingersCache(){
        return new SwingersCache();
    }

}
