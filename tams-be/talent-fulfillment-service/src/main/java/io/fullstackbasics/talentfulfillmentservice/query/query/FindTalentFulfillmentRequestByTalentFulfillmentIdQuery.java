package io.fullstackbasics.talentfulfillmentservice.query.query;

import lombok.Data;

@Data
public class FindTalentFulfillmentRequestByTalentFulfillmentIdQuery {

    private String talentFulfillmentId;

    public FindTalentFulfillmentRequestByTalentFulfillmentIdQuery(String talentFulfillmentId) {
        this.talentFulfillmentId = talentFulfillmentId;
    }
}
