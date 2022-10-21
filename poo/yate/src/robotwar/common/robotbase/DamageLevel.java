package robotwar.common.robotbase;

public class DamageLevel {
	private double level;
	private boolean enabled;
	
	public DamageLevel() {
		this.level = 100.0;
		this.enabled = true;
	}

	public double getLevel() {
		return level;
	}

	public void hitDamage(int pLevel) {
		// dado el nivel saco el % de daño, lo rebajo
		// evaluo si llegue a cero o menos, pongo el enabled en false
	}

	public boolean isEnabled() {
		return enabled;
	}
	
}
