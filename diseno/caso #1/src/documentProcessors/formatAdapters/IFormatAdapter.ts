export type FormatType = "paragraph" | "bullets" | "table" | "label" | "amount";

export interface FormattedOutput {
  type: FormatType;
  content: string;
}

export interface IFormatAdapter {
  readonly formatType: FormatType;
  format(data: unknown): FormattedOutput;
}
