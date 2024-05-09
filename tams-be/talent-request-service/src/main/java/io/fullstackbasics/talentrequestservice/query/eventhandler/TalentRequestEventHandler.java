package io.fullstackbasics.talentrequestservice.query.eventhandler;

import io.fullstackbasics.talentrequestservice.core.events.TalentRequestCreatedEvent;
import io.fullstackbasics.talentrequestservice.core.events.TalentRequestStatusUpdatedEvent;
import io.fullstackbasics.talentrequestservice.query.repository.TalentRequest;
import io.fullstackbasics.talentrequestservice.query.repository.TalentRequestRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TalentRequestEventHandler {

    private TalentRequestRepository talentRequestRepository;

    public TalentRequestEventHandler(TalentRequestRepository talentRequestRepository) {
        this.talentRequestRepository = talentRequestRepository;
    }

    @EventHandler
    public void on(TalentRequestCreatedEvent talentRequestCreatedEvent){

        TalentRequest talentRequest = new TalentRequest();
        BeanUtils.copyProperties(talentRequestCreatedEvent,talentRequest);
        talentRequestRepository.save(talentRequest);

    }


    @EventHandler
    public void on(TalentRequestStatusUpdatedEvent talentRequestStatusUpdatedEvent){
        TalentRequest talentRequest =
                talentRequestRepository.findById(talentRequestStatusUpdatedEvent.getTalentRequestId()).get();

        talentRequest.setRequestStatus(talentRequestStatusUpdatedEvent.getRequestStatus());

        talentRequestRepository.save(talentRequest);
    }

}
