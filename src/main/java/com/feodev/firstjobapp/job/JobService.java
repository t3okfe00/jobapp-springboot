package com.feodev.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    Job createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    Job updateJobById(Long id, Job job);
}
