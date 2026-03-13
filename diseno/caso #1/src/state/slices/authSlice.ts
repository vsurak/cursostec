import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { User } from "@models/User";
import { RoleType } from "@models/Role";

interface AuthState {
  isAuthenticated: boolean;
  user: User | null;
  role: RoleType | null;
  accessToken: string | null;
  isLoading: boolean;
  error: string | null;
}

const initialState: AuthState = {
  isAuthenticated: false,
  user: null,
  role: null,
  accessToken: null,
  isLoading: false,
  error: null,
};

const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    setLoading(state, action: PayloadAction<boolean>) {
      state.isLoading = action.payload;
    },
    loginSuccess(state, action: PayloadAction<{ user: User; accessToken: string }>) {
      state.isAuthenticated = true;
      state.user = action.payload.user;
      state.role = action.payload.user.role;
      state.accessToken = action.payload.accessToken;
      state.isLoading = false;
      state.error = null;
    },
    loginFailure(state, action: PayloadAction<string>) {
      state.isAuthenticated = false;
      state.user = null;
      state.role = null;
      state.accessToken = null;
      state.isLoading = false;
      state.error = action.payload;
    },
    logout(state) {
      state.isAuthenticated = false;
      state.user = null;
      state.role = null;
      state.accessToken = null;
      state.error = null;
    },
  },
});

export const { setLoading, loginSuccess, loginFailure, logout } = authSlice.actions;
export default authSlice.reducer;
