package breakfast.strategies;

import java.util.Vector;

import breakfast.ICoffee;

public class Chorreado implements ICoffee {

	@Override
	public void prepareCoffee(Vector<String> pBreakFast) {
		System.out.println("chorreando cafe en una media con mi abuelita");
		pBreakFast.add("Taza de café chorreado");
		
	}

}
