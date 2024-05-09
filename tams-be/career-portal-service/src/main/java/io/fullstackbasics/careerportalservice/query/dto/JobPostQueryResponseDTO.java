package io.fullstackbasics.careerportalservice.query.dto;

import fullstackbasics.io.tamscoreapi.domain.CandidateSkills;
import fullstackbasics.io.tamscoreapi.domain.EmploymentType;
import fullstackbasics.io.tamscoreapi.domain.JobDescription;
import fullstackbasics.io.tamscoreapi.domain.RoleLevel;
import lombok.Data;

@Data
public class JobPostQueryResponseDTO {

    private String jobPostId;
    private String talentRequestTitle;
    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RoleLevel roleLevel;
    private EmploymentType employmentType;
}
