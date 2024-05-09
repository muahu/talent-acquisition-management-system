import { configureStore } from "@reduxjs/toolkit";
import talentRequestReducer from "../features/TalentRequest/talentRequestSlice";
import talentFulfillmentReducer from "../features/TalentFulfillment/talentFulfillmentSlice"
import jobPostReducer from "../features/CareerPortal/careerPortalSlice";

export const store = configureStore({
  reducer: {
    talentRequests: talentRequestReducer,
    talentFulfillments: talentFulfillmentReducer,
    jobPosts: jobPostReducer,


  },
});
