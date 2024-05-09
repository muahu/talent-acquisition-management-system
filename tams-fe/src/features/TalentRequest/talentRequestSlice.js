import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import talentRequestService from "./talentRequestService";

const initialState = {
  talentRequests: [],
  talentRequest: {},
  isError: false,
  isSuccess: false,
  isLoading: false,
  message: "",
};

export const createTalentRequest = createAsyncThunk(
  "talentRequests/createTalentRequest",
  async (talentRequest, thunkAPI) => {
    try {

      return await talentRequestService.createTalentRequest(talentRequest);

    } catch (error) {
      const message =
        (error.response &&
          error.response.data &&
          error.response.data.message) ||
        error.message ||
        error.toString();

      return thunkAPI.rejectWithValue(message);

    }
  }
);

export const getAllTalentRequests = createAsyncThunk(
  "talentRequests/getAllTalentRequests",
  async (_, thunkAPI) => {
    try {
      return await talentRequestService.getAllTalentRequests();
    } catch (error) {
      const message =
        (error.response &&
          error.response.data &&
          error.response.data.message) ||
        error.message ||
        error.toString();
      return thunkAPI.rejectWithValue(message);
    }
  }
);

export const getTalentRequestById = createAsyncThunk(
  "talentRequests/getTalentRequestById",
  async (talentRequestId, thunkAPI) => {
    try {
      return await talentRequestService.getTalentRequestById(talentRequestId);
    } catch (error) {
      const message =
        (error.response &&
          error.response.data &&
          error.response.data.message) ||
        error.message ||
        error.toString();

      return thunkAPI.rejectWithValue(message);
    }
  }
);


export const talentRequestSlice = createSlice({
  name: "talentRequest",
  initialState,
  reducers: {
    reset: (state) => initialState,
  },

  extraReducers: (builder) => {
builder

// When the action is pending
.addCase(createTalentRequest.pending, (state) => {
  state.isLoading = true;
})

// When it is fulfilled
.addCase(createTalentRequest.fulfilled, (state, action) => {
  state.isLoading = false
  state.isSuccess = true;
  state.talentRequest = action.payload
})

// If it gets rejected due to an error.
.addCase(createTalentRequest.rejected, (state, action) => {
  state.isError = true;
  state.message = action.payload; // this is the message payload comes from our ThunkAPI implementation
})

.addCase(getAllTalentRequests.pending, (state) => {
  state.isLoading = true;
})
.addCase(getAllTalentRequests.fulfilled, (state, action) => {
  state.isSuccess = true;
  state.talentRequests = action.payload;
})
.addCase(getAllTalentRequests.rejected, (state, action) => {
  state.isError = true;
  state.message = action.payload;
})

.addCase(getTalentRequestById.pending, (state) => {
  state.isLoading = true;
})
.addCase(getTalentRequestById.fulfilled, (state, action) => {
  state.isLoading = false;
  state.isSuccess = true;
  state.talentRequest = action.payload;
})
.addCase(getTalentRequestById.rejected, (state, action) => {
  state.isLoading = false;
  state.isError = true;
  state.message = action.payload;
});


  },
});

export const { reset } = talentRequestSlice.actions;
export default talentRequestSlice.reducer;
