package com.swingers.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by nileshpagar on 7/11/16.
 */
public class Team {

    private String name;

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

}
