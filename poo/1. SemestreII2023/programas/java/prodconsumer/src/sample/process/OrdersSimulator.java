package sample.process;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import library.*;
import sample.consumers.OrderManager;
import sample.producers.MobileApp;
import sample.producers.ShopingCart;

public class OrdersSimulator implements Constants {
	private Queue<Order> orders;
	private OrderManager managers[] = new OrderManager[ORDER_MANAGERS];
	private MobileApp apps[] = new MobileApp[MOBILE_APPS];
	private ShopingCart carts[] = new ShopingCart[SHOPING_CARTS];
	
	public OrdersSimulator() {
		orders = new ConcurrentLinkedQueue<Order>();
		
		for(int count=0;count<ORDER_MANAGERS; count++) {
			managers[count] = new OrderManager(orders, count);
		}

		for(int count=0;count<MOBILE_APPS; count++) {
			apps[count] = new MobileApp(orders);
		}

		for(int count=0;count<SHOPING_CARTS; count++) {
			carts[count] = new ShopingCart(orders, count);
		}		
	}
	
	public void performMobileShoping() {
		for(int count=0;count<MOBILE_APPS; count++) {
			apps[count].createOrder();
		}		
	}
	
	public static void main(String args[]) {
		OrdersSimulator sim = new OrdersSimulator();
		sim.performMobileShoping();
	}
}
