package heroes;

public class Trueno extends AbstractPower {

	public Trueno() {
		this.damage = 50;
	}
	
	@Override
	public void attack() {
		System.out.println("ataco con poder "+this.getDamage());
	}

	@Override
	public void stop() {
		System.out.println("deteniendo el trueno");
	}

	public void sonidoTrueno() {
		System.out.println("bruuum puuum paaaam");
	}
}
