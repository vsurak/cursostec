package sample.log;

import java.util.ArrayList;

public class Logger extends Thread {
	private ArrayList<String> logs;
	private Boolean isActive; 
	
	public Logger() {
		logs = new ArrayList<String>();
		isActive = true;
	}
	
	// sobre carga de operadores
	// es cuando un método o mensaje se llama exactamente igual
	// pero se distingue la implementación a usar por medio
	// del orden de los tipos de los parámetros
	public void log(String pDescription, LogType pType) {
		String loginfo = pType.toString() + "," + pDescription;
		logs.add(loginfo);
	}

	public void log(LogType pType, String pDescription) {
		log(pDescription, pType);
	}

	public void log(String pDescription, LogType pType, int timing) {
		String loginfo = pType.toString() + "," + pDescription;
		logs.add(loginfo);
	}
	
	public void log(LogType pyype,String yxa, int timing) {
		String loginfo = pyype.toString() + "," + yxa;
		logs.add(loginfo);
	}
	

	public void terminar() {
		isActive = false;
	}
	
	@Override
	public void run() {
		while (isActive) {
			try {
				Thread.sleep(500);
				if (logs.size()>0) {
					flushLogs();
				}
			} catch (Exception ex) {
				
			}
		}
	}

	
	@Override 
	public void finalize() {
		flushLogs();
	}
	
	private void flushLogs() {
		ArrayList<String> backup = logs;
		logs = new ArrayList<String>();
		// las paso a un file
		backup.clear();		
	}
}
