package com.lambdaschool.foundation.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "userplants")
@IdClass(UserPlantsId.class)
public class UserPlant extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "plants",
    allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "plantid")
    @JsonIgnoreProperties(value = "users",
            allowSetters = true)
    private Plant plant;

    public UserPlant() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if(!(o instanceof UserPlant)) {
            return false;
        }
        UserPlant that = (UserPlant) o;

        return ((user == null) ? 0 : user.getUserid()) == ((that.user == null) ? 0 :
        that.user.getUserid()) &&
        ((plant == null) ? 0 : plant.getPlantid()) == ((that.plant == null) ? 0 : that.plant.getPlantid());
    }

    @Override
    public int hashCode() {
        return 22;
    }
}
