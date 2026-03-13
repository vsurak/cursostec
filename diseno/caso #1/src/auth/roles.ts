import { Role, RoleTypes, PermissionCodes } from "@models/Role";

export const RoleDefinitions: Record<string, Role> = {
  [RoleTypes.MANAGER]: {
    name: RoleTypes.MANAGER,
    permissions: [
      PermissionCodes.MANAGE_USERS,
      PermissionCodes.VIEW_REPORTS,
      PermissionCodes.EDIT_TEMPLATES,
    ],
  },
  [RoleTypes.CUSTOMS_AGENT]: {
    name: RoleTypes.CUSTOMS_AGENT,
    permissions: [
      PermissionCodes.LOAD_FILES,
      PermissionCodes.GENERATE_DUA,
      PermissionCodes.DOWNLOAD_DUA,
    ],
  },
};
