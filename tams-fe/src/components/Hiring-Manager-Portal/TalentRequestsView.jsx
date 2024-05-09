import React from "react";
import { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import {
  getAllTalentRequests,
  reset,
} from "../../features/TalentRequest/talentRequestSlice";
import TalentRequestItem from "./TalentRequestItem";

function TalentRequestsView() {
  const { talentRequests, isSuccess, isLoading } = useSelector(
    (state) => state.talentRequests
  );

  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getAllTalentRequests());
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
      <div className="talent-requests">
        <div className="talent-request-headings">
          <div>Talent Request Title</div>
          <div>Start Date</div>
          <div>Status</div>
          <div>Actions</div>
        </div>
      </div>

      <div>
        {talentRequests.map((talentRequest) => (
          <TalentRequestItem
            key={talentRequest.talentRequestId}
            talentRequest={talentRequest}
          />
        ))}
      </div>
    </>
  );
}

export default TalentRequestsView;
