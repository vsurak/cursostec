package planner;

import java.util.ArrayList;

import ticos.Person;
import ticos.Worker;

public class Scheduler {
	
	private ArrayList<Task> tasks;
	private ArrayList<Person> ticos;
	
	public Scheduler() {
		
		ticos = new ArrayList<Person>();
		
		Worker w1 = new Worker();
		ticos.add(w1);
		
		ScheduleParser parser = new ScheduleParser();
		tasks = parser.getTasks();
	}
	
	public void processTasks() {
		for(Task task: tasks) {
			for(Person tico: ticos) {
				tico.process(task);
			}			
		}
	}
}
