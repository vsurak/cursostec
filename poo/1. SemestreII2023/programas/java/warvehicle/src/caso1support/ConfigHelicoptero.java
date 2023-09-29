package caso1support;

public class ConfigHelicoptero {
	private int velocidadMax;
	private int temperaturaMin;
	
	private static ConfigHelicoptero instance;
	
	
	private ConfigHelicoptero() {
	}
	
	public static synchronized ConfigHelicoptero getInstance() {
		if (instance==null) {
			instance = new ConfigHelicoptero();
		}
		return instance;
	}
	
	//...
	public int getVelocidadMax() {
		return velocidadMax;
	}
	public void setVelocidadMax(int velocidadMax) {
		this.velocidadMax = velocidadMax;
	}
	public int getTemperaturaMin() {
		return temperaturaMin;
	}
	public void setTemperaturaMin(int temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}
}
