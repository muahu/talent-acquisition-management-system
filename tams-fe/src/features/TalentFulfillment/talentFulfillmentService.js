import axios from "axios";

const talent_fulfillment_service =
  "http://localhost:8080/talent-fulfillment-service/talent-fulfillment";

const new_job_post_URL = "job-post";

const getAllTalentFulfillments = async () => {
  const response = await axios.get(talent_fulfillment_service);

  return response.data;
};

const getTalentFulfillmentById = async (talentFulfillmentId) => {
  const response = await axios.get(
    talent_fulfillment_service + "/" + talentFulfillmentId
  );

  return response.data;
};


const approveTalentFulfillmentJobPost = async (approvedTalentFulfillment) => {
  const response = await axios.post(
    talent_fulfillment_service + "/" + new_job_post_URL,
    approvedTalentFulfillment
  );

  return response.data;
};
const talentFulfillmentService = {
  getAllTalentFulfillments,
  getTalentFulfillmentById,
  approveTalentFulfillmentJobPost
};

export default talentFulfillmentService;
