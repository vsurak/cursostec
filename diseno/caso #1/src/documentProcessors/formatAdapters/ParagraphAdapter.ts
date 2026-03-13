import { IFormatAdapter, FormattedOutput } from "./IFormatAdapter";

export class ParagraphAdapter implements IFormatAdapter {
  readonly formatType = "paragraph" as const;

  format(data: unknown): FormattedOutput {
    const text = typeof data === "string" ? data : JSON.stringify(data);
    return {
      type: this.formatType,
      content: text,
    };
  }
}
