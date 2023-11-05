package library;

import java.util.UUID;

public class Order {
	private UUID orderId;
	private double monto;
	
	public Order() {
		orderId = UUID.randomUUID();
		monto = 28000.00;
	}
	
	public String getOrderId() {
		return orderId.toString();
	}
	
	public double getMonto() {
		return monto;
	}
}
