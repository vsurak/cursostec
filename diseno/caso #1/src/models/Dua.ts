export type DuaStatus = "pending" | "processing" | "completed" | "failed" | "review";

export type ConfidenceLevel = "high" | "medium" | "low";

export interface DuaField {
  fieldName: string;
  value: string;
  confidence: ConfidenceLevel;
  sourceFile: string;
  requiresReview: boolean;
}

export interface Dua {
  id: string;
  status: DuaStatus;
  fields: DuaField[];
  templateId: string;
  createdBy: string;
  createdAt: string;
  updatedAt: string;
  downloadUrl?: string;
}

export interface DuaGenerateRequest {
  folderPath: string;
  templateId: string;
}

export interface DuaTemplate {
  id: string;
  name: string;
  version: string;
  isActive: boolean;
}
