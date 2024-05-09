import React from "react";
import { Link } from "react-router-dom";

function TalentFulfillmentPortalHome() {
  
  return (
    <>
      <section className="heading">
        <h1>Welcome to the</h1>
        <h1>Talent Fulfillment Portal</h1>
        <p>Review Talent Requests and Create Job Posts</p>
      </section>

      <Link to="/get-all-talent-fulfillment-requests" className="btn btn-block">
        View All Talent Requests
      </Link>
    </>
  );
}

export default TalentFulfillmentPortalHome;
