package breakfast;

import java.util.Vector;

import breakfast.payments.Sinpe;
import breakfast.strategies.*;

public class BreakFastMaker {
	private ICoffee coffeMaker;
	private IEgs egsMaker;
	private Vector<String> breakfast;
	private IPayprocessor payment;
	private double monto;
	
	public BreakFastMaker(ICoffee pCoffeeMaker, IEgs pEgsMaker, IPayprocessor pProcessor) {
		this.coffeMaker = pCoffeeMaker;
		this.egsMaker = pEgsMaker;
		breakfast = new Vector<String>();
		payment = pProcessor;
	}
	
	
	public void setCoffeMaker(ICoffee coffeMaker) {
		this.coffeMaker = coffeMaker;
	}

	public void setEgsMaker(IEgs egsMaker) {
		this.egsMaker = egsMaker;
	}

	public String prepareBreakFast() {
		breakfast.clear();
		StringBuilder result = new StringBuilder();
		coffeMaker.prepareCoffee(breakfast);
		makeJuice();
		makeBeacon();
		egsMaker.prepareEgs(breakfast);
		addFruits();
		
		breakfast.forEach((String ingredient) -> result.append(ingredient+" // "));
		return result.toString();
	}
	
	private void makeJuice() {
		System.out.println("Making Juice");
		breakfast.add("Jugo de naranja");
	}

	private void makeBeacon() {
		System.out.println("Fried the bacon");
		breakfast.add("Three bacon strips");
	}
	
	private void addFruits() {
		System.out.println("Agregando las frutas");
		breakfast.add("agregando 3 piezas de manzana");
		breakfast.add("agregando 4 piezas de naranja");
		breakfast.add("agregando 1 pieza de banano");
	}
	
	public void payBreakFast() {
		payment.pay(monto);
	}
	
	public static void main(String[] args) {
		
		// ya se que van a querer cafe chorreado y omellete
		BreakFastMaker maker = new BreakFastMaker(new Chorreado(), new Omellete(), new Sinpe());
		// el prepareBreakFast es mi operacion
		// pero requiere la inyección de dos implementación
		System.out.println(maker.prepareBreakFast());
		maker.payBreakFast();
		
		maker.setEgsMaker(new SunnySideEgs());
		System.out.println(maker.prepareBreakFast());

	}

}
