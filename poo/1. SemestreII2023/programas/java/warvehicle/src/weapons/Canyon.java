package weapons;

public class Canyon extends Arma {
	private double angle;
	private int polvora;
	
	public Canyon() {
		super(1, 2000, Destruccion.ALTO, "Cañon fuerzas especiales de cartago");
		this.angle = 0.5;
	}
	
	public void ajustarAngulo(double level) {
		angle+=level;
	}
	
	public void cargarPolvora(int pPolvora) {
		polvora+=pPolvora;
	}
	
	public double getAngle() {
		return this.angle;
	}
}
