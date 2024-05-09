package io.fullstackbasics.careerportalservice.query.controller;

import io.fullstackbasics.careerportalservice.query.service.JobPostQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/job-post")
public class JobPostQueryController {

    private JobPostQueryService jobPostQueryService;

    public JobPostQueryController(JobPostQueryService jobPostQueryService) {
        this.jobPostQueryService = jobPostQueryService;
    }

    @GetMapping
    public ResponseEntity findAllJobPosts(){
        return jobPostQueryService.findAllJobPosts();
    }

    @GetMapping("/{jobPostId}")
    public ResponseEntity findJobPostByJobPostId(@PathVariable String jobPostId) throws ExecutionException, InterruptedException {
        return jobPostQueryService.findJobPostByJobPostId(jobPostId);
    }
}
