import { IFormatAdapter, FormattedOutput } from "./IFormatAdapter";

export class BulletsAdapter implements IFormatAdapter {
  readonly formatType = "bullets" as const;

  format(data: unknown): FormattedOutput {
    const items = Array.isArray(data) ? data : [data];
    const content = items.map((item) => `• ${String(item)}`).join("\n");
    return {
      type: this.formatType,
      content,
    };
  }
}
