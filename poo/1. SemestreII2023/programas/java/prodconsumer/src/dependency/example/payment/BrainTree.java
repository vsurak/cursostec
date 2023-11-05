package dependency.example.payment;

import library.Order;

public class BrainTree implements IPaymentProcessor {

	@Override
	public void pay(Order pOrder) {
		System.out.println("BrainTree payment....");
		System.out.println("Payment completed "+pOrder.getMonto());
	}

}
