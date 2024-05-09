package io.fullstackbasics.talentfulfillmentservice.command.command;

import fullstackbasics.io.tamscoreapi.domain.*;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

@Data
@Builder
public class SubmitTalentFulfillmentDecisionCommand {

    @TargetAggregateIdentifier
    private String talentFulfillmentId;
    private String jobPostId;
    private String talentRequestId;
    private String talentRequestTitle;
    private LocalDate startDate;

    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RequestStatus requestStatus;
    private RoleLevel roleLevel;
    private EmploymentType employmentType;
}
