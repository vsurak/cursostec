import AbstractPaymentType from './AbstractPaymentType';

class RequestPayment extends AbstractPaymentType {
    loadSettings(settings: any): void {
        console.log(`Loading settings in RequestPayment: ${JSON.stringify(settings)}`);
    }

    loadPaymentDetails(details: any): void {
        console.log(`Loading payment details in RequestPayment: ${JSON.stringify(details)}`);
    }

    executePayment(): void {
        var amount = this.entityToProcessPayment.getAmountToPaid(super.getPaymentDetails());
        this.entityToProcessPayment.pay(amount);
        console.log(`Executing payment for amount in RequestPayment: ${super.getPaymentDetails().amount}`);
        // Add logic to execute the payment
    }
}

