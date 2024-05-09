package io.fullstackbasics.talentrequestservice.core.events;

import fullstackbasics.io.tamscoreapi.domain.RequestStatus;
import lombok.Data;

@Data
public class TalentRequestStatusUpdatedEvent {

    private String talentRequestId;
    private RequestStatus requestStatus;
}
