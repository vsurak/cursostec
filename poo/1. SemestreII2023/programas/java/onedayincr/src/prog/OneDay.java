package prog;

import planner.Scheduler;
import timer.Clock;

public class OneDay {

	public static void main(String[] args) {
		Scheduler myscheduler = new Scheduler();
		Clock hiloControl = new Clock(myscheduler);
		hiloControl.start();
	}

}
