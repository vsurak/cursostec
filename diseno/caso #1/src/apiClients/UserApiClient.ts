import { BaseApiClient } from "./BaseApiClient";
import { User, UserCreateRequest, UserUpdateRequest } from "@models/User";
import { ApiResponse, PaginatedResponse } from "@models/ApiResponse";
import { API_ENDPOINTS } from "@utils/constants";

export class UserApiClient extends BaseApiClient {
  private static instance: UserApiClient | null = null;

  private constructor() {
    super();
  }

  static getInstance(): UserApiClient {
    if (!UserApiClient.instance) {
      UserApiClient.instance = new UserApiClient();
    }
    return UserApiClient.instance;
  }

  async getUsers(page: number, pageSize: number): Promise<ApiResponse<PaginatedResponse<User>>> {
    return this.get<PaginatedResponse<User>>(
      `${API_ENDPOINTS.USERS}?page=${page}&pageSize=${pageSize}`,
    );
  }

  async getUserById(id: string): Promise<ApiResponse<User>> {
    return this.get<User>(`${API_ENDPOINTS.USERS}/${id}`);
  }

  async createUser(request: UserCreateRequest): Promise<ApiResponse<User>> {
    return this.post<User>(API_ENDPOINTS.USERS, request);
  }

  async updateUser(id: string, request: UserUpdateRequest): Promise<ApiResponse<User>> {
    return this.put<User>(`${API_ENDPOINTS.USERS}/${id}`, request);
  }

  async deleteUser(id: string): Promise<ApiResponse<void>> {
    return this.delete<void>(`${API_ENDPOINTS.USERS}/${id}`);
  }
}
