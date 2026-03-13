import { FileApiClient } from "@apiClients/FileApiClient";
import { FileUploadBatch } from "@models/FileUpload";
import { ApiResponse } from "@models/ApiResponse";
import { fileUploadBatchSchema } from "@validation/fileSchema";
import { SUPPORTED_FILE_EXTENSIONS, MAX_FILE_SIZE_MB } from "@utils/constants";

export class FileService {
  private readonly fileApiClient: FileApiClient;

  constructor() {
    this.fileApiClient = FileApiClient.getInstance();
  }

  async uploadFiles(files: FileList): Promise<ApiResponse<FileUploadBatch>> {
    const fileArray = Array.from(files);

    const validationInput = {
      files: fileArray.map((f) => ({
        fileName: f.name,
        fileType: this.getFileType(f.name),
        fileSizeBytes: f.size,
      })),
    };

    const validation = fileUploadBatchSchema.safeParse(validationInput);
    if (!validation.success) {
      return {
        success: false,
        error: {
          code: "VALIDATION_ERROR",
          message: validation.error.errors.map((e) => e.message).join(", "),
        },
      };
    }

    const formData = new FormData();
    fileArray.forEach((file) => {
      formData.append("files", file);
    });

    return this.fileApiClient.uploadFiles(formData);
  }

  async getUploadStatus(batchId: string): Promise<ApiResponse<FileUploadBatch>> {
    return this.fileApiClient.getUploadStatus(batchId);
  }

  isFileSupported(fileName: string): boolean {
    const ext = `.${fileName.split(".").pop()?.toLowerCase()}`;
    return (SUPPORTED_FILE_EXTENSIONS as readonly string[]).includes(ext);
  }

  isFileSizeValid(fileSizeBytes: number): boolean {
    return fileSizeBytes <= MAX_FILE_SIZE_MB * 1024 * 1024;
  }

  private getFileType(fileName: string): string {
    return fileName.split(".").pop()?.toLowerCase() || "";
  }
}
