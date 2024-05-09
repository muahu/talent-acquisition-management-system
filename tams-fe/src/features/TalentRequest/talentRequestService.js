import axios from "axios";

const talent_request_service =
  "http://localhost:8080/talent-request-service/talent-request";

const createTalentRequest = async (talentRequest) => {
  const response = await axios.post(talent_request_service, talentRequest);

  return response.data;
};

const getAllTalentRequests = async () => {
  const response = await axios.get(talent_request_service);

  return response.data;
};

const getTalentRequestById = async (talentRequestId) => {
  const response = await axios.get(talent_request_service +"/"+ talentRequestId);

  return response.data;
};

const talentRequestService = {
  createTalentRequest,
  getAllTalentRequests,
  getTalentRequestById,
};

export default talentRequestService;
