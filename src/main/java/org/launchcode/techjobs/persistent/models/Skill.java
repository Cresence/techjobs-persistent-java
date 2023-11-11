package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Skill extends AbstractEntity {

    @NotNull
    @NotEmpty(message = "Cannot be empty")
    @Size(max = 250, message = "Description must be no longer than 250 char!")
    private String description;


    @ManyToMany(mappedBy = "skills")
    private final List<Job> jobs = new ArrayList<>();


    public Skill() {
    }
    public Skill(String description) {
        super();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill skill)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(description, skill.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description);
    }
}
