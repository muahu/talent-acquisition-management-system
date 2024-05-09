import React from "react";
import { Link } from "react-router-dom";

function TalentRequestItem({ talentRequest }) {
  return (
    <div className="talent-request">
      <div>{talentRequest.talentRequestTitle}</div>
      <div>
        {new Date(talentRequest.startDate).toLocaleDateString("en-US", {
          timeZone: "UTC",
        })}
      </div>
      <div className={`status status-${talentRequest.requestStatus}`}>
        {talentRequest.requestStatus}
      </div>

      <Link
        to={`/talent-request/${talentRequest.talentRequestId}`}
        className="btn btn-sm"
      >
        View Talent Request
      </Link>
    </div>
  );
}

export default TalentRequestItem;
