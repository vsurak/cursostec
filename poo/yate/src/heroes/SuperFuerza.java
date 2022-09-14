package heroes;

public class SuperFuerza extends AbstractPower {

	public SuperFuerza() {
		this.damage = 20;
	}
	
	@Override
	public void attack() {
		System.out.println("ataco con poder "+this.getDamage());
	}

	@Override
	public void stop() {
		System.out.println("deteniendo golpes con superfuerza");
	}

}
