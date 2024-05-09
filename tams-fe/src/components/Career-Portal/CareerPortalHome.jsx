import { Link } from "react-router-dom";

function CareerPortalHome() {
  return (
    <>
      <section className="heading">
        <h1>Welcome to our</h1>
        <h1>Careers Portal</h1>
        <p>View job openings in our company</p>
      </section>
      <Link to="/career-portal/job-posts" className="btn btn-block">
        View All Job Openings
      </Link>
    </>
  );
}

export default CareerPortalHome;
