import { UserApiClient } from "@apiClients/UserApiClient";
import { User, UserCreateRequest, UserUpdateRequest } from "@models/User";
import { ApiResponse, PaginatedResponse } from "@models/ApiResponse";
import { userCreateSchema, userUpdateSchema } from "@validation/userSchema";

export class UserService {
  private readonly userApiClient: UserApiClient;

  constructor() {
    this.userApiClient = UserApiClient.getInstance();
  }

  async getUsers(page: number = 1, pageSize: number = 20): Promise<ApiResponse<PaginatedResponse<User>>> {
    return this.userApiClient.getUsers(page, pageSize);
  }

  async getUserById(id: string): Promise<ApiResponse<User>> {
    return this.userApiClient.getUserById(id);
  }

  async createUser(request: UserCreateRequest): Promise<ApiResponse<User>> {
    const validation = userCreateSchema.safeParse(request);
    if (!validation.success) {
      return {
        success: false,
        error: {
          code: "VALIDATION_ERROR",
          message: validation.error.errors.map((e) => e.message).join(", "),
        },
      };
    }
    return this.userApiClient.createUser(request);
  }

  async updateUser(id: string, request: UserUpdateRequest): Promise<ApiResponse<User>> {
    const validation = userUpdateSchema.safeParse(request);
    if (!validation.success) {
      return {
        success: false,
        error: {
          code: "VALIDATION_ERROR",
          message: validation.error.errors.map((e) => e.message).join(", "),
        },
      };
    }
    return this.userApiClient.updateUser(id, request);
  }

  async deleteUser(id: string): Promise<ApiResponse<void>> {
    return this.userApiClient.deleteUser(id);
  }
}
