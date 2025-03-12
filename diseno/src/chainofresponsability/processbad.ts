class ProcessBad {
    pay(): void {
        console.log("Payment processed.");
    }

    processPaymentRequest(): void {
        this.validateOrder();
        this.validateAmounts();
        this.buildDescription();
        this.pay();
    }

    validateAmounts(): void {
        console.log("Validating amounts.");
    }

    validateOrder(): void {
        console.log("Validating order.");
    }

    buildDescription(): void {
        console.log("Building description.");
    }
}

const process = new ProcessBad();
process.processPaymentRequest();