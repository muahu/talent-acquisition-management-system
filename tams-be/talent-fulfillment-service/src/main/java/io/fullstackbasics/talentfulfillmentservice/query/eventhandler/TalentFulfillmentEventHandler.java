package io.fullstackbasics.talentfulfillmentservice.query.eventhandler;

import fullstackbasics.io.tamscoreapi.event.TalentFulfillmentCreatedEvent;
import io.fullstackbasics.talentfulfillmentservice.core.events.TalentFulfillmentDecisionSubmittedEvent;
import io.fullstackbasics.talentfulfillmentservice.query.repository.TalentFulfillment;
import io.fullstackbasics.talentfulfillmentservice.query.repository.TalentFulfillmentRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TalentFulfillmentEventHandler {

    private TalentFulfillmentRepository talentFulfillmentRepository;

    public TalentFulfillmentEventHandler(TalentFulfillmentRepository talentFulfillmentRepository) {
        this.talentFulfillmentRepository = talentFulfillmentRepository;
    }

    @EventHandler
    public void on(TalentFulfillmentCreatedEvent talentFulfillmentCreatedEvent){
        TalentFulfillment talentFulfillment = new TalentFulfillment();
        BeanUtils.copyProperties(talentFulfillmentCreatedEvent, talentFulfillment);

        talentFulfillmentRepository.save(talentFulfillment);
    }

    @EventHandler
    public void on(TalentFulfillmentDecisionSubmittedEvent talentFulfillmentDecisionSubmittedEvent){

        TalentFulfillment talentFulfillment = talentFulfillmentRepository.findById(talentFulfillmentDecisionSubmittedEvent.getTalentFulfillmentId()).get();

        BeanUtils.copyProperties(talentFulfillmentDecisionSubmittedEvent, talentFulfillment);
        talentFulfillmentRepository.save(talentFulfillment);

    }



}
