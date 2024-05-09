package io.fullstackbasics.talentrequestservice.query.repository;

import fullstackbasics.io.tamscoreapi.domain.CandidateSkills;
import fullstackbasics.io.tamscoreapi.domain.JobDescription;
import fullstackbasics.io.tamscoreapi.domain.RequestStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class TalentRequest {

    @Id
    private String talentRequestId;
    private String talentRequestTitle;

    @Embedded
    private JobDescription jobDescription;
    @Embedded
    private CandidateSkills candidateSkills;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    private LocalDate startDate;

}
