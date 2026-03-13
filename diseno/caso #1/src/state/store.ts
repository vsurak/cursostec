import { configureStore } from "@reduxjs/toolkit";
import authReducer from "./slices/authSlice";
import duaReducer from "./slices/duaSlice";
import fileReducer from "./slices/fileSlice";

export const makeStore = () =>
  configureStore({
    reducer: {
      auth: authReducer,
      dua: duaReducer,
      file: fileReducer,
    },
    middleware: (getDefaultMiddleware) =>
      getDefaultMiddleware({
        serializableCheck: {
          ignoredActions: ["auth/setAccount"],
        },
      }),
  });

export type AppStore = ReturnType<typeof makeStore>;
export type RootState = ReturnType<AppStore["getState"]>;
export type AppDispatch = AppStore["dispatch"];
