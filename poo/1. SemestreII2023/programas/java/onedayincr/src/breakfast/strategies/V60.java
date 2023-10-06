package breakfast.strategies;

import java.util.Vector;

import breakfast.ICoffee;

public class V60 implements ICoffee {

	@Override
	public void prepareCoffee(Vector<String> pBreakFast) {
		System.out.println("Poniendo el v60 en la tasa y chorreando");
		pBreakFast.add("Una taza de cafe negro en v60");
	}

}
