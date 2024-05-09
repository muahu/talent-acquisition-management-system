import { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import {
  getAllJobPosts,
  reset,
} from "../../features/CareerPortal/careerPortalSlice";
import JobPostItem from "./JobPostItem";

function JobPostsView() {
  const { jobPosts, isSuccess } = useSelector((state) => state.jobPosts);

  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getAllJobPosts());
  }, [dispatch]);

  useEffect(() => {
    return () => {
      if (isSuccess) {
        dispatch(reset());
      }
    };
  }, [dispatch, isSuccess]);

  return (
    <>
      <h1>Job Posts</h1>

      <div className="talent-requests">
        <div className="talent-request-headings">
          <div>Job Title</div>
          <div>Core Skill</div>
          <div>Employment Type</div>
          <div>Actions</div>
        </div>
        {jobPosts.map((jobPost) => (
          <JobPostItem key={jobPost.jobPostId} jobPost={jobPost} />
        ))}
      </div>
    </>
  );
}

export default JobPostsView;
