import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { Dua, DuaTemplate } from "@models/Dua";

interface DuaState {
  currentDua: Dua | null;
  duaList: Dua[];
  templates: DuaTemplate[];
  isProcessing: boolean;
  error: string | null;
}

const initialState: DuaState = {
  currentDua: null,
  duaList: [],
  templates: [],
  isProcessing: false,
  error: null,
};

const duaSlice = createSlice({
  name: "dua",
  initialState,
  reducers: {
    setProcessing(state, action: PayloadAction<boolean>) {
      state.isProcessing = action.payload;
    },
    setCurrentDua(state, action: PayloadAction<Dua>) {
      state.currentDua = action.payload;
    },
    setDuaList(state, action: PayloadAction<Dua[]>) {
      state.duaList = action.payload;
    },
    setTemplates(state, action: PayloadAction<DuaTemplate[]>) {
      state.templates = action.payload;
    },
    updateDuaStatus(state, action: PayloadAction<{ id: string; status: Dua["status"] }>) {
      const dua = state.duaList.find((d) => d.id === action.payload.id);
      if (dua) dua.status = action.payload.status;
      if (state.currentDua?.id === action.payload.id) {
        state.currentDua.status = action.payload.status;
      }
    },
    setError(state, action: PayloadAction<string | null>) {
      state.error = action.payload;
    },
    clearCurrentDua(state) {
      state.currentDua = null;
    },
  },
});

export const {
  setProcessing,
  setCurrentDua,
  setDuaList,
  setTemplates,
  updateDuaStatus,
  setError,
  clearCurrentDua,
} = duaSlice.actions;
export default duaSlice.reducer;
