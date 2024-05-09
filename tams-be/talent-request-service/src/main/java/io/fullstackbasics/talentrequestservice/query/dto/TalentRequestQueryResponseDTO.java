package io.fullstackbasics.talentrequestservice.query.dto;

import fullstackbasics.io.tamscoreapi.domain.CandidateSkills;
import fullstackbasics.io.tamscoreapi.domain.JobDescription;
import fullstackbasics.io.tamscoreapi.domain.RequestStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TalentRequestQueryResponseDTO {

    private String talentRequestId;
    private String talentRequestTitle;

    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;

    private RequestStatus requestStatus;
    private LocalDate startDate;


}
