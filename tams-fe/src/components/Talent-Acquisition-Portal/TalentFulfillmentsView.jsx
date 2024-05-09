import { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import {
  getAllTalentFulfillments,
  reset,
} from "../../features/TalentFulfillment/talentFulfillmentSlice";
import TalentFulfillmentItem from "./TalentFulfillmentItem";

function TalentFulfillmentsView() {
  
  const { talentFulfillments, isSuccess } = useSelector(
    (state) => state.talentFulfillments
  );

  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getAllTalentFulfillments());
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
      <h1>Talent Fulfillment Requests</h1>

      <div className="talent-requests">
        <div className="talent-request-headings">
          <div>Talent Request Title</div>
          <div>Start Date</div>
          <div>Status</div>
          <div>Actions</div>
        </div>
        {talentFulfillments.map((talentFulfillment) => (
          <TalentFulfillmentItem
            key={talentFulfillment.talentFulfillmentId}
            talentFulfillment={talentFulfillment}
          />
        ))}
      </div>
    </>
  );
}

export default TalentFulfillmentsView;
