"use client";

import { useCallback } from "react";
import { useAppDispatch, useAppSelector } from "@state/hooks";
import {
  setProcessing,
  setCurrentDua,
  setDuaList,
  setTemplates,
  setError,
} from "@state/slices/duaSlice";
import { DuaService } from "@services/DuaService";

const duaService = new DuaService();

export function useDua() {
  const dispatch = useAppDispatch();
  const dua = useAppSelector((state) => state.dua);
  const file = useAppSelector((state) => state.file);

  const generateDua = useCallback(async () => {
    if (!file.currentBatch) {
      dispatch(setError("No files uploaded"));
      return;
    }

    dispatch(setProcessing(true));
    const response = await duaService.generateDua({
      folderPath: file.currentBatch.batchId,
      templateId: dua.templates[0]?.id || "",
    });

    if (response.success && response.data) {
      dispatch(setCurrentDua(response.data));
    } else {
      dispatch(setError(response.error?.message || "Generation failed"));
    }
    dispatch(setProcessing(false));
  }, [dispatch, file.currentBatch, dua.templates]);

  const loadDuaList = useCallback(
    async (page: number = 1) => {
      const response = await duaService.getDuaList(page);
      if (response.success && response.data) {
        dispatch(setDuaList(response.data.items));
      }
    },
    [dispatch],
  );

  const loadTemplates = useCallback(async () => {
    const response = await duaService.getTemplates();
    if (response.success && response.data) {
      dispatch(setTemplates(response.data));
    }
  }, [dispatch]);

  return {
    ...dua,
    generateDua,
    loadDuaList,
    loadTemplates,
  };
}
