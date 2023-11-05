package dependency.example.payment;

import library.Order;

public class TiloPay implements IPaymentProcessor  {

	@Override
	public void pay(Order pOrder) {
		System.out.println("Connectando con TiloPay....");
		System.out.println("Se realizo el pagó de "+pOrder.getMonto());
	}

}
