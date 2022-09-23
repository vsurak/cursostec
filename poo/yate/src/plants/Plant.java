package plants;

import plants.statuses.PlantStatus;

public class Plant {
	private String name;
	private int type;
	private PlantStatus currentState;
	private int life;
	private int createTime;
	
	private ArrayList<StatusChangeRule> listaDeReglas;
	private ArrayList<StatusChangeRule> reglas[] = new ArrayList<StatusChangeRule>[8];
	
	public int getTime() {
	
	}
	
	public int getTimeInDays() {
		
	}
	
	public void evaluate(int currentDays) {
		ArrayList<StatusChangeRule> rulesparamiestado = reglas[currentState.getId()];
		
		for(StatusChangeRule rule : rulesparamiestado) {
			if (rule.getMinAge()<=getTimeInDays() && rule.getMaxAge()>=getTimeInDays() && el valor de vida) {
				this.currentState = rule.getNextState();
				break;
			}
		}
	}
}
