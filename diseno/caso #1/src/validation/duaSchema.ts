import { z } from "zod";

export const duaGenerateSchema = z.object({
  folderPath: z.string().min(1, "Folder path is required"),
  templateId: z.string().uuid("Invalid template ID"),
});

export const duaFieldSchema = z.object({
  fieldName: z.string(),
  value: z.string(),
  confidence: z.enum(["high", "medium", "low"]),
  sourceFile: z.string(),
  requiresReview: z.boolean(),
});

export const duaSchema = z.object({
  id: z.string().uuid(),
  status: z.enum(["pending", "processing", "completed", "failed", "review"]),
  fields: z.array(duaFieldSchema),
  templateId: z.string().uuid(),
  createdBy: z.string(),
  createdAt: z.string().datetime(),
  updatedAt: z.string().datetime(),
  downloadUrl: z.string().url().optional(),
});

export type DuaGenerateInput = z.infer<typeof duaGenerateSchema>;
export type DuaFieldInput = z.infer<typeof duaFieldSchema>;
