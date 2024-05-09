import React from "react";
import { Link } from "react-router-dom";

function TAMSHome() {
  return (
    <>
      <section className="heading">
        <h3>Welcome to the</h3>
        <h3>Talent Acquisition Management System</h3>
      </section>

      <Link to="/hiring-manager" className="btn btn-block">
        Hiring Managers click here
      </Link>
      <Link to="/talent-fulfillment" className="btn btn-block">
        Talent Acquisition Specialists click here
      </Link>
      <Link to="/career-portal" className="btn btn-block">
        To view job openings in our Career Portal click here
      </Link>
    </>
  );
}

export default TAMSHome;
