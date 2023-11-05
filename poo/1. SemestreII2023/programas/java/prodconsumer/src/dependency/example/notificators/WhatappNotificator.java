package dependency.example.notificators;

import library.Order;

public class WhatappNotificator implements INotificator {

	@Override
	public void notify(Order pOrder, String pMessage) {
		System.out.println("WHATSAPP");
		System.out.println("=====================");
		System.out.println("Order "+pOrder.getOrderId()+ " va en camino");
		System.out.println(pMessage);
	}

}
