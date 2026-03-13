import type { Config } from "jest";

const config: Config = {
  preset: "ts-jest",
  testEnvironment: "jsdom",
  roots: ["<rootDir>"],
  modulePaths: ["<rootDir>"],
  moduleNameMapper: {
    "^@/(.*)$": "<rootDir>/$1",
    "^@components/(.*)$": "<rootDir>/components/$1",
    "^@hooks/(.*)$": "<rootDir>/hooks/$1",
    "^@services/(.*)$": "<rootDir>/services/$1",
    "^@apiClients/(.*)$": "<rootDir>/apiClients/$1",
    "^@models/(.*)$": "<rootDir>/models/$1",
    "^@validation/(.*)$": "<rootDir>/validation/$1",
    "^@state/(.*)$": "<rootDir>/state/$1",
    "^@settings/(.*)$": "<rootDir>/settings/$1",
    "^@utils/(.*)$": "<rootDir>/utils/$1",
    "^@auth/(.*)$": "<rootDir>/auth/$1",
    "^@logs/(.*)$": "<rootDir>/logs/$1",
    "\\.(css)$": "<rootDir>/__mocks__/styleMock.ts",
  },
  testMatch: [
    "**/__tests__/**/*.test.ts",
    "**/__tests__/**/*.test.tsx",
  ],
  setupFilesAfterSetup: ["<rootDir>/__tests__/setup.ts"],
  collectCoverageFrom: [
    "**/*.{ts,tsx}",
    "!**/*.d.ts",
    "!**/node_modules/**",
    "!**/.next/**",
  ],
};

export default config;
