package com.swingers.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by nileshpagar on 7/14/16.
 */
@Configuration
@Import({
    CacheConfig.class, ScorerResourceConfig.class
})
public class SwingersRootConfig {
}
