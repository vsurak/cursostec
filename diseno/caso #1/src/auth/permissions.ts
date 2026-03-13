import { PermissionCode, RoleType } from "@models/Role";
import { RoleDefinitions } from "./roles";

export function hasPermission(role: RoleType, permission: PermissionCode): boolean {
  const roleDefinition = RoleDefinitions[role];
  if (!roleDefinition) return false;
  return roleDefinition.permissions.includes(permission);
}

export function getPermissionsForRole(role: RoleType): PermissionCode[] {
  const roleDefinition = RoleDefinitions[role];
  if (!roleDefinition) return [];
  return [...roleDefinition.permissions];
}
