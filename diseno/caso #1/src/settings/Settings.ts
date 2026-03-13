import { SecretClient } from "@azure/keyvault-secrets";
import { DefaultAzureCredential } from "@azure/identity";

export class Settings {
  private static instance: Settings | null = null;
  private secretClient: SecretClient | null = null;
  private cache: Map<string, string> = new Map();

  private constructor() {
    const vaultUrl = process.env.AZURE_KEYVAULT_URL;
    if (vaultUrl) {
      const credential = new DefaultAzureCredential();
      this.secretClient = new SecretClient(vaultUrl, credential);
    }
  }

  static getInstance(): Settings {
    if (!Settings.instance) {
      Settings.instance = new Settings();
    }
    return Settings.instance;
  }

  async getSecret(secretName: string): Promise<string> {
    if (this.cache.has(secretName)) {
      return this.cache.get(secretName)!;
    }

    if (!this.secretClient) {
      const envValue = process.env[secretName];
      if (!envValue) throw new Error(`Secret "${secretName}" not found in environment`);
      return envValue;
    }

    const secret = await this.secretClient.getSecret(secretName);
    if (!secret.value) throw new Error(`Secret "${secretName}" has no value`);

    this.cache.set(secretName, secret.value);
    return secret.value;
  }

  get apiBaseUrl(): string {
    return process.env.API_BASE_URL || "http://localhost:8080/api";
  }

  get notificationCallbackUrl(): string {
    return process.env.NOTIFICATION_CALLBACK_URL || "http://localhost:3000/api/notifications/callback";
  }

  get environment(): string {
    return process.env.NODE_ENV || "development";
  }

  get appInsightsConnectionString(): string {
    return process.env.NEXT_PUBLIC_APPINSIGHTS_CONNECTION_STRING || "";
  }
}
