import AbstractPaymentEntity from './AbstractPaymentEntity';

class BACPaymentEntity extends AbstractPaymentEntity {
    pay(amount: number): void {
        console.log(`Paying amount in BACPaymentEntity: ${amount}`);
    }

    loadSettings(): void {
        console.log(`Loading settings in BACPaymentEntity`);
    }

    getAmountToPaid(details: any): number {
        console.log(`Getting amount to pay in BACPaymentEntity: ${details.amount}`);
        return details.amount;
    }
}

export default BACPaymentEntity;