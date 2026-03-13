export const RoleTypes = {
  MANAGER: "Manager",
  CUSTOMS_AGENT: "CustomsAgent",
} as const;

export type RoleType = (typeof RoleTypes)[keyof typeof RoleTypes];

export interface Role {
  name: RoleType;
  permissions: PermissionCode[];
}

export const PermissionCodes = {
  MANAGE_USERS: "MANAGE_USERS",
  VIEW_REPORTS: "VIEW_REPORTS",
  EDIT_TEMPLATES: "EDIT_TEMPLATES",
  LOAD_FILES: "LOAD_FILES",
  GENERATE_DUA: "GENERATE_DUA",
  DOWNLOAD_DUA: "DOWNLOAD_DUA",
} as const;

export type PermissionCode = (typeof PermissionCodes)[keyof typeof PermissionCodes];
