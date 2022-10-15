package plants.statuses;

import java.util.ArrayList;

import plants.Plant;
import plants.simulation.SimulatorReport;
import plants.utils.*;

public class StatusManager implements IObserver, IConstants {
	private ArrayList<Plant> garden;
	
	public StatusManager() {
		garden = new ArrayList<Plant>();
		garden.add(new Plant(1));
	}
	// la lista de reglas de abono para todas los tipos de planta que viene del json
	// la lista de reglas de agua para todos los tipos de planta que viene del json
	// lo mismo para la temperatura...
	
	public void evaluate(int pCurrentDays) {
		for(Plant currentPlant : garden) {
			currentPlant.evaluate(pCurrentDays);
		}		
	}
	
	public void updateTemperature(int cantDays, int temperature) {
		System.out.println("actualizando temp");
	}

	public void updateWater(int cantDays, int agua) {
		System.out.println("actualizando lluvia");
		// las reglas de agua sobre vida
		// recorro todas las plantas del jardin
	}

	public void updateAbono(int cantDays, int abono) {
		// las reglas de abono sobre vida
		// recorro todas las plantas del jardin
	}

	@Override
	public void update(Observable o, Object arg) {
		//SimulatorReport simReport = (SimulatorReport)arg;
		SimulatorReport simReport = (SimulatorReport)(Object)o;
		if (simReport.action.compareTo(UPDATE_DAYS)==0) {
			evaluate(simReport.days);
		}
		if (simReport.action.compareTo(UPDATE_WEATHER)==0) {
			updateTemperature(simReport.days, simReport.temperature);
			updateWater(simReport.days, simReport.rain);
		}
		
	}
}

