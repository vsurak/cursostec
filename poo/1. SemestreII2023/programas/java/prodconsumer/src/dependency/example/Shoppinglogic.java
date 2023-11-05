package dependency.example;

import dependency.example.notificators.INotificator;
import dependency.example.payment.IPaymentProcessor;
import library.Order;

public class Shoppinglogic {
	/*
	 * El metodo processOrder para realizar toda la tarea tiene una dependencia con los
	 * procesos de pago y de envio de notificaciones
	 * dado que hay varias formas de pagar y varias formas de enviar la notificación
	 * no se hace que el método tenga la lógica del pago ni notificaciones,
	 * tampoco se le hace responsable por conocer las clases que saben hacer cada tipo de pago
	 * o cada tipo de notificacion; en su lugar, recibe esas dependencias
	 * por inyección, es decir, entra desde afuera como un parámetro por medio 
	 * de un interface que lo haga ser agnostico de la implementación
	 */
	public void processOrder(Order pOrder, IPaymentProcessor paymentMethod, INotificator pSender) {
		// aqui se realiza la lógica propiamente de procesar la orden
		// si hay que grabar o leer cosas de una base de datos se llama
		// a las clases de tipo repository que le acceden
		// cuando se necesario se ejecutan las lógicas inyectas
		paymentMethod.pay(pOrder);
		// y se sigue así sucesivamente
		pSender.notify(pOrder, "Hemos procesado su orden de compra correctamente, pronto recibirá los productos");
	}
}
