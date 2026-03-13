"use client";

import { useCallback } from "react";
import { useAppDispatch, useAppSelector } from "@state/hooks";
import { loginSuccess, loginFailure, logout, setLoading } from "@state/slices/authSlice";
import { AuthService } from "@services/AuthService";

const authService = new AuthService();

export function useAuth() {
  const dispatch = useAppDispatch();
  const auth = useAppSelector((state) => state.auth);

  const handleLoginSuccess = useCallback(
    async (accessToken: string) => {
      dispatch(setLoading(true));
      const response = await authService.getUserProfile(accessToken);
      if (response.success && response.data) {
        dispatch(loginSuccess({ user: response.data, accessToken }));
      } else {
        dispatch(loginFailure(response.error?.message || "Login failed"));
      }
    },
    [dispatch],
  );

  const handleLogout = useCallback(() => {
    dispatch(logout());
    // TODO: Trigger MSAL logout
  }, [dispatch]);

  return {
    ...auth,
    handleLoginSuccess,
    handleLogout,
  };
}
