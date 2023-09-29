package ticos;

public class Worker extends Person {

	public Worker() {
		super();
	}
	
	@Override
	protected void loadMyTasks() {
		tasks.add("levantarse");
		tasks.add("trabajar");
		tasks.add("comer");
		tasks.add("descansar");
	}
}
