package fullstackbasics.io.tamscoreapi.event;

import fullstackbasics.io.tamscoreapi.domain.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class JobPostCreatedEvent {

    private String jobPostId;
    private String talentFulfillmentId;
    private String talentRequestId;
    private String talentRequestTitle;
    private LocalDate startDate;

    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RequestStatus requestStatus;
    private RoleLevel roleLevel;
    private EmploymentType employmentType;
}
