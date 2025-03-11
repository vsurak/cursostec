import BACPaymentEntity from "./paymententities/bac";
import FixPayment from "./paymenttypes/FixPayment";
import AbstractPaymentType from "./paymenttypes/AbstractPaymentType";

class Program {
    public static main(): void {
        console.log("Hello, Bridge Pattern!");

        const paymentEntity = new BACPaymentEntity();
        const paymentType = new FixPayment(paymentEntity);
        
        paymentType.loadSettings({});
        paymentType.loadPaymentDetails({});
        paymentType.executePayment();
    }
}

Program.main();