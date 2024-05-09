package io.fullstackbasics.talentrequestservice.command.dto;

import fullstackbasics.io.tamscoreapi.domain.RequestStatus;
import lombok.Data;

@Data
public class TalentRequestResponseDTO {

    private String talentRequestId;
    private String talentRequestTitle;
    private RequestStatus requestStatus;
}
