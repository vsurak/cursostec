import { IDocumentStrategy, ExtractedData } from "./IDocumentStrategy";

export class ExcelStrategy implements IDocumentStrategy {
  private static instance: ExcelStrategy | null = null;
  readonly supportedExtensions = [".xlsx"];

  private constructor() {}

  static getInstance(): ExcelStrategy {
    if (!ExcelStrategy.instance) {
      ExcelStrategy.instance = new ExcelStrategy();
    }
    return ExcelStrategy.instance;
  }

  canProcess(fileName: string): boolean {
    return this.supportedExtensions.some((ext) => fileName.toLowerCase().endsWith(ext));
  }

  async extract(fileBuffer: Buffer, fileName: string): Promise<ExtractedData> {
    // TODO: Implement Excel parsing (e.g., using exceljs or xlsx libraries)
    return {
      fields: {},
      rawText: "",
      metadata: {
        fileName,
        fileType: "xlsx",
        extractedAt: new Date().toISOString(),
      },
    };
  }
}
