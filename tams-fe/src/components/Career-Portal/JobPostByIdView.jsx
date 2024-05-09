import { useEffect } from "react";
import { toast } from "react-toastify";
import { useSelector, useDispatch } from "react-redux";
import { getJobPostById } from "../../features/CareerPortal/careerPortalSlice";
import { useParams } from "react-router-dom";
import BackButton from "../BackButton";
import LoadingSpinner from "../LoadingSpinner";

function JobPostByIdView() {
  const {
    jobPost: {
      talentRequestTitle,
      jobDescription,
      candidateSkills,
      roleLevel,
      employmentType,
    },
    isError,
    message,
    isLoading,
  } = useSelector((state) => state.jobPosts);

  const dispatch = useDispatch();

  const { jobPostId } = useParams();

  useEffect(() => {
    if (isError) {
      toast.error(message);
    }

    dispatch(getJobPostById(jobPostId));
    // eslint-disable-next-line
  }, [isError, message, jobPostId]);

  if (isLoading) {
    return <LoadingSpinner />;
  }

  if (isError) {
    return <h3>Something Went Wrong</h3>;
  }
  //issue Uncaught TypeError: Cannot read properties of undefined
  //https://www.udemy.com/course/react-front-to-back-2022/learn/lecture/30591272#questions/17329410/

  return (
    <div className="talent-request-page">
      <div className="talent-request-header">
        <BackButton
          url="/career-portal/job-posts"
          buttonName="Back to Job Openings"
        />
        <h2>{talentRequestTitle}</h2>

        <hr />

        <div className="talent-request-description">
          <h3>Job Post Id</h3>
          <p>{jobPostId}</p>
          <br />
          <h4>Role Level</h4>
          <p>{roleLevel}</p>
          <br />
          <h4>Employment Type</h4>
          <p>{employmentType}</p>
        </div>

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
      <br />
    </div>
  );
}

export default JobPostByIdView;
