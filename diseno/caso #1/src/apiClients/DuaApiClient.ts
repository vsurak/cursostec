import { BaseApiClient } from "./BaseApiClient";
import { Dua, DuaGenerateRequest, DuaTemplate } from "@models/Dua";
import { ApiResponse, PaginatedResponse } from "@models/ApiResponse";
import { API_ENDPOINTS } from "@utils/constants";

export class DuaApiClient extends BaseApiClient {
  private static instance: DuaApiClient | null = null;

  private constructor() {
    super();
  }

  static getInstance(): DuaApiClient {
    if (!DuaApiClient.instance) {
      DuaApiClient.instance = new DuaApiClient();
    }
    return DuaApiClient.instance;
  }

  async generateDua(request: DuaGenerateRequest): Promise<ApiResponse<Dua>> {
    return this.post<Dua>(API_ENDPOINTS.DUA, request);
  }

  async getDuaById(id: string): Promise<ApiResponse<Dua>> {
    return this.get<Dua>(`${API_ENDPOINTS.DUA}/${id}`);
  }

  async getDuaList(page: number, pageSize: number): Promise<ApiResponse<PaginatedResponse<Dua>>> {
    return this.get<PaginatedResponse<Dua>>(
      `${API_ENDPOINTS.DUA}?page=${page}&pageSize=${pageSize}`,
    );
  }

  async getTemplates(): Promise<ApiResponse<DuaTemplate[]>> {
    return this.get<DuaTemplate[]>(API_ENDPOINTS.TEMPLATES);
  }

  async downloadDua(id: string): Promise<ApiResponse<{ downloadUrl: string }>> {
    return this.get<{ downloadUrl: string }>(`${API_ENDPOINTS.DUA}/${id}/download`);
  }
}
