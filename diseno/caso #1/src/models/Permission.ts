import { PermissionCode, PermissionCodes } from "./Role";

export interface Permission {
  code: PermissionCode;
  description: string;
}

export const PermissionDefinitions: Record<PermissionCode, Permission> = {
  [PermissionCodes.MANAGE_USERS]: {
    code: PermissionCodes.MANAGE_USERS,
    description: "Manage user CRUD operations",
  },
  [PermissionCodes.VIEW_REPORTS]: {
    code: PermissionCodes.VIEW_REPORTS,
    description: "Access operational and performance reports",
  },
  [PermissionCodes.EDIT_TEMPLATES]: {
    code: PermissionCodes.EDIT_TEMPLATES,
    description: "Change or update DUA templates available",
  },
  [PermissionCodes.LOAD_FILES]: {
    code: PermissionCodes.LOAD_FILES,
    description: "Set and upload a folder with data files",
  },
  [PermissionCodes.GENERATE_DUA]: {
    code: PermissionCodes.GENERATE_DUA,
    description: "Starts the AI process of generating a DUA",
  },
  [PermissionCodes.DOWNLOAD_DUA]: {
    code: PermissionCodes.DOWNLOAD_DUA,
    description: "Downloads the DUA generated",
  },
};
