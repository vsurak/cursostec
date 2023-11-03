package sample.producers;

import java.util.Queue;

import library.Order;

public class MobileApp {
	private Queue<Order> orders;
	
	public MobileApp(Queue<Order> pOrdersQueue) {
		this.orders = pOrdersQueue;
	}
	
	public void createOrder() {
		Order newOrder = new Order();
		this.orders.add(newOrder);
		System.out.println("Order "+newOrder.getOrderId()+" generada desde un mobile app");
	}
}
