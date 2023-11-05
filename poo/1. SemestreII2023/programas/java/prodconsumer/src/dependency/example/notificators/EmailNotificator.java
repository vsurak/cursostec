package dependency.example.notificators;

import library.Order;

public class EmailNotificator  implements INotificator {

	@Override
	public void notify(Order pOrder, String pMessage) {
		System.out.println("FROM: customerservice@shopping.cr");
		System.out.println("TO: miqueridocliente@gmail.com");
		System.out.println("Subject: Order "+pOrder.getOrderId()+ " va en camino");
		System.out.println(pMessage);
	}

}
