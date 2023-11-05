package dependency.example.payment;

import library.Order;

public class Paypal implements IPaymentProcessor {

	@Override
	public void pay(Order pOrder) {
		System.out.println("Conectado a red estadounidense paypal....");
		System.out.println("Payment succesful "+pOrder.getMonto());
	}

}
