import { describe, it, expect, beforeEach, jest } from "@jest/globals";
import { DuaService } from "@services/DuaService";

describe("DuaService", () => {
  let duaService: DuaService;

  beforeEach(() => {
    duaService = new DuaService();
  });

  describe("generateDua", () => {
    it("should return validation error when folderPath is empty", async () => {
      const result = await duaService.generateDua({
        folderPath: "",
        templateId: "550e8400-e29b-41d4-a716-446655440000",
      });

      expect(result.success).toBe(false);
      expect(result.error?.code).toBe("VALIDATION_ERROR");
    });

    it("should return validation error when templateId is invalid", async () => {
      const result = await duaService.generateDua({
        folderPath: "/path/to/files",
        templateId: "invalid-uuid",
      });

      expect(result.success).toBe(false);
      expect(result.error?.code).toBe("VALIDATION_ERROR");
    });
  });
});
