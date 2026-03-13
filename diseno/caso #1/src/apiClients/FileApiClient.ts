import { BaseApiClient } from "./BaseApiClient";
import { FileUploadBatch } from "@models/FileUpload";
import { ApiResponse } from "@models/ApiResponse";
import { API_ENDPOINTS } from "@utils/constants";
import { ExceptionHandler } from "@exceptionHandling/ExceptionHandler";

export class FileApiClient extends BaseApiClient {
  private static instance: FileApiClient | null = null;

  private constructor() {
    super();
  }

  static getInstance(): FileApiClient {
    if (!FileApiClient.instance) {
      FileApiClient.instance = new FileApiClient();
    }
    return FileApiClient.instance;
  }

  async uploadFiles(formData: FormData): Promise<ApiResponse<FileUploadBatch>> {
    const url = `${this.baseUrl}${API_ENDPOINTS.FILES}/upload`;

    try {
      this.logger.info(`API POST ${API_ENDPOINTS.FILES}/upload`);

      const response = await fetch(url, {
        method: "POST",
        body: formData,
      });

      return await response.json();
    } catch (error) {
      ExceptionHandler.getInstance().handle(error as Error, "File upload");
      return {
        success: false,
        error: {
          code: "UPLOAD_ERROR",
          message: (error as Error).message,
        },
      };
    }
  }

  async getUploadStatus(batchId: string): Promise<ApiResponse<FileUploadBatch>> {
    return this.get<FileUploadBatch>(`${API_ENDPOINTS.FILES}/batch/${batchId}`);
  }
}
