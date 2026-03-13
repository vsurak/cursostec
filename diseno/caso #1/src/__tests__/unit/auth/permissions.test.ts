import { describe, it, expect } from "@jest/globals";
import { hasPermission, getPermissionsForRole } from "@auth/permissions";
import { RoleTypes, PermissionCodes } from "@models/Role";

describe("permissions", () => {
  describe("hasPermission", () => {
    it("should return true for Manager with MANAGE_USERS", () => {
      expect(hasPermission(RoleTypes.MANAGER, PermissionCodes.MANAGE_USERS)).toBe(true);
    });

    it("should return false for Manager with LOAD_FILES", () => {
      expect(hasPermission(RoleTypes.MANAGER, PermissionCodes.LOAD_FILES)).toBe(false);
    });

    it("should return true for Customs Agent with GENERATE_DUA", () => {
      expect(hasPermission(RoleTypes.CUSTOMS_AGENT, PermissionCodes.GENERATE_DUA)).toBe(true);
    });

    it("should return false for Customs Agent with MANAGE_USERS", () => {
      expect(hasPermission(RoleTypes.CUSTOMS_AGENT, PermissionCodes.MANAGE_USERS)).toBe(false);
    });
  });

  describe("getPermissionsForRole", () => {
    it("should return 3 permissions for Manager", () => {
      const permissions = getPermissionsForRole(RoleTypes.MANAGER);
      expect(permissions).toHaveLength(3);
      expect(permissions).toContain(PermissionCodes.MANAGE_USERS);
      expect(permissions).toContain(PermissionCodes.VIEW_REPORTS);
      expect(permissions).toContain(PermissionCodes.EDIT_TEMPLATES);
    });

    it("should return 3 permissions for Customs Agent", () => {
      const permissions = getPermissionsForRole(RoleTypes.CUSTOMS_AGENT);
      expect(permissions).toHaveLength(3);
      expect(permissions).toContain(PermissionCodes.LOAD_FILES);
      expect(permissions).toContain(PermissionCodes.GENERATE_DUA);
      expect(permissions).toContain(PermissionCodes.DOWNLOAD_DUA);
    });
  });
});
