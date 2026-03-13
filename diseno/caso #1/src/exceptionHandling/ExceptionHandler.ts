import { Logger } from "@logs/Logger";

export interface ExceptionContext {
  source: string;
  userId?: string;
  additionalData?: Record<string, unknown>;
}

export class ExceptionHandler {
  private static instance: ExceptionHandler | null = null;
  private readonly logger: Logger;

  private constructor() {
    this.logger = Logger.getInstance();
  }

  static getInstance(): ExceptionHandler {
    if (!ExceptionHandler.instance) {
      ExceptionHandler.instance = new ExceptionHandler();
    }
    return ExceptionHandler.instance;
  }

  handle(error: Error, source: string, context?: Partial<ExceptionContext>): void {
    const fullContext: ExceptionContext = {
      source,
      ...context,
    };

    this.logger.error(`[${fullContext.source}] ${error.message}`, error, {
      source: fullContext.source,
      stack: error.stack || "",
      ...(fullContext.userId ? { userId: fullContext.userId } : {}),
    });
  }

  handleAsync<T>(
    promise: Promise<T>,
    source: string,
    context?: Partial<ExceptionContext>,
  ): Promise<T | null> {
    return promise.catch((error: Error) => {
      this.handle(error, source, context);
      return null;
    });
  }
}
