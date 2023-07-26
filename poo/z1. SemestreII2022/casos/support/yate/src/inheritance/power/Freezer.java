package inheritance.power;

public class Freezer extends Appliance {
	private final double kilowattsperminuteperlevel = 2.4;
	
	public Freezer() {
		super("Freezer");
		this.kiloWattsPerSecondPerLevel = kilowattsperminuteperlevel/60.0;
	}
	
	public Freezer(int pLevel, int pSimulationTime) {
		this();
		setLevel(pLevel);
		this.setSimulationTimeInSeconds(pSimulationTime);
	}
}
