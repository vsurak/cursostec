import { IDocumentStrategy, ExtractedData } from "./strategies/IDocumentStrategy";
import { WordStrategy } from "./strategies/WordStrategy";
import { ExcelStrategy } from "./strategies/ExcelStrategy";
import { PdfStrategy } from "./strategies/PdfStrategy";
import { ImageStrategy } from "./strategies/ImageStrategy";

export class DocumentProcessorBuilder {
  private strategies: IDocumentStrategy[] = [];

  withWord(): DocumentProcessorBuilder {
    this.strategies.push(WordStrategy.getInstance());
    return this;
  }

  withExcel(): DocumentProcessorBuilder {
    this.strategies.push(ExcelStrategy.getInstance());
    return this;
  }

  withPdf(): DocumentProcessorBuilder {
    this.strategies.push(PdfStrategy.getInstance());
    return this;
  }

  withImages(): DocumentProcessorBuilder {
    this.strategies.push(ImageStrategy.getInstance());
    return this;
  }

  withAllFormats(): DocumentProcessorBuilder {
    return this.withWord().withExcel().withPdf().withImages();
  }

  build(): DocumentProcessor {
    if (this.strategies.length === 0) {
      throw new Error("At least one document strategy must be configured");
    }
    return new DocumentProcessor([...this.strategies]);
  }
}

export class DocumentProcessor {
  constructor(private readonly strategies: IDocumentStrategy[]) {}

  async processFile(fileBuffer: Buffer, fileName: string): Promise<ExtractedData> {
    const strategy = this.strategies.find((s) => s.canProcess(fileName));
    if (!strategy) {
      throw new Error(`No strategy found for file: ${fileName}`);
    }
    return strategy.extract(fileBuffer, fileName);
  }

  async processFiles(
    files: Array<{ buffer: Buffer; name: string }>,
  ): Promise<ExtractedData[]> {
    return Promise.all(files.map((file) => this.processFile(file.buffer, file.name)));
  }

  getSupportedExtensions(): string[] {
    return this.strategies.flatMap((s) => s.supportedExtensions);
  }
}
