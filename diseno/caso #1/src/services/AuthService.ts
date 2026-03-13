import { AuthApiClient } from "@apiClients/AuthApiClient";
import { User } from "@models/User";
import { ApiResponse } from "@models/ApiResponse";

export class AuthService {
  private readonly authApiClient: AuthApiClient;

  constructor() {
    this.authApiClient = AuthApiClient.getInstance();
  }

  async getUserProfile(accessToken: string): Promise<ApiResponse<User>> {
    return this.authApiClient.getUserProfile(accessToken);
  }

  async validateSession(accessToken: string): Promise<boolean> {
    const response = await this.authApiClient.validateToken(accessToken);
    return response.success && !!response.data?.valid;
  }
}
