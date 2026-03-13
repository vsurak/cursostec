import { RoleType } from "./Role";

export interface User {
  id: string;
  email: string;
  displayName: string;
  role: RoleType;
  isActive: boolean;
  createdAt: string;
  updatedAt: string;
}

export interface UserCreateRequest {
  email: string;
  displayName: string;
  role: RoleType;
}

export interface UserUpdateRequest {
  displayName?: string;
  role?: RoleType;
  isActive?: boolean;
}
