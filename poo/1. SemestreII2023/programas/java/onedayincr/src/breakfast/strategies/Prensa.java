package breakfast.strategies;

import java.util.Vector;

import breakfast.ICoffee;

public class Prensa implements ICoffee {

	@Override
	public void prepareCoffee(Vector<String> pBreakFast) {
		System.out.println("preparando por 5 minutos un delicioso cafe prensado");
		pBreakFast.add("Una prensa de cafe y su taza");
		
	}

}
