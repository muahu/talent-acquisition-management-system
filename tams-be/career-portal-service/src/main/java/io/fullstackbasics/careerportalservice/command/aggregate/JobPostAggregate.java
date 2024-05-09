package io.fullstackbasics.careerportalservice.command.aggregate;


import fullstackbasics.io.tamscoreapi.command.CreateJobPostCommand;
import fullstackbasics.io.tamscoreapi.domain.*;
import fullstackbasics.io.tamscoreapi.event.JobPostCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Aggregate
public class JobPostAggregate {

    @AggregateIdentifier
    private String jobPostId;
    private String talentFulfillmentId;
    private String talentRequestId;
    private String talentRequestTitle;
    private LocalDate startDate;

    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RequestStatus requestStatus;
    private RoleLevel roleLevel;
    private EmploymentType employmentType;

    public JobPostAggregate() {
    }

    @CommandHandler
    public JobPostAggregate(CreateJobPostCommand createJobPostCommand) {
        JobPostCreatedEvent jobPostCreatedEvent = new JobPostCreatedEvent();
        BeanUtils.copyProperties(createJobPostCommand, jobPostCreatedEvent);

        AggregateLifecycle.apply(jobPostCreatedEvent);

    }

    @EventSourcingHandler
    public void on (JobPostCreatedEvent jobPostCreatedEvent){
        jobPostId = jobPostCreatedEvent.getJobPostId();
        talentFulfillmentId = jobPostCreatedEvent.getTalentFulfillmentId();
        talentRequestId = jobPostCreatedEvent.getTalentRequestId();
        talentRequestTitle = jobPostCreatedEvent.getTalentRequestTitle();
        startDate = jobPostCreatedEvent.getStartDate();

        jobDescription = jobPostCreatedEvent.getJobDescription();
        candidateSkills = jobPostCreatedEvent.getCandidateSkills();
        requestStatus = jobPostCreatedEvent.getRequestStatus();
        roleLevel = jobPostCreatedEvent.getRoleLevel();
        employmentType = jobPostCreatedEvent.getEmploymentType();
    }
}
