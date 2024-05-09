package io.fullstackbasics.talentfulfillmentservice.query.controller;

import io.fullstackbasics.talentfulfillmentservice.query.service.TalentFulfillmentQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/talent-fulfillment")
public class TalentFulfillmentQueryController {

    private TalentFulfillmentQueryService talentFulfillmentQueryService;

    public TalentFulfillmentQueryController(TalentFulfillmentQueryService talentFulfillmentQueryService) {
        this.talentFulfillmentQueryService = talentFulfillmentQueryService;
    }

    @GetMapping
    public ResponseEntity findAllTalentFulfillmentRequests(){

        return talentFulfillmentQueryService.findAllTalentFulfillment();

    }

    @GetMapping("/{talentFulfillmentId}")
    public ResponseEntity findFulfillmentRequestByTalentFulfillmentId(@PathVariable String talentFulfillmentId) throws ExecutionException, InterruptedException {
        return talentFulfillmentQueryService.findTalentFulfillmentByTalentFulfillmentId(talentFulfillmentId);
    }


}
