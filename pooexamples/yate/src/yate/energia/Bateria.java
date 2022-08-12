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
	// por convención en java, normalmente se escriben primero todas las cosas privadas y después las públicas
	private float energyLevel;
	private String brand; 

	public boolean enabled;

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
}
