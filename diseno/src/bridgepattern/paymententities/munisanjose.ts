import AbstractPaymentEntity from './AbstractPaymentEntity';

class MuniSanJosepaymentEntity extends AbstractPaymentEntity {
    pay(amount: number): void {
        console.log(`Paying amount in Muni San JosePaymentEntity: ${amount}`);
    }

    loadSettings(): void {
        console.log(`Loading settings in Muni SJ PaymentEntity`);
    }

    getAmountToPaid(details: any): number {
        console.log(`Getting amount to pay in Muni SJ PaymentEntity: ${details.amount}`);
        return details.amount;
    }
}

export default MuniSanJosepaymentEntity;