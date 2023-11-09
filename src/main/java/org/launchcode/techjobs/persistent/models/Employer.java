package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Employer extends AbstractEntity {

    @NotNull
    @Size(min = 2, max = 25, message = "Location must be reasonable size. Minimum of 2, maximum of 25.")
    private String location;

    public Employer() {
    }
    public Employer(String aLocation) {
        super();
        this.location = aLocation;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer employer)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(location, employer.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location);
    }
}
