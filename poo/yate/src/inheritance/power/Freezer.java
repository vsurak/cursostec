package inheritance.power;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Freezer extends Thread {
	private final double kilowattsperminuteperlevel = 2.4;
	private int currentLevel = 1;
	private int simulationTimeInSeconds = 80;
	private double totalConsume = 0.0;
	
	public Freezer(int pLevel, int pSimulationTime) {
		currentLevel = pLevel;
		simulationTimeInSeconds = pSimulationTime;
	}
	
	public void setFreezerLevel(int pLevel) {
		this.currentLevel = pLevel;
	}
	
	public void run() {
		LocalTime currentTime = LocalTime.now();
		LocalTime endTime = currentTime.plusSeconds(simulationTimeInSeconds);
		while (currentTime.isBefore(endTime)) {
			try {
				long secondspassed = currentTime.until(LocalTime.now(), ChronoUnit.SECONDS);
				currentTime = LocalTime.now();
				
				double minutespassed = secondspassed / 60.0;
				
				totalConsume += currentLevel * kilowattsperminuteperlevel * minutespassed;
				
				System.out.println("Freezer consumo al momento: "+totalConsume);
				
				Thread.sleep(5000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Freezer termina, consumo: "+totalConsume);
	}
}
