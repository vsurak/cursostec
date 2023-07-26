package inheritance.power;

public class Stove extends Appliance {
	private final double KILOWATTSPERSECOND = 0.1;
	
	public Stove() {
		super("Stove");
		this.kiloWattsPerSecondPerLevel = KILOWATTSPERSECOND;
	}
	
	public void setSimulationTime(int pMinutes, int pSeconds) {
		this.setSimulationTimeInSeconds(pMinutes*60 + pSeconds);
	}
}
