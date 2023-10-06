package breakfast.strategies;

import java.util.Vector;

import breakfast.IEgs;

public class Omellete implements IEgs {

	@Override
	public void prepareEgs(Vector<String> pBreakFast) {
		System.out.println("Mezclando two egs con cilantro, cebolla y queso rayado");
		pBreakFast.add("Omellete con queso y especies");
	}

}
