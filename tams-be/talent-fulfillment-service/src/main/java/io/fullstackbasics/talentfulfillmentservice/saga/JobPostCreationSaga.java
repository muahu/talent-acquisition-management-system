package io.fullstackbasics.talentfulfillmentservice.saga;

import io.fullstackbasics.talentfulfillmentservice.core.events.TalentFulfillmentDecisionSubmittedEvent;
import fullstackbasics.io.tamscoreapi.command.CreateJobPostCommand;
import fullstackbasics.io.tamscoreapi.command.UpdateTalentRequestStatusCommand;
import fullstackbasics.io.tamscoreapi.event.JobPostCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class JobPostCreationSaga {

    public static final String TALENT_FULFILLMENT_ID = "talentFulfillmentId";

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = TALENT_FULFILLMENT_ID)
    public void handle(TalentFulfillmentDecisionSubmittedEvent talentFulfillmentDecisionSubmittedEvent){
        CreateJobPostCommand createJobPostCommand = CreateJobPostCommand.builder()
                .jobPostId(talentFulfillmentDecisionSubmittedEvent.getJobPostId())
                .talentFulfillmentId(talentFulfillmentDecisionSubmittedEvent.getTalentFulfillmentId())
                .talentRequestId(talentFulfillmentDecisionSubmittedEvent.getTalentRequestId())
                .talentRequestTitle(talentFulfillmentDecisionSubmittedEvent.getTalentRequestTitle())
                .startDate(talentFulfillmentDecisionSubmittedEvent.getStartDate())
                .jobDescription(talentFulfillmentDecisionSubmittedEvent.getJobDescription())
                .candidateSkills(talentFulfillmentDecisionSubmittedEvent.getCandidateSkills())
                .requestStatus(talentFulfillmentDecisionSubmittedEvent.getRequestStatus())
                .roleLevel(talentFulfillmentDecisionSubmittedEvent.getRoleLevel())
                .employmentType(talentFulfillmentDecisionSubmittedEvent.getEmploymentType())
                .build();

        commandGateway.send(createJobPostCommand);
    }

    @EndSaga
    @SagaEventHandler(associationProperty = TALENT_FULFILLMENT_ID)
    public void handle (JobPostCreatedEvent jobPostCreatedEvent){

        UpdateTalentRequestStatusCommand updateTalentRequestStatusCommand = UpdateTalentRequestStatusCommand.builder()
                .talentRequestId(jobPostCreatedEvent.getTalentRequestId())
                .requestStatus(jobPostCreatedEvent.getRequestStatus())
                .build();

        commandGateway.send(updateTalentRequestStatusCommand);

    }

}
