package io.fullstackbasics.talentrequestservice.query.service;

import io.fullstackbasics.talentrequestservice.query.dto.TalentRequestQueryResponseDTO;
import io.fullstackbasics.talentrequestservice.query.query.FindTalentRequestByTalentRequestIdQuery;
import io.fullstackbasics.talentrequestservice.query.query.FindTalentRequestsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class TalentRequestQueryService {

    private final QueryGateway queryGateway;

    public TalentRequestQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public ResponseEntity findAllTalentRequests(){

        FindTalentRequestsQuery findTalentRequestsQuery = new FindTalentRequestsQuery();
        List<TalentRequestQueryResponseDTO> talentRequestQueryResponseDTOList =
                queryGateway.query(findTalentRequestsQuery, ResponseTypes.multipleInstancesOf(TalentRequestQueryResponseDTO.class)).join();

        return new ResponseEntity(talentRequestQueryResponseDTOList, HttpStatus.OK);
    }

    public ResponseEntity findTalentRequestByTalentRequestId (String talentRequestId) throws ExecutionException, InterruptedException {

        FindTalentRequestByTalentRequestIdQuery findTalentRequestByTalentRequestIdQuery
                = new FindTalentRequestByTalentRequestIdQuery(talentRequestId);

        TalentRequestQueryResponseDTO talentRequestQueryResponseDTO = queryGateway.query(findTalentRequestByTalentRequestIdQuery,
                ResponseTypes.instanceOf(TalentRequestQueryResponseDTO.class)).get();


        return new ResponseEntity(talentRequestQueryResponseDTO, HttpStatus.OK);

    }

    }
