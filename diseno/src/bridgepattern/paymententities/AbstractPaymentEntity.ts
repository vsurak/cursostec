abstract class AbstractPaymentEntity {
    abstract pay(amount: number): void;
    abstract loadSettings(): void;
    abstract getAmountToPaid(details: any): number;
}

export default AbstractPaymentEntity;