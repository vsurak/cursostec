package plants.simulation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import plants.statuses.StatusManager;
import plants.utils.*;

public class Simulator extends Observable implements Runnable, IConstants {
	private LocalTime startedTime;
	private boolean running = false;
	private StatusManager plantManager;
	private int currentRain;
	private int currentTemperature;
	private LocalTime weatherLastUpdate;
	private int dayPass;
	
	
	public Simulator(StatusManager pManager) {
		this.plantManager = pManager;
	}
	
	@Override
	public void run() {
		startedTime = LocalTime.now();
		LocalDate currentTime;
		running = true;
		while (running) {
			try {

				//this.plantManager.evaluate(dayPass);				
				System.out.println("Han pasado "+dayPass+" dias");
				
				Thread.sleep(CHECKIN_TIME);
				dayPass = (int)ChronoUnit.MILLIS.between(startedTime, LocalTime.now()) / DAY_IN_MILLIS;
								
				SimulatorReport report = new SimulatorReport();
				report.action = UPDATE_DAYS;
				report.days = dayPass;
				
				this.notifyObservers(report);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	// el hilo que va recorriendo las reglas del clima, cuando genera un cambio en el clima me lo reporta por este método
	public void updateWeather(int pTemp, int pRain) {
		this.currentTemperature = pTemp;
		this.currentRain = pRain;
		this.weatherLastUpdate = LocalTime.now();
		
		SimulatorReport report = new SimulatorReport();
		report.action = UPDATE_WEATHER;
		report.rain = pRain;
		report.temperature = pTemp;
		report.days = dayPass;
		
		this.notifyObservers(report);
	}
	
	public void stop() {
		running = false;
	}

}
