import { useEffect } from "react";
import { toast } from "react-toastify";
import { useSelector, useDispatch } from "react-redux";
import { getTalentRequestById } from "../../features/TalentRequest/talentRequestSlice";
import { useParams } from "react-router-dom";
import BackButton from "../BackButton";
import LoadingSpinner from "../LoadingSpinner";

function TalentRequestByIdView() {
  const {
    talentRequest: {
      talentRequestTitle,
      requestStatus,
      startDate,
      jobDescription,
      candidateSkills,
    },
    isError,
    message,
    isLoading,
  } = useSelector((state) => state.talentRequests);

  const dispatch = useDispatch();

  const { talentRequestId } = useParams();

  useEffect(() => {
    if (isError) {
      toast.error(message);
    }

    dispatch(getTalentRequestById(talentRequestId));
  }, [isError, message, talentRequestId, dispatch]);

  if (isLoading) {
    return <LoadingSpinner />;
  }

  if (isError) {
    return <h3>Something Went Wrong</h3>;
  }

  return (
    <div className="talent-request-page">
      <div className="talent-request-header">
        <BackButton
          url="/get-all-talent-requests"
          buttonName="Back to Talent Requests"
        />
        <h2>
          {talentRequestTitle}
          <span className={`status status-${requestStatus}`}>
            {requestStatus}
          </span>
        </h2>

        <h3>
          Start Date:{" "}
          {new Date(startDate).toLocaleDateString("en-US", { timeZone: "UTC" })}
        </h3>
        <hr />

        <div className="talent-request-description">
          <h3>Job Description</h3>
          <h4>Responsibilities</h4>
          <p>{jobDescription?.responsibilities}</p>
          <br />
          <h4>Qualifications</h4>
          <p>{jobDescription?.qualifications}</p>
        </div>

        <div className="talent-request-description">
          <h3>Candidate Skills</h3>
          <h4>Core Technical Skill</h4>
          <p>{candidateSkills?.coreSkill}</p>
          <br />
          <h4>Skill Level</h4>
          <p>{candidateSkills?.skillLevel}</p>
        </div>
      </div>
    </div>
  );
}

export default TalentRequestByIdView;
