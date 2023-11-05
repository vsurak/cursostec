package dependency.example.payment;

import library.Order;

public interface IPaymentProcessor {
	public void pay(Order pOrder);
}
