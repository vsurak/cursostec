package temasproyecto.poli;

public abstract class Vehiculo 
{
	private int Velocidad;
	private EstadoVehiculo Estado;
	private TipoCombustible Combustible;
	private int CantidadCombustible;
	
	public Vehiculo()
	{
		System.out.println("Constructor de Vehiculo");
		Estado = EstadoVehiculo.APAGADO;
		Velocidad = 0;
		CantidadCombustible = 100;
	}
	
	// Si la clase padre sabe que debe existir un metodo acelerar
	// pero la implementacion del metodo depende mucho de cada hijo
	// es decir cada hijo de la clase tiene un comportamiento muy diferente
	// de este mismo metodo
	// para ello dejamos el metodo abstracto
	// es decir no va a tener codigo, pero los hijos tienen que implementarlo
	public abstract void acelerar(int pVelocidad);
	
	public void frenar()
	{
		System.out.println("Codigo frenar en el padre. "+this.getClass().toString());
		Velocidad = 0;
		Estado = EstadoVehiculo.DETENIDO;
	}
	
	public void encender() {
		System.out.println("Codigo encender en el padre. "+this.getClass().toString());
		Velocidad = 0;
		Estado = EstadoVehiculo.ENCENDIDO;
	}
	
	public void apagar()
	{
		System.out.println("Codigo apagar en el padre. "+this.getClass().toString());
		Velocidad = 0;
		Estado = EstadoVehiculo.APAGADO;		
	}
}
