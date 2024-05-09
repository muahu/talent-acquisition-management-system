package io.fullstackbasics.talentrequestservice.query.query;

import io.fullstackbasics.talentrequestservice.command.dto.TalentRequestResponseDTO;
import io.fullstackbasics.talentrequestservice.query.dto.TalentRequestQueryResponseDTO;
import io.fullstackbasics.talentrequestservice.query.repository.TalentRequest;
import io.fullstackbasics.talentrequestservice.query.repository.TalentRequestRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TalentRequestsQueryHandler {

    private final TalentRequestRepository talentRequestRepository;

    public TalentRequestsQueryHandler(TalentRequestRepository talentRequestRepository) {
        this.talentRequestRepository = talentRequestRepository;
    }

    @QueryHandler
    public List<TalentRequestQueryResponseDTO> findAllTalentRequests(FindTalentRequestsQuery findTalentRequestsQuery){
        List<TalentRequestQueryResponseDTO> talentRequestQueryResponseDTOList = new ArrayList<>();
        generateTalentRequestDTOListFromDatabase(talentRequestQueryResponseDTOList);
        return talentRequestQueryResponseDTOList;
    }

    @QueryHandler
    public TalentRequestQueryResponseDTO findTalentRequestByTalentRequestId(FindTalentRequestByTalentRequestIdQuery findTalentRequestByTalentRequestIdQuery){

        TalentRequestQueryResponseDTO talentRequestQueryResponseDTO = new TalentRequestQueryResponseDTO();
        TalentRequest talentRequest = talentRequestRepository.findById(findTalentRequestByTalentRequestIdQuery.getTalentRequestId()).get();
        BeanUtils.copyProperties(talentRequest, talentRequestQueryResponseDTO);

        return talentRequestQueryResponseDTO;

    }


    private void generateTalentRequestDTOListFromDatabase(List<TalentRequestQueryResponseDTO> talentRequestQueryResponseDTOList) {
        List<TalentRequest> talentRequestList = talentRequestRepository.findAll();
        for (TalentRequest talentRequest : talentRequestList) {
            TalentRequestQueryResponseDTO talentRequestQueryResponseDTO = new TalentRequestQueryResponseDTO();
            BeanUtils.copyProperties(talentRequest, talentRequestQueryResponseDTO);
            talentRequestQueryResponseDTOList.add(talentRequestQueryResponseDTO);
        }
    }

}
