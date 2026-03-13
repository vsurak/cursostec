export interface ExtractedData {
  fields: Record<string, string>;
  rawText: string;
  metadata: DocumentMetadata;
}

export interface DocumentMetadata {
  fileName: string;
  fileType: string;
  pageCount?: number;
  extractedAt: string;
}

export interface IDocumentStrategy {
  readonly supportedExtensions: string[];
  canProcess(fileName: string): boolean;
  extract(fileBuffer: Buffer, fileName: string): Promise<ExtractedData>;
}
