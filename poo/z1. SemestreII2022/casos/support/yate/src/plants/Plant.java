package plants;

import plants.statuses.PlantStatus;
import plants.statuses.StatusChangeRule;
import plants.utils.IConstants;

import java.time.LocalDate;
import java.util.*;

public class Plant implements IConstants {
	private String name;
	private int type;
	private PlantStatus currentState;
	private int life;
	private int ageDays;
	private ArrayList<StatusChangeRule> reglas[];
	
	public Plant(int pType) {
		type = pType;
	}
	
	public int getAgeinDays() {
		return ageDays;
	}
	
	public int getTimeInYears() {
		return ageDays/DAYS_IN_YEARS;
	}
	
	public void evaluate(int currentDays) {
		//ArrayList<StatusChangeRule> rulesparamiestado = reglas[currentState.getId()];

		System.out.println("Evaluating plant type :"+ this.type);
		/*for(StatusChangeRule rule : rulesparamiestado) {
			if (rule.getMinDays()<=getAgeinDays() && rule.getMaxDays()>=getAgeinDays()) {
				this.currentState = rule.getNextState();
				break;
			}
		}*/
	}
}
