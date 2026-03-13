import { ApiResponse } from "@models/ApiResponse";
import { Settings } from "@settings/Settings";
import { Logger } from "@logs/Logger";
import { ExceptionHandler } from "@exceptionHandling/ExceptionHandler";

export abstract class BaseApiClient {
  protected readonly settings: Settings;
  protected readonly logger: Logger;
  protected readonly exceptionHandler: ExceptionHandler;
  protected readonly baseUrl: string;

  protected constructor() {
    this.settings = Settings.getInstance();
    this.logger = Logger.getInstance();
    this.exceptionHandler = ExceptionHandler.getInstance();
    this.baseUrl = this.settings.apiBaseUrl;
  }

  protected async request<T>(
    method: string,
    endpoint: string,
    body?: unknown,
    headers?: Record<string, string>,
  ): Promise<ApiResponse<T>> {
    const url = `${this.baseUrl}${endpoint}`;

    try {
      this.logger.info(`API ${method} ${endpoint}`);

      const response = await fetch(url, {
        method,
        headers: {
          "Content-Type": "application/json",
          ...headers,
        },
        body: body ? JSON.stringify(body) : undefined,
      });

      const data: ApiResponse<T> = await response.json();

      if (!response.ok) {
        this.logger.warn(`API ${method} ${endpoint} returned ${response.status}`);
      }

      return data;
    } catch (error) {
      this.exceptionHandler.handle(error as Error, `API ${method} ${endpoint}`);
      return {
        success: false,
        error: {
          code: "API_ERROR",
          message: (error as Error).message,
        },
      };
    }
  }

  protected async get<T>(
    endpoint: string,
    headers?: Record<string, string>,
  ): Promise<ApiResponse<T>> {
    return this.request<T>("GET", endpoint, undefined, headers);
  }

  protected async post<T>(
    endpoint: string,
    body: unknown,
    headers?: Record<string, string>,
  ): Promise<ApiResponse<T>> {
    return this.request<T>("POST", endpoint, body, headers);
  }

  protected async put<T>(
    endpoint: string,
    body: unknown,
    headers?: Record<string, string>,
  ): Promise<ApiResponse<T>> {
    return this.request<T>("PUT", endpoint, body, headers);
  }

  protected async delete<T>(
    endpoint: string,
    headers?: Record<string, string>,
  ): Promise<ApiResponse<T>> {
    return this.request<T>("DELETE", endpoint, undefined, headers);
  }
}
