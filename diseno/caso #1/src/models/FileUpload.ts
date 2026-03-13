export type SupportedFileType = "docx" | "xlsx" | "pdf" | "jpg" | "png";

export interface FileUpload {
  id: string;
  fileName: string;
  fileType: SupportedFileType;
  fileSizeBytes: number;
  uploadedAt: string;
  processingStatus: "pending" | "processing" | "processed" | "error";
}

export interface FileUploadBatch {
  batchId: string;
  files: FileUpload[];
  totalFiles: number;
  processedFiles: number;
}
