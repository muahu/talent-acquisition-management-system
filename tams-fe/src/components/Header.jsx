import React from "react";
import { Link } from "react-router-dom";

function Header() {
  return (
    <header className="header">
      <div className="logo">
        <Link to="/">Home</Link>
      </div>
      <div className="logo">
        <Link to="/hiring-manager">Hiring Manager's Portal</Link>
      </div>
      <div className="logo">
        <Link to="/talent-fulfillment">Talent Fullfillment Portal</Link>
      </div>
      <div className="logo">
        <Link to="/career-portal">Careers Portal</Link>
      </div>
    </header>
  );
}

export default Header;
