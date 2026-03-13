import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  reactStrictMode: true,
  output: "standalone",
  i18n: {
    locales: ["en", "es"],
    defaultLocale: "es",
  },
  serverRuntimeConfig: {
    azureKeyVaultUrl: process.env.AZURE_KEYVAULT_URL,
  },
  publicRuntimeConfig: {
    appInsightsConnectionString:
      process.env.NEXT_PUBLIC_APPINSIGHTS_CONNECTION_STRING,
  },
};

export default nextConfig;
