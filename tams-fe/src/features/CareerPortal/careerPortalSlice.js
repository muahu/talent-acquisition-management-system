import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import careerPortalService from "./careerPortalService";

const initialState = {
  jobPosts: [],
  jobPost: {},
  isError: false,
  isSuccess: false,
  isLoading: false,
  message: "",
};

export const getAllJobPosts = createAsyncThunk(
  "jobPosts/getAllJobPosts",
  async (_, thunkAPI) => {
    try {
      return await careerPortalService.getAllJobPosts();
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

export const getJobPostById = createAsyncThunk(
  "jobPosts/get",
  async (jobPostId, thunkAPI) => {
    try {
      return await careerPortalService.getJobPostById(jobPostId);
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

export const jobPostSlice = createSlice({
  name: "jobPost",
  initialState,
  reducers: {
    reset: (state) => initialState,
  },
  extraReducers: (builder) => {
    builder

      .addCase(getAllJobPosts.pending, (state) => {
        state.isLoading = true;
      })
      .addCase(getAllJobPosts.fulfilled, (state, action) => {
        state.isSuccess = true;
        state.jobPosts = action.payload;
      })
      .addCase(getAllJobPosts.rejected, (state, action) => {
        state.isError = true;
        state.message = action.payload;
      })
      .addCase(getJobPostById.pending, (state) => {
        state.isLoading = true;
      })
      .addCase(getJobPostById.fulfilled, (state, action) => {
        state.isLoading = false;
        state.isSuccess = true;
        state.jobPost = action.payload;
      })
      .addCase(getJobPostById.rejected, (state, action) => {
        state.isLoading = false;
        state.isError = true;
        state.message = action.payload;
      });
  },
});

export const { reset } = jobPostSlice.actions;
export default jobPostSlice.reducer;
