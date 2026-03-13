import { z } from "zod";
import { RoleTypes } from "@models/Role";

export const userCreateSchema = z.object({
  email: z.string().email("Invalid email address"),
  displayName: z.string().min(2, "Name must be at least 2 characters"),
  role: z.enum([RoleTypes.MANAGER, RoleTypes.CUSTOMS_AGENT]),
});

export const userUpdateSchema = z.object({
  displayName: z.string().min(2).optional(),
  role: z.enum([RoleTypes.MANAGER, RoleTypes.CUSTOMS_AGENT]).optional(),
  isActive: z.boolean().optional(),
});

export type UserCreateInput = z.infer<typeof userCreateSchema>;
export type UserUpdateInput = z.infer<typeof userUpdateSchema>;
