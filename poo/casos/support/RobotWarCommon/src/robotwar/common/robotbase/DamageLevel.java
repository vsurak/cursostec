package robotwar.common.robotbase;

public class DamageLevel {
	private double damageLevel;
	private boolean enabled;
	
	public DamageLevel() {
		this.damageLevel = 100.0;
		this.enabled = true;
	}

	public double getDamageLevel() {
		return damageLevel;
	}

	public void hitDamage(int pLevel) {
		// dado el nivel saco el % de daño, lo rebajo
		// evaluo si llegue a cero o menos, pongo el enabled en false
	}

	public boolean isEnabled() {
		return enabled;
	}
	
}
