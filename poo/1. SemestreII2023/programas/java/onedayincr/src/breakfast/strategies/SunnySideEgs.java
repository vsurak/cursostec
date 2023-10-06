package breakfast.strategies;

import java.util.Vector;
import breakfast.IEgs;

public class SunnySideEgs implements IEgs {

	@Override
	public void prepareEgs(Vector<String> pBreakFast) {
		System.out.println("Tirando dos huevos con aceite y sal dejando freir por un lado");
		pBreakFast.add("Dos huevos sonrientes por un lado amarillitos");
	}

}
