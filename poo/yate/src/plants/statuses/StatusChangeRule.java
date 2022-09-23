package plants.statuses;

public class StatusChangeRule {
	private int minLife;
	private int maxLife;
	private int minDays;
	private int maxDays;
	private PlantStatus currentState; // si estoy en este estado y se cumple los valores en el rango de arriba paso sl siguiente estado
	private PlantStatus nextState;
	
}
