import React from "react";
import { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import {
  createTalentRequest,
  reset,
} from '../../features/TalentRequest/talentRequestSlice'

import { toast } from "react-toastify";

import { useNavigate } from "react-router-dom";



function CreateTalentRequestForm() {
  const [talentRequest, setTalentRequest] = useState({
    talentRequestTitle: "",
    jobDescription: { responsibilities: "", qualifications: "" },
    candidateSkills: { coreSkill: "", skillLevel: "" },
    startDate: "",
  });

  //destructure
  const {
    talentRequestTitle,
    jobDescription: { responsibilities, qualifications },
    startDate,
    candidateSkills: { coreSkill, skillLevel },
  } = talentRequest;

  const dispatch = useDispatch();
  const navigate = useNavigate();


  const { isError, isSuccess, message } = useSelector(
    (state) => state.talentRequests
  );

  const onChange = (event) =>
    setTalentRequest({
      ...talentRequest,
      [event.target.name]: event.target.value,
    });

  const onChangeJobDescription = (event) =>
    setTalentRequest({
      ...talentRequest,
      jobDescription: {
        ...talentRequest.jobDescription,
        [event.target.name]: event.target.value,
      },
    });

  const onChangeCandidateSkills = (event) =>
    setTalentRequest({
      ...talentRequest,
      candidateSkills: {
        ...talentRequest.candidateSkills,
        [event.target.name]: event.target.value,
      },
    });


    useEffect(()=>{
      if(isError){
        toast.error(message)
      }

      if (isSuccess) {
        dispatch(reset());
        navigate("/get-all-talent-requests");
      }

     dispatch(reset());
    
    })


  const onSubmit = (e) => {
    e.preventDefault();

    dispatch(createTalentRequest(talentRequest));

    // console.log(JSON.stringify(talentRequest));
  };

  return (
    <>
      <section className="heading">
        <h4>Create New Talent Request</h4>
      </section>

      <form onSubmit={onSubmit}>
        <div className="form-group">
          <label htmlFor="talentRequestTitle">Talent Request Title</label>
          <input
            type="text"
            className="form-control"
            name="talentRequestTitle"
            value={talentRequestTitle}
            onChange={onChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="jobDescription">
            Job Description (Responsibilities & Qualifications)
          </label>
          <input
            type="text"
            name="responsibilities"
            placeholder="Responsibilities"
            className="form-control"
            value={responsibilities}
            onChange={onChangeJobDescription}
          />
          <input
            type="text"
            name="qualifications"
            placeholder="Qualifications"
            className="form-control"
            value={qualifications}
            onChange={onChangeJobDescription}
          />
        </div>

        <div className="form-group">
          <label htmlFor="candidateSkills">
            Candidate Skills (Core Skill & Skill Level)
          </label>
          <div className="form-group">
            <select
              name="coreSkill"
              className="form-control"
              value={coreSkill}
              onChange={onChangeCandidateSkills}
            >
              <option value="">Select Core Skill</option>
              <option value="JAVA">Java</option>
              <option value="PYTHON">Python</option>
              <option value="NODEJS">NodeJS</option>
              <option value="REACT">React</option>
              <option value="PROJECT_MANAGEMENT">Project Management</option>
              <option value="AGILE_COACH">Agile Coach</option>
            </select>
          </div>

          <div className="form-group">
            <select
              name="skillLevel"
              className="form-control"
              value={skillLevel}
              onChange={onChangeCandidateSkills}
            >
              <option value="">Select Skill Level</option>
              <option value="STUDENT">Student</option>
              <option value="JUNIOR">Junior</option>
              <option value="ENTRY">Entry</option>
              <option value="ADVANCED">Advanced</option>
              <option value="EXPERT">Expert</option>
            </select>
          </div>
        </div>

        <div className="form-group">
          <label htmlFor="startDate">Start Date</label>
          <input
            type="date"
            className="form-control"
            name="startDate"
            value={startDate}
            onChange={onChange}
          />
        </div>
        <div className="form-group">
          <button className="btn btn-block">Submit Talent Request</button>
        </div>
      </form>
    </>
  );
}

export default CreateTalentRequestForm;
