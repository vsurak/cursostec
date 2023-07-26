package yate.energia;

/*
 * declarar una classe
 * public se refiere a que esta definición de clase es pública por lo cual cualquier otra classe
 * la puede acceder
 */
public class Bateria {
	// atributos
	// <tipo de dato> <nombre del atributo> <opcionalmente lo puedo inicializar> ;
	// existen niveles de visibilidad entre los objetos
	// esto quiere decir la limitación que tiene un objeto de un tipo para 
	// acceder a la definición de un objeto de otro tipo
	// existen varios niveles de acceso o visibilidad entre objetos
	// public, private y protected
	// private declara que el objeto, el atributo o la accion solo puede ser visible en el lugar
	// donde fué declarado
	// por convención en java, normalmente se escriben primero todas las cosas publicas y después las privadas
	// por convención y estándares de programación en orientación en objetos
	// para todos los lenguajes OO, se busca que todos los atributos sean private
	// en su lugar se definen los getters y setters de los atributos que lo requieran
	public boolean enabled;

	private float energyLevel;
	private String brand; 
	private PanelSolar panel;
	private boolean charging = false;

	// acciones
	// <visiblidad> [modificadores]<tipo de retorno o void> <nombre verbo>([parámetros]) {} scopes del contexto
	
	
	public void encender() {
		enabled = true;
	}
	
	public void apagar() {
		this.enabled = false;
	}
	
	public float consumirEnergia(float pRequest) {
		float result = 0.0f;
		
		if (energyLevel>pRequest) {
			result = pRequest;
			energyLevel = energyLevel - pRequest;  // energyLevel-=pRequest;
		}
		
		return result;
	}

	public void setBrand(String pBrand) {
		this.brand = pBrand;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	private void alertBreakCircuit() {
		this.enabled = false;
	}
	
	public void conectarPanel(PanelSolar pPanel) {
		this.panel = pPanel;
	}
	
	public void detenerCarga() {
		charging = false;
	}
	
	public void cargarBateria() {
		if (this.panel!=null && this.panel.isEnabled()) {
			charging = true;
			int cuenta = 0;
			for(;charging;) {
				try {					
					energyLevel+=panel.getCapacity()/100.0f;
					Thread.sleep(1000); // esperar o dormir por un segundo, 1000 milliseconds
					System.out.println("Nivel actual de bateria "+energyLevel);
					
					cuenta++;  // codigo para hacer la prueba del capacity
					if (cuenta>10) {
						panel.setCapacity(75);
					}
					if (cuenta>20) {
						this.detenerCarga();
					}
				} 
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} else {
			System.out.println("No puedo cargar la batería porque no hay un panel conectado");
		}
	}
}
