package heroes;

public abstract class AbstractPower {
	protected int damage;
	
	public abstract void attack();
	public abstract void stop();
	
	public int getDamage() {
		return this.damage;
	}
		
}
