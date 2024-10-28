package com.feodev.firstjobapp.company;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.feodev.firstjobapp.job.Job;
import com.feodev.firstjobapp.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // this relationship is mapped by company column in Job table
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;


    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;


    public Company() {
    }

    public Company(Long id, String name, String description, List<Job> jobs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.jobs = jobs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
