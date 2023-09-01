package caso1support;

public class TaskPatio implements ITask {
	ManagerPatio manager = new ManagerPatio();
	
	@Override
	public void execute(Action pAction) {
		if (pAction==Action.crecerCespedMucho) {
			manager.crecerCespedMucho();
		}
		if (pAction==Action.hacerSequia) {
			manager.hacerSequia();
		}
	}
}
