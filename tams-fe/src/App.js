import React from "react";
import Home from "./pages/TAMSHome";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/Header";
import HiringManagerPortalHome from "./components/Hiring-Manager-Portal/HiringManagerPortalHome";
import CareerPortalHome from "./components/Career-Portal/CareerPortalHome";
import TalentAcquisitionPortalHome from "./components/Talent-Acquisition-Portal/TalentFulfillmentPortalHome";
import CreateTalentRequestForm from "./components/Hiring-Manager-Portal/CreateTalentRequestForm";
import { ToastContainer } from "react-toastify";
import TalentRequestsView from "./components/Hiring-Manager-Portal/TalentRequestsView";
import TalentRequestByIdView from "./components/Hiring-Manager-Portal/TalentRequestByIdView";
import TalentFulfillmentsView from "./components/Talent-Acquisition-Portal/TalentFulfillmentsView";
import TalentFulfillmentByIdView from "./components/Talent-Acquisition-Portal/TalentFulfillmentByIdView"
import JobPostsView from "./components/Career-Portal/JobPostsView";
import JobPostByIdView from "./components/Career-Portal/JobPostByIdView";
function App() {
  return (
    <>
      <Router>
        <div className="container">
          <Header />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route
              exact
              path="/hiring-manager"
              element={<HiringManagerPortalHome />}
            />

            <Route
              exact
              path="/get-all-talent-requests"
              element={<TalentRequestsView />}
            />

            <Route
              path="/talent-request/:talentRequestId"
              element={<TalentRequestByIdView />}
            />

            <Route
              exact
              path="/create-talent-request"
              element={<CreateTalentRequestForm />}
            />

            <Route
              exact
              path="/talent-fulfillment"
              element={<TalentAcquisitionPortalHome />}
            />
            <Route
              exact
              path="/get-all-talent-fulfillment-requests"
              element={<TalentFulfillmentsView />}
            />
            <Route
              path="/talent-fulfillment/:talentFulfillmentId"
              element={<TalentFulfillmentByIdView />}
            />
            <Route exact path="/career-portal" element={<CareerPortalHome />} />
            <Route path="/career-portal/job-posts" element={<JobPostsView />} />
            <Route
              path="/career-portal/job-post/:jobPostId"
              element={<JobPostByIdView />}
            />

          </Routes>
        </div>
      </Router>

      <ToastContainer />
    </>
  );
}

export default App;
