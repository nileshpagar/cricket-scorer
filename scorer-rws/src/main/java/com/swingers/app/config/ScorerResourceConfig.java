package com.swingers.app.config;

import com.swingers.app.resources.ScorerResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nileshpagar on 7/14/16.
 */
@Configuration
public class ScorerResourceConfig {

    @Bean
    public ScorerResource scorerResource(){
        return new ScorerResource();
    }

}
