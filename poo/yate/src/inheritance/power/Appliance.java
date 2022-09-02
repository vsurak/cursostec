package inheritance.power;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Appliance extends Thread {
	private int currentLevel = 1;
	private int simulationTimeInSeconds = 80;
	private double totalConsume = 0.0;
	private String applianceName;
	protected double kiloWattsPerSecondPerLevel = 0.0;
	
	public Appliance() {
		this("sin nombre");
	}
	
	public Appliance(String pName) {
		this.applianceName = pName;
	}
	
	public void setLevel(int pLevel) {
		this.currentLevel = pLevel;
	}
	
	public void addToLevel(int pIncrease) {
		this.currentLevel += pIncrease;
	}
	
	public void setSimulationTimeInSeconds(int pSeconds) {
		this.simulationTimeInSeconds = pSeconds; 
	}
	
	public void run() {
		LocalTime currentTime = LocalTime.now();
		LocalTime endTime = currentTime.plusSeconds(simulationTimeInSeconds);
		while (currentTime.isBefore(endTime)) {
			try {
				long secondspassed = currentTime.until(LocalTime.now(), ChronoUnit.SECONDS);
				currentTime = LocalTime.now();

				totalConsume += currentLevel * kiloWattsPerSecondPerLevel * secondspassed;
				
				System.out.println(applianceName+" consumo al momento: "+totalConsume);
				
				Thread.sleep(3000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(applianceName+" termina, consumo: "+totalConsume);		
	}
}
