package sample.producers;

import java.util.Queue;

import library.Constants;
import library.Order;

public class ShopingCart extends Thread implements Constants{
	private Queue<Order> ordersQueue;
	private boolean isActive = true;
	private int cartId;
	
	public ShopingCart(Queue<Order> pOrdersQueue, int pCartId) {
		ordersQueue = pOrdersQueue;
		cartId = pCartId;
		this.start();
	}
	
	public void stopManager() {
		this.isActive = false;
	}
	
	public void run() {
		while (isActive) {
			try {
				Order newOrder = new Order();
				ordersQueue.add(newOrder);

				System.out.println("ShopingCart active "+this.cartId+" creando la orden numero "+newOrder.getOrderId());
				Thread.sleep(THREAD_PRODUCERS_WAIT);
			} catch (Exception ex) {
				
			}
		}
	}
}
