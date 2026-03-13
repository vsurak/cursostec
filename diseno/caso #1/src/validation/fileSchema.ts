import { z } from "zod";

const SUPPORTED_FILE_TYPES = ["docx", "xlsx", "pdf", "jpg", "png"] as const;
const MAX_FILE_SIZE_BYTES = 50 * 1024 * 1024; // 50MB

export const fileUploadSchema = z.object({
  fileName: z.string().min(1, "File name is required"),
  fileType: z.enum(SUPPORTED_FILE_TYPES, {
    errorMap: () => ({
      message: `Supported file types: ${SUPPORTED_FILE_TYPES.join(", ")}`,
    }),
  }),
  fileSizeBytes: z
    .number()
    .positive()
    .max(MAX_FILE_SIZE_BYTES, `File size must not exceed ${MAX_FILE_SIZE_BYTES / 1024 / 1024}MB`),
});

export const fileUploadBatchSchema = z.object({
  files: z.array(fileUploadSchema).min(1, "At least one file is required"),
});

export type FileUploadInput = z.infer<typeof fileUploadSchema>;
export type FileUploadBatchInput = z.infer<typeof fileUploadBatchSchema>;
