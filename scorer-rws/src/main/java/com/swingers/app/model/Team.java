package com.swingers.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.UUID;

/**
 * Created by nileshpagar on 7/11/16.
 */
public class Team {

    private final String id;
    private String name;
    private Integer size;
    private Integer numberOfExtras;

    public Team(){
        this.id = "team-id-" + UUID.randomUUID().toString();
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public Integer getSize() {
        return size;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty
    public Integer getNumberOfExtras() {
        return numberOfExtras;
    }

    @JsonProperty
    public void setNumberOfExtras(Integer numberOfExtras) {
        this.numberOfExtras = numberOfExtras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equal(id, team.id) &&
                Objects.equal(name, team.name) &&
                Objects.equal(size, team.size) &&
                Objects.equal(numberOfExtras, team.numberOfExtras);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, size, numberOfExtras);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", numberOfExtras=" + numberOfExtras +
                '}';
    }
}
