import AbstractPaymentType from './AbstractPaymentType';

class FixPayment extends AbstractPaymentType {
    loadSettings(settings: any): void {
        console.log(`Loading settings  in FixPayment: ${JSON.stringify(settings)}`);
    }

    loadPaymentDetails(details: any): void {
        console.log(`Loading payment details   in FixPayment: ${JSON.stringify(details)}`);
    }

    executePayment(): void {
        this.entityToProcessPayment.pay(super.getPaymentDetails().amount);
        console.log(`Executing payment for amount   in FixPayment: ${super.getPaymentDetails().amount}`);
        // Add logic to execute the payment
    }
}

export default FixPayment;
