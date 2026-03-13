export const APP_NAME = "DUA Streamliner";

export const SUPPORTED_FILE_EXTENSIONS = [".docx", ".xlsx", ".pdf", ".jpg", ".png"] as const;

export const MAX_FILE_SIZE_MB = 50;

export const CONFIDENCE_THRESHOLDS = {
  HIGH: 0.85,
  MEDIUM: 0.6,
  LOW: 0,
} as const;

export const ROUTES = {
  HOME: "/",
  LOGIN: "/login",
  DASHBOARD: "/dashboard",
  DUA_LIST: "/dua",
  DUA_DETAIL: (id: string) => `/dua/${id}`,
  USERS: "/users",
  REPORTS: "/reports",
  TEMPLATES: "/templates",
} as const;

export const API_ENDPOINTS = {
  AUTH: "/auth",
  DUA: "/dua",
  FILES: "/files",
  USERS: "/users",
  TEMPLATES: "/templates",
  REPORTS: "/reports",
  NOTIFICATIONS: "/notifications",
} as const;
