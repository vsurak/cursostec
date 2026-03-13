import { DuaApiClient } from "@apiClients/DuaApiClient";
import { Dua, DuaGenerateRequest, DuaTemplate } from "@models/Dua";
import { ApiResponse, PaginatedResponse } from "@models/ApiResponse";
import { duaGenerateSchema } from "@validation/duaSchema";
import { NotificationService } from "@notificationService/NotificationService";

export class DuaService {
  private readonly duaApiClient: DuaApiClient;
  private readonly notificationService: NotificationService;

  constructor() {
    this.duaApiClient = DuaApiClient.getInstance();
    this.notificationService = NotificationService.getInstance();
  }

  async generateDua(request: DuaGenerateRequest): Promise<ApiResponse<Dua>> {
    const validation = duaGenerateSchema.safeParse(request);
    if (!validation.success) {
      return {
        success: false,
        error: {
          code: "VALIDATION_ERROR",
          message: validation.error.errors.map((e) => e.message).join(", "),
        },
      };
    }

    const response = await this.duaApiClient.generateDua(request);

    if (response.success && response.data) {
      this.notificationService.subscribe(
        `dua:${response.data.id}`,
        this.handleDuaStatusUpdate.bind(this),
      );
    }

    return response;
  }

  async getDuaById(id: string): Promise<ApiResponse<Dua>> {
    return this.duaApiClient.getDuaById(id);
  }

  async getDuaList(page: number = 1, pageSize: number = 20): Promise<ApiResponse<PaginatedResponse<Dua>>> {
    return this.duaApiClient.getDuaList(page, pageSize);
  }

  async getTemplates(): Promise<ApiResponse<DuaTemplate[]>> {
    return this.duaApiClient.getTemplates();
  }

  async downloadDua(id: string): Promise<ApiResponse<{ downloadUrl: string }>> {
    return this.duaApiClient.downloadDua(id);
  }

  private handleDuaStatusUpdate(data: unknown): void {
    // TODO: Handle async status updates from notification callback
    void data;
  }
}
