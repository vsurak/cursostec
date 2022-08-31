package inheritance.power;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Stove extends Thread {
	private final double KILOWATTSPERSECOND = 0.1;
	private int currentLevel = 0;
	private int totalSeconds = 40;
	private double totalConsume = 0.0;
	
	public Stove() {
	}
	
	public void setSimulationTime(int pMinutes, int pSeconds) {
		totalSeconds = pMinutes*60 + pSeconds;
	}
	
	public void addConsumeLevel(int pLevel) {
		this.currentLevel += pLevel;
	}
	
	public void run() {
		LocalTime currentTime = LocalTime.now();
		LocalTime endTime = currentTime.plusSeconds(totalSeconds);
		while (currentTime.isBefore(endTime)) {
			try {
				long secondspassed = currentTime.until(LocalTime.now(), ChronoUnit.SECONDS);
				currentTime = LocalTime.now();

				totalConsume += currentLevel * KILOWATTSPERSECOND * secondspassed;
				
				System.out.println("Stove consumo al momento: "+totalConsume);
				
				Thread.sleep(3000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Stove termina, consumo: "+totalConsume);
	}
}
