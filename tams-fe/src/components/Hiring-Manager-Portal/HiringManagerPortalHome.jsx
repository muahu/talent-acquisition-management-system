import React from "react";
import { Link } from "react-router-dom";

function HiringManagerPortalHome() {
  return (
    <>
      <section className="heading">
        <h1>Welcome to the</h1>
        <h1>Hiring Manager's Portal</h1>
        <p>
          You may submit a new talent request or review the status of previous
          requests
        </p>
      </section>

      <Link to="/create-talent-request" className="btn btn-reverse btn-block">
        Create New Talent Request
      </Link>

      <Link to="/get-all-talent-requests" className="btn btn-block">
        View All Talent Requests
      </Link>
    </>
  );
}

export default HiringManagerPortalHome;
