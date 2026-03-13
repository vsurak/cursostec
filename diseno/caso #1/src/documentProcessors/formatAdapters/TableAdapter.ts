import { IFormatAdapter, FormattedOutput } from "./IFormatAdapter";

export interface TableData {
  headers: string[];
  rows: string[][];
}

export class TableAdapter implements IFormatAdapter {
  readonly formatType = "table" as const;

  format(data: unknown): FormattedOutput {
    const tableData = data as TableData;
    const headerRow = tableData.headers.join(" | ");
    const dataRows = tableData.rows.map((row) => row.join(" | ")).join("\n");
    return {
      type: this.formatType,
      content: `${headerRow}\n${dataRows}`,
    };
  }
}
