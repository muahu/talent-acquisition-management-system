import React from "react";
import { useState } from "react";
import { useDispatch } from "react-redux";
import {
  approveTalentFulfillmentJobPost,
  reset,
} from "../../features/TalentFulfillment/talentFulfillmentSlice";
import { useNavigate } from "react-router-dom";
import BackButton from "../BackButton";

function UpdateAndApproveTalentFulfillmentByIdView({
  assignedTalentFulfillment,
}) {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const [talentFulfillment, setTalentFulfillment] = useState({
    talentFulfillmentId: assignedTalentFulfillment?.talentFulfillmentId,
    talentRequestId: assignedTalentFulfillment?.talentRequestId,
    talentRequestTitle: assignedTalentFulfillment?.talentRequestTitle,
    requestStatus: assignedTalentFulfillment?.requestStatus,
    jobPostId: assignedTalentFulfillment?.jobPostId,
    jobDescription: {
      responsibilities:
        assignedTalentFulfillment?.jobDescription?.responsibilities,
      qualifications: assignedTalentFulfillment?.jobDescription?.qualifications,
    },
    candidateSkills: {
      coreSkill: assignedTalentFulfillment?.candidateSkills?.coreSkill,
      skillLevel: assignedTalentFulfillment?.candidateSkills?.skillLevel,
    },
    startDate: assignedTalentFulfillment?.startDate,

    roleLevel: "",
    employmentType: "",
  });

  const onChange = (event) =>
    setTalentFulfillment({
      ...talentFulfillment,
      [event.target.name]: event.target.value,
    });

  const onApproveJobPost = (event) => {
    event.preventDefault();
    dispatch(approveTalentFulfillmentJobPost(talentFulfillment));
    dispatch(reset());
    navigate("/get-all-talent-fulfillment-requests");
  };

  return (
    <div className="talent-request-page">
      <BackButton
        url="/get-all-talent-fulfillment-requests"
        buttonName="Back to Talent Fulfillment View"
      />

      <section className="heading">
        <h4>Update New Talent Request & Approve Job Post</h4>
      </section>

      <h2>
        {talentFulfillment?.talentRequestTitle}
        <span className={`status status-${talentFulfillment?.requestStatus}`}>
          {talentFulfillment?.requestStatus}
        </span>
      </h2>

      <h3>
        Start Date:{" "}
        {new Date(talentFulfillment?.startDate).toLocaleDateString("en-US", {
          timeZone: "UTC",
        })}
      </h3>
      <hr />

      <div className="talent-request-description">
        <h4>Talent Request Id</h4>
        <p>{talentFulfillment?.talentRequestId}</p>
        <br />
        <h4>Talent Fulfillment Id</h4>
        <p>{talentFulfillment?.talentFulfillmentId}</p>
      </div>

      <div className="talent-request-description">
        <h3>Job Description</h3>
        <h4>Responsibilities</h4>
        <p>{talentFulfillment?.jobDescription?.responsibilities}</p>
        <br />
        <h4>Qualifications</h4>
        <p>{talentFulfillment?.jobDescription?.qualifications}</p>
      </div>

      <div className="talent-request-description">
        <h3>Candidate Skills</h3>
        <h4>Core Technical Skill</h4>
        <p>{talentFulfillment?.candidateSkills?.coreSkill}</p>
        <br />
        <h4>Skill Level</h4>
        <p>{talentFulfillment?.candidateSkills?.skillLevel}</p>
      </div>

      <form onSubmit={onApproveJobPost}>
        <div className="form-group">
          <label htmlFor="">Role Level</label>
          <select
            name="roleLevel"
            className="form-control"
            value={talentFulfillment?.roleLevel}
            onChange={onChange}
          >
            <option value="">Select Role Level</option>
            <option value="INDIVIDUAL_CONTRIBUTOR">
              Individual Contributor
            </option>
            <option value="LEADERSHIP">Leadership</option>
          </select>
        </div>

        <div className="form-group">
          <label htmlFor="">Employment Type</label>
          <select
            name="employmentType"
            className="form-control"
            value={talentFulfillment?.employmentType}
            onChange={onChange}
          >
            <option value="">Select Employment Type</option>
            <option value="FULL_TIME">Full Time</option>
            <option value="CONTRACT">Contract</option>
          </select>
        </div>

        <div className="form-group">
          <label htmlFor="">Approved</label>
          <select
            name="requestStatus"
            className="form-control"
            value={talentFulfillment?.requestStatus}
            onChange={onChange}
          >
            <option value="">Do you approve?</option>
            <option value="APPROVED">APPROVED</option>
          </select>
        </div>

        <div className="form-group">
          <button className="btn btn-block">Approve Job Post</button>
        </div>
      </form>
    </div>
  );
}

export default UpdateAndApproveTalentFulfillmentByIdView;
