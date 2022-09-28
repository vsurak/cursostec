package plants.main;

import plants.simulation.Simulator;
import plants.statuses.StatusManager;

public class program {
	public static void main(String args[]) {
		StatusManager manager = new StatusManager();
		Simulator sim = new Simulator(manager);
		
		sim.addObserver(manager);
		
		Thread simThread = new Thread(sim);
		simThread.start();
		
		sim.updateWeather(50, 10);
	}
}
