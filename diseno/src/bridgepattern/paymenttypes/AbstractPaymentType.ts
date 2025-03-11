import AbstractPaymentEntity from "../paymententities/AbstractPaymentEntity";

abstract class AbstractPaymentType {
    private settings: any;
    private paymentDetails: any;
    protected entityToProcessPayment: AbstractPaymentEntity ;

    constructor(entity: AbstractPaymentEntity) {
        this.settings = {};
        this.paymentDetails = {};
        this.entityToProcessPayment = entity;
    }

    abstract loadSettings(settings: any): void;

    abstract loadPaymentDetails(details: any): void;

    abstract executePayment(): void;

    protected getSettings(): any {
        return this.settings;
    }

    protected setSettings(settings: any): void {
        this.settings = settings;
    }

    protected getPaymentDetails(): any {
        return this.paymentDetails;
    }

    protected setPaymentDetails(details: any): void {
        this.paymentDetails = details;
    }
}

export default AbstractPaymentType;