package com.swingers.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by nileshpagar on 7/12/16.
 */
public class AppConfiguration extends Configuration {

    private int numberOfTeamsSupported;

    @JsonProperty
    public int getNumberOfTeamsSupported() {
        return numberOfTeamsSupported;
    }

    @JsonProperty
    public void setNumberOfTeamsSupported(int numberOfTeamsSupported) {
        this.numberOfTeamsSupported = numberOfTeamsSupported;
    }

}
