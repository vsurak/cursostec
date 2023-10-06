package breakfast.strategies;

import java.util.Vector;
import breakfast.IEgs;

public class ScrambleEgs implements IEgs {

	@Override
	public void prepareEgs(Vector<String> pBreakFast) {
		System.out.println("Mezclando two egs con sal y revolviendo");
		pBreakFast.add("Huevos revueltos");
	}

}
