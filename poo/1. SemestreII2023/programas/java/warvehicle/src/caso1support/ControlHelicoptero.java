package caso1support;

public class ControlHelicoptero {
	
	
	private int velocidadActual;
	
	public ControlHelicoptero() {
	}
	
	public void incrementarVelocidad(int pIncremento) {
		if (this.velocidadActual+pIncremento<=ConfigHelicoptero.getInstance().getVelocidadMax()) {
			
		}
	}
	
	public void algo() {
	}
}
