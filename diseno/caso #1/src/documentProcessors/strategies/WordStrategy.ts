import { IDocumentStrategy, ExtractedData } from "./IDocumentStrategy";

export class WordStrategy implements IDocumentStrategy {
  private static instance: WordStrategy | null = null;
  readonly supportedExtensions = [".docx"];

  private constructor() {}

  static getInstance(): WordStrategy {
    if (!WordStrategy.instance) {
      WordStrategy.instance = new WordStrategy();
    }
    return WordStrategy.instance;
  }

  canProcess(fileName: string): boolean {
    return this.supportedExtensions.some((ext) => fileName.toLowerCase().endsWith(ext));
  }

  async extract(fileBuffer: Buffer, fileName: string): Promise<ExtractedData> {
    // TODO: Implement Word document parsing (e.g., using mammoth or docx libraries)
    return {
      fields: {},
      rawText: "",
      metadata: {
        fileName,
        fileType: "docx",
        extractedAt: new Date().toISOString(),
      },
    };
  }
}
