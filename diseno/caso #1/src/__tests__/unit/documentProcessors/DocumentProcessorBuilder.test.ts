import { describe, it, expect } from "@jest/globals";
import { DocumentProcessorBuilder } from "@documentProcessors/DocumentProcessorBuilder";

describe("DocumentProcessorBuilder", () => {
  it("should build a processor with all formats", () => {
    const processor = new DocumentProcessorBuilder().withAllFormats().build();
    const extensions = processor.getSupportedExtensions();

    expect(extensions).toContain(".docx");
    expect(extensions).toContain(".xlsx");
    expect(extensions).toContain(".pdf");
    expect(extensions).toContain(".jpg");
    expect(extensions).toContain(".png");
  });

  it("should build a processor with only PDF support", () => {
    const processor = new DocumentProcessorBuilder().withPdf().build();
    const extensions = processor.getSupportedExtensions();

    expect(extensions).toContain(".pdf");
    expect(extensions).not.toContain(".docx");
    expect(extensions).not.toContain(".xlsx");
  });

  it("should throw when building with no strategies", () => {
    expect(() => new DocumentProcessorBuilder().build()).toThrow(
      "At least one document strategy must be configured",
    );
  });

  it("should throw when processing unsupported file type", async () => {
    const processor = new DocumentProcessorBuilder().withPdf().build();

    await expect(
      processor.processFile(Buffer.from(""), "test.docx"),
    ).rejects.toThrow("No strategy found for file: test.docx");
  });
});
