import { BaseApiClient } from "./BaseApiClient";
import { User } from "@models/User";
import { ApiResponse } from "@models/ApiResponse";
import { API_ENDPOINTS } from "@utils/constants";

export class AuthApiClient extends BaseApiClient {
  private static instance: AuthApiClient | null = null;

  private constructor() {
    super();
  }

  static getInstance(): AuthApiClient {
    if (!AuthApiClient.instance) {
      AuthApiClient.instance = new AuthApiClient();
    }
    return AuthApiClient.instance;
  }

  async getUserProfile(accessToken: string): Promise<ApiResponse<User>> {
    return this.get<User>(`${API_ENDPOINTS.AUTH}/profile`, {
      Authorization: `Bearer ${accessToken}`,
    });
  }

  async validateToken(accessToken: string): Promise<ApiResponse<{ valid: boolean }>> {
    return this.post<{ valid: boolean }>(`${API_ENDPOINTS.AUTH}/validate`, { token: accessToken });
  }
}
