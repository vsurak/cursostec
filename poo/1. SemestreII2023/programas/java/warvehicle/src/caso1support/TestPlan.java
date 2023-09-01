package caso1support;

import java.util.Date;
import java.util.ArrayList;

public class TestPlan extends Thread {
	private ArrayList<Test> listatest = new ArrayList<Test>();
	private TaskPatio patioManager;
	
	public TestPlan() {
		listatest = new ArrayList<Test>();
		patioManager = new TaskPatio();
	}
	
	public void loadTests() {
		// 06:00
		listatest.add(new Test(new Date(), patioManager, Action.crecerCespedMucho));
		listatest.add(new Test(new Date(), patioManager, Action.mandarPlagasdeEgipt));
		
		// 06:30
		//test.add(new Test(new Date(), devicesManager, Action.quitarElectricidad));
	}
	
	public void run() {
		// recorriendo la lista de pruebas 
		for (Test test : listatest) {
			// if para ver si ya es hora para mandar la prueba test.time
			test.getTask().execute(test.getAction());
		}
	}
}
