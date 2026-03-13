import { IDocumentStrategy, ExtractedData } from "./IDocumentStrategy";

export class PdfStrategy implements IDocumentStrategy {
  private static instance: PdfStrategy | null = null;
  readonly supportedExtensions = [".pdf"];

  private constructor() {}

  static getInstance(): PdfStrategy {
    if (!PdfStrategy.instance) {
      PdfStrategy.instance = new PdfStrategy();
    }
    return PdfStrategy.instance;
  }

  canProcess(fileName: string): boolean {
    return this.supportedExtensions.some((ext) => fileName.toLowerCase().endsWith(ext));
  }

  async extract(fileBuffer: Buffer, fileName: string): Promise<ExtractedData> {
    // TODO: Implement PDF parsing (e.g., using pdf-parse or pdfjs-dist)
    return {
      fields: {},
      rawText: "",
      metadata: {
        fileName,
        fileType: "pdf",
        extractedAt: new Date().toISOString(),
      },
    };
  }
}
