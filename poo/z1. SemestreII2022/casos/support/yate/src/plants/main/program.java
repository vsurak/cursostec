package plants.main;

import plants.simulation.Simulator;
import plants.statuses.StatusManager;
import plants.utils.Constants;
import plants.utils.IConstants;

public class program {
	public static void main(String args[]) {
		Constants.VALOR_CONSTANTE = 100;
		try {
			StatusManager manager = new StatusManager();
			Simulator sim = new Simulator(manager);
			
			sim.addObserver(manager);
			
			Thread simThread = new Thread(sim);
			simThread.start();
			
			sim.updateWeather(50, 10);
					
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			// que voy hacer cuando se cae...
		}
		finally {
			System.out.println("Luego de una excepcion el código brinca al finally si o si, el finally es opcional");
		}
	}
}
