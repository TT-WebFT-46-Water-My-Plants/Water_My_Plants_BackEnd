package com.lambdaschool.foundation.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "plants")
// Remember to extend Auditable
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long plantid;

    @NotNull
    @Column(unique = true)
    private String nickname;

    @NotNull
    @Column
    private String species;

    @NotNull
    @Column
    private Integer h2oFrequency;

    public Plant() {
    }

    public Plant(@NotNull String nickname, @NotNull String species, @NotNull Integer h2oFrequency) {
        this.nickname = nickname;
        this.species = species;
        this.h2oFrequency = h2oFrequency;
    }

    public long getPlantid() {
        return plantid;
    }

    public void setPlantid(long plantid) {
        this.plantid = plantid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getH2oFrequency() {
        return h2oFrequency;
    }

    public void setH2oFrequency(Integer h2oFrequency) {
        this.h2oFrequency = h2oFrequency;
    }
}
