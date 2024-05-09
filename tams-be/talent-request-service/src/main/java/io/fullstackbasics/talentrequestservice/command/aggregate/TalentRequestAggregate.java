package io.fullstackbasics.talentrequestservice.command.aggregate;

import fullstackbasics.io.tamscoreapi.command.UpdateTalentRequestStatusCommand;
import fullstackbasics.io.tamscoreapi.domain.CandidateSkills;
import fullstackbasics.io.tamscoreapi.domain.JobDescription;
import fullstackbasics.io.tamscoreapi.domain.RequestStatus;
import io.fullstackbasics.talentrequestservice.command.command.CreateTalentRequestCommand;
import io.fullstackbasics.talentrequestservice.core.events.TalentRequestCreatedEvent;
import io.fullstackbasics.talentrequestservice.core.events.TalentRequestStatusUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Aggregate
public class TalentRequestAggregate {

    @AggregateIdentifier
    private String talentRequestId;
    private String talentRequestTitle;
    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RequestStatus requestStatus;
    private LocalDate startDate;

    public TalentRequestAggregate() {
    }

    @CommandHandler
    public TalentRequestAggregate(CreateTalentRequestCommand createTalentRequestCommand) {
        TalentRequestCreatedEvent talentRequestCreatedEvent = new TalentRequestCreatedEvent();
        BeanUtils.copyProperties(createTalentRequestCommand, talentRequestCreatedEvent);

        AggregateLifecycle.apply(talentRequestCreatedEvent);
    }

    @EventSourcingHandler
    public void on(TalentRequestCreatedEvent talentRequestCreatedEvent){
        this.talentRequestId = talentRequestCreatedEvent.getTalentRequestId();
        this.talentRequestTitle = talentRequestCreatedEvent.getTalentRequestTitle();
        this.jobDescription = talentRequestCreatedEvent.getJobDescription();
        this.candidateSkills = talentRequestCreatedEvent.getCandidateSkills();
        this.requestStatus = talentRequestCreatedEvent.getRequestStatus();
        this.startDate = talentRequestCreatedEvent.getStartDate();
    }

    @CommandHandler
    public void handle(UpdateTalentRequestStatusCommand updateTalentRequestStatusCommand){
        TalentRequestStatusUpdatedEvent talentRequestStatusUpdatedEvent = new TalentRequestStatusUpdatedEvent();
        BeanUtils.copyProperties(updateTalentRequestStatusCommand, talentRequestStatusUpdatedEvent);

        AggregateLifecycle.apply(talentRequestStatusUpdatedEvent);
    }

    @EventSourcingHandler
    public void on(TalentRequestStatusUpdatedEvent talentRequestStatusUpdatedEvent){
        requestStatus = talentRequestStatusUpdatedEvent.getRequestStatus();
    }



}
