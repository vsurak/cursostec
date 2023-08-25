package weapons;

public class Arco extends Arma {
	private int tensionLevel;
	
	public Arco() {
		super(20, 200, Destruccion.BAJO, "Arco de legolas");
	}
	
	public void tensar() {
		this.tensionLevel++;
		System.out.println("Tensando arco");
	}
	
	public int gettensionLevel() {
		return tensionLevel;
	}
}
