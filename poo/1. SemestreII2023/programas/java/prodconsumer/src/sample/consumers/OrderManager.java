package sample.consumers;

import java.util.Queue;

import library.*;

public class OrderManager extends Thread implements Constants {
	private Queue<Order> ordersQueue;
	private boolean isActive = true;
	private int managerId;
	
	public OrderManager(Queue<Order> pOrdersQueue, int pManagerId) {
		ordersQueue = pOrdersQueue;
		managerId = pManagerId;
		this.start();
	}
	
	public void stopManager() {
		this.isActive = false;
	}
	
	public void run() {
		while (isActive) {
			try {
				Order currentOrder = ordersQueue.poll();
				if (currentOrder!=null) {
					System.out.println("Manager "+this.managerId+" procesando la orden numero "+currentOrder.getOrderId());
				}
				Thread.sleep(THREAD_RELAX);
			} catch (Exception ex) {
				
			}
		}
	}
}
