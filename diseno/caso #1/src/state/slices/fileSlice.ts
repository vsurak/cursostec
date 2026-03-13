import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { FileUpload, FileUploadBatch } from "@models/FileUpload";

interface FileState {
  currentBatch: FileUploadBatch | null;
  files: FileUpload[];
  isUploading: boolean;
  uploadProgress: number;
  error: string | null;
}

const initialState: FileState = {
  currentBatch: null,
  files: [],
  isUploading: false,
  uploadProgress: 0,
  error: null,
};

const fileSlice = createSlice({
  name: "file",
  initialState,
  reducers: {
    setUploading(state, action: PayloadAction<boolean>) {
      state.isUploading = action.payload;
    },
    setUploadProgress(state, action: PayloadAction<number>) {
      state.uploadProgress = action.payload;
    },
    setCurrentBatch(state, action: PayloadAction<FileUploadBatch>) {
      state.currentBatch = action.payload;
    },
    addFile(state, action: PayloadAction<FileUpload>) {
      state.files.push(action.payload);
    },
    removeFile(state, action: PayloadAction<string>) {
      state.files = state.files.filter((f) => f.id !== action.payload);
    },
    clearFiles(state) {
      state.files = [];
      state.currentBatch = null;
      state.uploadProgress = 0;
    },
    setError(state, action: PayloadAction<string | null>) {
      state.error = action.payload;
    },
  },
});

export const {
  setUploading,
  setUploadProgress,
  setCurrentBatch,
  addFile,
  removeFile,
  clearFiles,
  setError,
} = fileSlice.actions;
export default fileSlice.reducer;
