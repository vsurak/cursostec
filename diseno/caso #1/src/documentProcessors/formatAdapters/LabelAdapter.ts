import { IFormatAdapter, FormattedOutput } from "./IFormatAdapter";

export interface LabelData {
  label: string;
  value: string;
}

export class LabelAdapter implements IFormatAdapter {
  readonly formatType = "label" as const;

  format(data: unknown): FormattedOutput {
    const labelData = data as LabelData;
    return {
      type: this.formatType,
      content: `${labelData.label}: ${labelData.value}`,
    };
  }
}
