package com.feodev.firstjobapp.job.impl;

import com.feodev.firstjobapp.job.Job;
import com.feodev.firstjobapp.job.JobRepository;
import com.feodev.firstjobapp.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImplementation implements JobService {
    JobRepository jobRepository;

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //private List<Job> jobs = new ArrayList<>();


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(Job job) {

        jobRepository.save(job);
        return job;
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public Job updateJobById(Long id, Job jobData) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            System.out.println("asdasdasd -->" + jobData);
            System.out.println("BBBBB -->" + jobData.toString());
            Job job = jobOptional.get();
            job.setTitle(jobData.getTitle());
            job.setDescription(jobData.getDescription());
            job.setMinSalary(jobData.getMinSalary());
            job.setMaxSalary(jobData.getMaxSalary());
            job.setLocation(jobData.getLocation());
            System.out.println(" JOB ! -->" + job);
            jobRepository.save(job);
            return job;
        }
        return null;

    }
}
