package dependency.example;

import dependency.example.notificators.EmailNotificator;
import dependency.example.payment.Paypal;
import library.Order;

public class Caller {
	// el Caller se refiere a cualquier clase, servicio que tenga que hacer uso de la
	// logica y que ha pasado por algún proceso previo de forma que conoce las 
	// las dependencias que se le van a inyectar a la lógica 
	
	public static void main(String args[]) {
		Shoppinglogic shopLogic = new Shoppinglogic();
		Paypal paymentProcessor = new Paypal();
		EmailNotificator mailer = new EmailNotificator();
	
		Order compra = new Order();
		
		shopLogic.processOrder(compra, paymentProcessor, mailer);
	}
}
