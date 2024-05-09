import React from "react";
import BackButton from "../BackButton";

function ApprovedTalentFulfillmentByIdView({ approvedTalentFulfillment }) {
  return (
    <div className="talent-request-page">
      <header className="talent-request-header">
        <BackButton
          url="/get-all-talent-fulfillment-requests"
          buttonName="Back to Talent Fulfillment View"
        />

        <div className="talent-request-description">
          <h4>Talent Request Id</h4>
          <p>{approvedTalentFulfillment?.talentRequestId}</p>
          <br />
          <h4>Talent Fulfillment Id</h4>
          <p>{approvedTalentFulfillment?.talentFulfillmentId}</p>
        </div>

        <h2>
          {approvedTalentFulfillment?.talentRequestTitle}
          <span
            className={`status status-${approvedTalentFulfillment?.requestStatus}`}
          >
            {approvedTalentFulfillment?.requestStatus}
          </span>
        </h2>

        <h3>
          Start Date:{" "}
          {new Date(approvedTalentFulfillment?.startDate).toLocaleDateString(
            "en-US",
            { timeZone: "UTC" }
          )}
        </h3>
        <hr />

        <div className="talent-request-description">
          <h3>Job Description</h3>
          <h4>Responsibilities</h4>
          <p>{approvedTalentFulfillment.jobDescription?.responsibilities}</p>
          <br />
          <h4>Qualifications</h4>
          <p>{approvedTalentFulfillment.jobDescription?.qualifications}</p>
        </div>

        <div className="talent-request-description">
          <h3>Candidate Skills</h3>
          <h4>Core Technical Skill</h4>
          <p>{approvedTalentFulfillment.candidateSkills?.coreSkill}</p>
          <br />
          <h4>Employment Type</h4>
          <p>{approvedTalentFulfillment.candidateSkills?.skillLevel}</p>
        </div>

        <div className="talent-request-description">
          <h3>Job Post Id</h3>
          <p>{approvedTalentFulfillment?.jobPostId}</p>
          <br />
          <h4>Role Level</h4>
          <p>{approvedTalentFulfillment?.roleLevel}</p>
          <br />
          <h4>Employment Type</h4>
          <p>{approvedTalentFulfillment?.employmentType}</p>
        </div>

        <br />
      </header>
    </div>
  );
}

export default ApprovedTalentFulfillmentByIdView;
