import { Link } from "react-router-dom";

function TalentFulfillmentItem({ talentFulfillment }) {
  return (
    <div className="talent-request">
      <div>{talentFulfillment.talentRequestTitle}</div>
      <div>
        {new Date(talentFulfillment.startDate).toLocaleDateString("en-US", {
          timeZone: "UTC",
        })}
      </div>
      <div className={`status status-${talentFulfillment.requestStatus}`}>
        {talentFulfillment.requestStatus}
      </div>
      <Link
        to={`/talent-fulfillment/${talentFulfillment.talentFulfillmentId}`}
        className="btn btn-sm"
      >
        View & Approve Talent Request
      </Link>
    </div>
  );
}

export default TalentFulfillmentItem;
