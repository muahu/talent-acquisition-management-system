import { Link } from "react-router-dom";

function JobPostItem({ jobPost }) {
  return (
    <div className="talent-request">
      <div>{jobPost.talentRequestTitle}</div>
      <div>{jobPost.candidateSkills?.skillLevel}</div>
      <div>{jobPost.employmentType}</div>
      <Link
        to={`/career-portal/job-post/${jobPost.jobPostId}`}
        className="btn btn-sm"
      >
        View Job Post
      </Link>
    </div>
  );
}

export default JobPostItem;
