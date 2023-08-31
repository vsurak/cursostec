package ticos;

import java.util.ArrayList;

import planner.Task;
import timer.Clock;

public abstract class Person {
	public ArrayList<String> tasks;
	
	public Person() {
		tasks = new ArrayList<String>();
		loadMyTasks();
	}
	
	public void process(Task pTask) {
		for(String task : tasks) {
			
			if (
				task.compareTo(pTask.getTaskname())==0 &&
				!pTask.isProcesada() &&
				Clock.getSecondsToNow(pTask.getTasktime())<=
				Clock.getSecondsToNow(Clock.getTime())
				) 
			{
				
				pTask.setProcesada(true);
				
				System.out.println(this.getClass().toString()+" haciedo tarea "+pTask.getTaskname());
			}
		}
	}
	
	protected abstract void loadMyTasks();
	
	public static void main(String args) {
		Person p1;
		//p1 = new Person(); las classes abstracts no se pueden crear
	}
}
