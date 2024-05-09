package io.fullstackbasics.careerportalservice.query.eventhandler;

import io.fullstackbasics.careerportalservice.query.repository.JobPost;
import io.fullstackbasics.careerportalservice.query.repository.JobPostRepository;
import fullstackbasics.io.tamscoreapi.event.JobPostCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class JobPostEventHandler {

    private JobPostRepository jobPostRepository;

    public JobPostEventHandler(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    @EventHandler
    public void on(JobPostCreatedEvent jobPostCreatedEvent){
        JobPost jobPost = new JobPost();
        BeanUtils.copyProperties(jobPostCreatedEvent, jobPost);

        jobPostRepository.save(jobPost);
    }

}
