package plants.statuses;

import plants.Plant;

public class StatusManager {
	private ArrayList<Plant> garden;
	// la lista de reglas de abono para todas los tipos de planta que viene del json
	// la lista de reglas de agua para todos los tipos de planta que viene del json
	// lo mismo para la temperatura...
	
	public void evaluate() {
		for(Plant currentPlant : garden) {
			currentPlant.evaluate();
		}		
	}
	
	public updateTemperature(int cantDays, int temperature) {
		// las reglas de temperatura sobre vida
		// recorro todas las plantas del jardin
	}

	public updateWater(int cantDays, int agua) {
		// las reglas de agua sobre vida
		// recorro todas las plantas del jardin
	}

	public updateAbono(int cantDays, int abono) {
		// las reglas de abono sobre vida
		// recorro todas las plantas del jardin
	}

}

