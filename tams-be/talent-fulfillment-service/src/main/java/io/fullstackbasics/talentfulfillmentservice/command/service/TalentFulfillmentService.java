package io.fullstackbasics.talentfulfillmentservice.command.service;

import fullstackbasics.io.tamscoreapi.domain.RequestStatus;
import io.fullstackbasics.talentfulfillmentservice.command.command.SubmitTalentFulfillmentDecisionCommand;
import io.fullstackbasics.talentfulfillmentservice.query.repository.TalentFulfillment;
import io.fullstackbasics.talentfulfillmentservice.query.repository.TalentFulfillmentRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TalentFulfillmentService {

    private final CommandGateway commandGateway;
    private TalentFulfillmentRepository talentFulfillmentRepository;

    public TalentFulfillmentService(CommandGateway commandGateway, TalentFulfillmentRepository talentFulfillmentRepository) {
        this.commandGateway = commandGateway;
        this.talentFulfillmentRepository = talentFulfillmentRepository;
    }

    public ResponseEntity submitTalentFulfillmentDecision(SubmitTalentFulfillmentDecisionCommand submitTalentFulfillmentDecisionCommand){

        TalentFulfillment talentFulfillment = talentFulfillmentRepository.findById(submitTalentFulfillmentDecisionCommand.getTalentFulfillmentId()).get();

        if (talentFulfillment.getJobPostId()!= null){
            return new ResponseEntity("Job Post Id " + talentFulfillment.getJobPostId() + " is already " + talentFulfillment.getRequestStatus() + " ", HttpStatus.BAD_REQUEST);
        }

        if (submitTalentFulfillmentDecisionCommand.getRequestStatus().equals(RequestStatus.APPROVED)){
            submitTalentFulfillmentDecisionCommand.setJobPostId(UUID.randomUUID().toString());
            commandGateway.sendAndWait(submitTalentFulfillmentDecisionCommand);
            return new ResponseEntity(submitTalentFulfillmentDecisionCommand, HttpStatus.OK);
        }

        return new ResponseEntity("Not Approved",HttpStatus.BAD_REQUEST);
    }

}


