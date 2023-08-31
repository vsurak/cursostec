package ticos;

public class Student extends Person {
	
	public Student() {
		
	}
	
	@Override
	protected void loadMyTasks() {
		tasks.add("levantarse");
		tasks.add("clases");
		tasks.add("comer");
		tasks.add("tareas");
		tasks.add("fiesta");
		tasks.add("deporte");
	}

	public static void main(String args[]) {
		Student st = new Student();
		System.out.println(st.tasks.get(3));
	}
} 
