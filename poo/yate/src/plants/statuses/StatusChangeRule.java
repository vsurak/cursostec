package plants.statuses;

public class StatusChangeRule {
	private int minLife;
	private int maxLife;
	private int minDays;
	private int maxDays;
	private PlantStatus currentState; // si estoy en este estado y se cumple los valores en el rango de arriba paso sl siguiente estado
	private PlantStatus nextState;
	public int getMinLife() {
		return minLife;
	}
	public void setMinLife(int minLife) {
		this.minLife = minLife;
	}
	public int getMaxLife() {
		return maxLife;
	}
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
	public int getMinDays() {
		return minDays;
	}
	public void setMinDays(int minDays) {
		this.minDays = minDays;
	}
	public int getMaxDays() {
		return maxDays;
	}
	public void setMaxDays(int maxDays) {
		this.maxDays = maxDays;
	}
	public PlantStatus getCurrentState() {
		return currentState;
	}
	public void setCurrentState(PlantStatus currentState) {
		this.currentState = currentState;
	}
	public PlantStatus getNextState() {
		return nextState;
	}
	public void setNextState(PlantStatus nextState) {
		this.nextState = nextState;
	}
	
	
	
}
