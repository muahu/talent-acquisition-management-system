package io.fullstackbasics.talentfulfillmentservice.query.service;

import io.fullstackbasics.talentfulfillmentservice.query.dto.TalentFulfillmentQueryResponseDTO;
import io.fullstackbasics.talentfulfillmentservice.query.query.FindTalentFulfillmentRequestByTalentFulfillmentIdQuery;
import io.fullstackbasics.talentfulfillmentservice.query.query.FindTalentFulfillmentRequestsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class TalentFulfillmentQueryService {
    private final QueryGateway queryGateway;

    public TalentFulfillmentQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public ResponseEntity findAllTalentFulfillment(){
        FindTalentFulfillmentRequestsQuery findTalentFulfillmentRequestsQuery
                = new FindTalentFulfillmentRequestsQuery();
        List<TalentFulfillmentQueryResponseDTO> talentFulfillmentQueryResponseDTOList =
                queryGateway.query(findTalentFulfillmentRequestsQuery, ResponseTypes.multipleInstancesOf(TalentFulfillmentQueryResponseDTO.class)).join();

        return new ResponseEntity(talentFulfillmentQueryResponseDTOList, HttpStatus.OK);
    }

    public ResponseEntity findTalentFulfillmentByTalentFulfillmentId(String talentFulfillmentId) throws ExecutionException, InterruptedException {
        FindTalentFulfillmentRequestByTalentFulfillmentIdQuery findTalentFulfillmentRequestByTalentFulfillmentIdQuery
                = new FindTalentFulfillmentRequestByTalentFulfillmentIdQuery(talentFulfillmentId);
        TalentFulfillmentQueryResponseDTO talentFulfillmentQueryResponseDTO =
                queryGateway.query(findTalentFulfillmentRequestByTalentFulfillmentIdQuery, ResponseTypes.instanceOf(TalentFulfillmentQueryResponseDTO.class)).get();

        return new ResponseEntity(talentFulfillmentQueryResponseDTO, HttpStatus.OK);
    }
}
