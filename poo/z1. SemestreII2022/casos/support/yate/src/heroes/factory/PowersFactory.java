package heroes.factory;

import heroes.*;

public class PowersFactory {
	private static String packageName = "heroes.";

	public static AbstractPower create(String pPower ) {
		AbstractPower result = null;
		if (pPower.compareTo("Magnetismo")==0) {
			result = new Magnetismo();
		}
		if (pPower.compareTo("SuperFuerza")==0) {
			result = new SuperFuerza();
		}
		if (pPower.compareTo("Trueno")==0) {
			result = new Trueno();
		}
		
		return result;
	}

	public static AbstractPower createDinamico(String pPower ) {
		AbstractPower result = null;

		try {
			String className = packageName+pPower;
			result = (AbstractPower)Class.forName(className).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			result = new SuperFuerza();
		}
		
		return result;
	}

}
