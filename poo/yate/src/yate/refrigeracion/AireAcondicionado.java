package yate.refrigeracion;

public class AireAcondicionado {
	private short level;
	private String brand;
	private String model;
	private boolean enabled;
	private Modo modo;
	
	public short getLevel() {
		return level;
	}
	
	public void setLevel(short level) {
		this.level = level;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Modo getModo() {
		return modo;
	}
	
	public void setModo(Modo modo) {
		this.modo = modo;
	}
}
