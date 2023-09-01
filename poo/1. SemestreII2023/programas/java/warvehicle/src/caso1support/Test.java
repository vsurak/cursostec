package caso1support;

import java.util.Date;

public class Test {
	private Date hora;
	private ITask task;
	private Action action;
	
	public Test(Date pTime, ITask task, Action pAction) {
		this.hora = pTime;
		this.task = task;
		this.action = pAction;
	}

	public Date getHora() {
		return hora;
	}

	public ITask getTask() {
		return task;
	}

	public Action getAction() {
		return action;
	}
	
	
}
