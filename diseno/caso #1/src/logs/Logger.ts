import { ApplicationInsights, SeverityLevel } from "@microsoft/applicationinsights-web";

export class Logger {
  private static instance: Logger | null = null;
  private appInsights: ApplicationInsights | null = null;

  private constructor() {
    const connectionString =
      process.env.NEXT_PUBLIC_APPINSIGHTS_CONNECTION_STRING;

    if (connectionString && typeof window !== "undefined") {
      this.appInsights = new ApplicationInsights({
        config: { connectionString },
      });
      this.appInsights.loadAppInsights();
    }
  }

  static getInstance(): Logger {
    if (!Logger.instance) {
      Logger.instance = new Logger();
    }
    return Logger.instance;
  }

  info(message: string, properties?: Record<string, string>): void {
    this.trackTrace(message, SeverityLevel.Information, properties);
  }

  warn(message: string, properties?: Record<string, string>): void {
    this.trackTrace(message, SeverityLevel.Warning, properties);
  }

  error(message: string, error?: Error, properties?: Record<string, string>): void {
    this.trackTrace(message, SeverityLevel.Error, properties);
    if (error && this.appInsights) {
      this.appInsights.trackException({ exception: error, severityLevel: SeverityLevel.Error });
    }
  }

  trackEvent(name: string, properties?: Record<string, string>): void {
    if (this.appInsights) {
      this.appInsights.trackEvent({ name }, properties);
    }
  }

  private trackTrace(
    message: string,
    severityLevel: SeverityLevel,
    properties?: Record<string, string>,
  ): void {
    if (this.appInsights) {
      this.appInsights.trackTrace({ message, severityLevel }, properties);
    }
  }
}
