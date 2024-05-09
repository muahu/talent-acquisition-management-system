package io.fullstackbasics.talentrequestservice.query.query;

import lombok.Data;

@Data
public class FindTalentRequestByTalentRequestIdQuery {

    private String talentRequestId;

    public FindTalentRequestByTalentRequestIdQuery(String talentRequestId) {
        this.talentRequestId = talentRequestId;
    }
}
