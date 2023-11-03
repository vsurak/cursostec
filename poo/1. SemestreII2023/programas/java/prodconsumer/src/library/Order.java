package library;

import java.util.UUID;

public class Order {
	private UUID orderId;
	
	public Order() {
		orderId = UUID.randomUUID();
	}
	
	public String getOrderId() {
		return orderId.toString();
	}
}
