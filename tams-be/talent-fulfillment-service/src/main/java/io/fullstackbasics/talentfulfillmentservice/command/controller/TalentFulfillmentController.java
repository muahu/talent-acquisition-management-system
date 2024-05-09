package io.fullstackbasics.talentfulfillmentservice.command.controller;

import io.fullstackbasics.talentfulfillmentservice.command.command.SubmitTalentFulfillmentDecisionCommand;
import io.fullstackbasics.talentfulfillmentservice.command.service.TalentFulfillmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talent-fulfillment")
public class TalentFulfillmentController {

    private TalentFulfillmentService talentFulfillmentService;

    public TalentFulfillmentController(TalentFulfillmentService talentFulfillmentService) {
        this.talentFulfillmentService = talentFulfillmentService;
    }

    @PostMapping("/job-post")
    public ResponseEntity submitTalentFulfillmentDecision(@RequestBody SubmitTalentFulfillmentDecisionCommand submitTalentFulfillmentDecisionCommand){
        return talentFulfillmentService.submitTalentFulfillmentDecision(submitTalentFulfillmentDecisionCommand);
    }
}
