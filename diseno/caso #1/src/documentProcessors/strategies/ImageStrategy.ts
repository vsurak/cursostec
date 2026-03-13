import { IDocumentStrategy, ExtractedData } from "./IDocumentStrategy";

export class ImageStrategy implements IDocumentStrategy {
  private static instance: ImageStrategy | null = null;
  readonly supportedExtensions = [".jpg", ".jpeg", ".png"];

  private constructor() {}

  static getInstance(): ImageStrategy {
    if (!ImageStrategy.instance) {
      ImageStrategy.instance = new ImageStrategy();
    }
    return ImageStrategy.instance;
  }

  canProcess(fileName: string): boolean {
    return this.supportedExtensions.some((ext) => fileName.toLowerCase().endsWith(ext));
  }

  async extract(fileBuffer: Buffer, fileName: string): Promise<ExtractedData> {
    // TODO: Implement OCR extraction (e.g., using Azure Computer Vision or Tesseract.js)
    return {
      fields: {},
      rawText: "",
      metadata: {
        fileName,
        fileType: this.getFileType(fileName),
        extractedAt: new Date().toISOString(),
      },
    };
  }

  private getFileType(fileName: string): string {
    const ext = fileName.split(".").pop()?.toLowerCase() || "";
    return ext === "jpeg" ? "jpg" : ext;
  }
}
