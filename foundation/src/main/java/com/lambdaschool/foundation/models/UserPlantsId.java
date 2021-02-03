package com.lambdaschool.foundation.models;

import java.io.Serializable;
import java.util.Objects;

public class UserPlantsId implements Serializable {
    private long user;
    private long plant;

    public UserPlantsId() {
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getPlant() {
        return plant;
    }

    public void setPlant(long plant) {
        this.plant = plant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || getClass() != o.getClass()) {
            return false;
        }
        UserPlantsId that = (UserPlantsId) o;
        return user == that.user && plant == that.plant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getPlant());
    }
}
