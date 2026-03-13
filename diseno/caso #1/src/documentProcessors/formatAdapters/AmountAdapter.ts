import { IFormatAdapter, FormattedOutput } from "./IFormatAdapter";

export interface AmountData {
  value: number;
  currency: string;
  decimals?: number;
}

export class AmountAdapter implements IFormatAdapter {
  readonly formatType = "amount" as const;

  format(data: unknown): FormattedOutput {
    const amountData = data as AmountData;
    const decimals = amountData.decimals ?? 2;
    const formatted = new Intl.NumberFormat("es-CR", {
      style: "currency",
      currency: amountData.currency,
      minimumFractionDigits: decimals,
      maximumFractionDigits: decimals,
    }).format(amountData.value);

    return {
      type: this.formatType,
      content: formatted,
    };
  }
}
