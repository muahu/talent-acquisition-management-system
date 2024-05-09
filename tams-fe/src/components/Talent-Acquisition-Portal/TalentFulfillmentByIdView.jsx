import React from "react";

import { useEffect } from "react";
import { toast } from "react-toastify";
import { useSelector, useDispatch } from "react-redux";
import { getTalentFulfillmentById } from "../../features/TalentFulfillment/talentFulfillmentSlice";
import { useParams } from "react-router-dom";
import LoadingSpinner from "../LoadingSpinner";
import ApprovedTalentFulfillmentByIdView from "./ApprovedTalentFulfillmentByIdView";
import UpdateAndApproveTalentFulfillmentByIdView from "./UpdateAndApproveTalentFulfillmentByIdView";

function TalentFulfillmentByIdView() {
  const { talentFulfillment, isError, message, isLoading } = useSelector(
    (state) => state.talentFulfillments
  );

  const { talentFulfillmentId } = useParams();

  const dispatch = useDispatch();

  useEffect(() => {
    if (isError) {
      toast.error(message);
    }

    dispatch(getTalentFulfillmentById(talentFulfillmentId));
  }, [isError, message, talentFulfillmentId, dispatch]);

  if (isLoading) {
    return <LoadingSpinner />;
  }

  const displayViewOrFormDependingOnApprovalStatus = (talentFulfillment) => {
    if (talentFulfillment.requestStatus === "APPROVED") {
      return (
        <ApprovedTalentFulfillmentByIdView
          approvedTalentFulfillment={talentFulfillment}
        />
      );
    }

    if (talentFulfillment?.requestStatus !== "APPROVED") {
      return (
        <UpdateAndApproveTalentFulfillmentByIdView
          assignedTalentFulfillment={talentFulfillment}
          isLoading={isLoading}
        />
      );
    }
  };

  return (
    <div className="talent-request-page">
      {displayViewOrFormDependingOnApprovalStatus(talentFulfillment)}
    </div>
  );
}

export default TalentFulfillmentByIdView;
