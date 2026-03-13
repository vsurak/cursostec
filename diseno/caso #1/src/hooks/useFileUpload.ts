"use client";

import { useCallback } from "react";
import { useAppDispatch, useAppSelector } from "@state/hooks";
import {
  setUploading,
  setUploadProgress,
  setCurrentBatch,
  setError,
} from "@state/slices/fileSlice";
import { FileService } from "@services/FileService";

const fileService = new FileService();

export function useFileUpload() {
  const dispatch = useAppDispatch();
  const fileState = useAppSelector((state) => state.file);

  const uploadFiles = useCallback(
    async (files: FileList) => {
      dispatch(setUploading(true));
      dispatch(setUploadProgress(0));

      const response = await fileService.uploadFiles(files);

      if (response.success && response.data) {
        dispatch(setCurrentBatch(response.data));
        dispatch(setUploadProgress(100));
      } else {
        dispatch(setError(response.error?.message || "Upload failed"));
      }

      dispatch(setUploading(false));
    },
    [dispatch],
  );

  return {
    ...fileState,
    uploadFiles,
  };
}
