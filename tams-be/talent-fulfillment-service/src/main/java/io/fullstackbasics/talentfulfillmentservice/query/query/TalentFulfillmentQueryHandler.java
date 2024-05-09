package io.fullstackbasics.talentfulfillmentservice.query.query;

import io.fullstackbasics.talentfulfillmentservice.query.dto.TalentFulfillmentQueryResponseDTO;
import io.fullstackbasics.talentfulfillmentservice.query.repository.TalentFulfillment;
import io.fullstackbasics.talentfulfillmentservice.query.repository.TalentFulfillmentRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TalentFulfillmentQueryHandler {
    private TalentFulfillmentRepository talentFulfillmentRepository;

    public TalentFulfillmentQueryHandler(TalentFulfillmentRepository talentFulfillmentRepository) {
        this.talentFulfillmentRepository = talentFulfillmentRepository;
    }

    @QueryHandler
    public List<TalentFulfillmentQueryResponseDTO> findAllTalentFulfillmentRequests(FindTalentFulfillmentRequestsQuery findTalentFulfillmentRequestsQuery){
        List<TalentFulfillmentQueryResponseDTO> talentFulfillmentQueryResponseDTOList = new ArrayList<>();
        generateTalentFulfillmentDTOListFromDatabase(talentFulfillmentQueryResponseDTOList);

        return talentFulfillmentQueryResponseDTOList;
    }

    @QueryHandler
    public TalentFulfillmentQueryResponseDTO findTalentFulfillmentRequestByTalentFulfillmentId (FindTalentFulfillmentRequestByTalentFulfillmentIdQuery
                                                                                                        findTalentFulfillmentRequestByTalentFulfillmentIdQuery){
        TalentFulfillmentQueryResponseDTO talentFulfillmentQueryResponseDTO = new TalentFulfillmentQueryResponseDTO();
        TalentFulfillment talentFulfillment = talentFulfillmentRepository.findById
                (findTalentFulfillmentRequestByTalentFulfillmentIdQuery.getTalentFulfillmentId()).get();

        BeanUtils.copyProperties(talentFulfillment, talentFulfillmentQueryResponseDTO);

        return talentFulfillmentQueryResponseDTO;
    }

    private void generateTalentFulfillmentDTOListFromDatabase(List<TalentFulfillmentQueryResponseDTO> talentFulfillmentQueryResponseDTOList) {
        List<TalentFulfillment> talentFulfillmentList = talentFulfillmentRepository.findAll();

        for(TalentFulfillment talentFulfillment: talentFulfillmentList){
            TalentFulfillmentQueryResponseDTO talentFulfillmentQueryResponseDTO = new TalentFulfillmentQueryResponseDTO();
            BeanUtils.copyProperties(talentFulfillment, talentFulfillmentQueryResponseDTO);
            talentFulfillmentQueryResponseDTOList.add(talentFulfillmentQueryResponseDTO);
        }
    }
}
