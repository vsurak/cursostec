import { test, expect } from "@playwright/test";

test.describe("DUA Generation Flow", () => {
  test("should display login page for unauthenticated users", async ({ page }) => {
    await page.goto("/login");
    await expect(page.getByText("DUA Streamliner")).toBeVisible();
    await expect(page.getByRole("button", { name: /iniciar sesión|sign in/i })).toBeVisible();
  });

  test("should navigate to dashboard after authentication", async ({ page }) => {
    // TODO: Setup test authentication with MSAL mock
    await page.goto("/dashboard");
    await expect(page.getByText(/panel principal|dashboard/i)).toBeVisible();
  });

  test("should display DUA generation form", async ({ page }) => {
    // TODO: Setup authenticated session
    await page.goto("/dua");
    await expect(page.getByText(/generación de dua|dua generation/i)).toBeVisible();
  });
});
