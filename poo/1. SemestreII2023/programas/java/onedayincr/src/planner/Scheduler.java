package planner;

import java.util.ArrayList;

import ticos.Person;
import ticos.Worker;

public class Scheduler implements AutoCloseable {
	
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
		for(Task task: tasks) {  // falta mejorar, preguntarle al profe por reflexion, tip: ClassforName
			for(Person tico: ticos) {
				tico.process(task);
			}			
		}
	}

	@Override
	public void close() throws Exception {
		tasks.clear();
		ticos.clear();
	}
	
}
