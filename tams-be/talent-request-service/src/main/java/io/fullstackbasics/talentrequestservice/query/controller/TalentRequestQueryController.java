package io.fullstackbasics.talentrequestservice.query.controller;

import io.fullstackbasics.talentrequestservice.query.service.TalentRequestQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("talent-request")
public class TalentRequestQueryController {

    private final TalentRequestQueryService talentRequestQueryService;

    public TalentRequestQueryController(TalentRequestQueryService talentRequestQueryService) {
        this.talentRequestQueryService = talentRequestQueryService;
    }

    @GetMapping
    public ResponseEntity findAllTalentRequests(){
        return talentRequestQueryService.findAllTalentRequests();
    }

    @GetMapping("/{talentRequestId}")
    public ResponseEntity findTalentRequestByTalentRequestId(@PathVariable String talentRequestId) throws ExecutionException, InterruptedException {
        return talentRequestQueryService.findTalentRequestByTalentRequestId(talentRequestId);

    }


}
