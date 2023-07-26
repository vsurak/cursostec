package yate.energia;

public class PanelSolar {
	// por convención y estándares de programación en orientación en objetos
	// para todos los lenguajes OO, se busca que todos los atributos sean private
	// en su lugar se definen los getters y setters de los atributos que lo requieran
	
	private String modelo;
	private String brand;
	private boolean enabled;
	private float capacity;
	private float output;
	
	// constructor default
	public PanelSolar() {
		System.out.println("hola constructor default");
		this.capacity = 100.0f;
	}
	
	public PanelSolar(String pBrand, String pModel) {
		this();
		this.brand = pBrand;
		this.modelo = pModel;
	}
	
	public PanelSolar(String pBrand, String pModel, float pCapacity, boolean pEnabled) {
		this.brand = pBrand;
		this.modelo = pModel;
		this.enabled = pEnabled;
		this.capacity = pCapacity;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean pEnabled) {
		this.enabled = pEnabled;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float pCapacity) {
		this.capacity = pCapacity;
	}

	public float getOutput() {
		return output;
	}
}
