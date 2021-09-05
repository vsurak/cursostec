package temasproyecto.poli;

public class Avion extends Vehiculo
{
	private int CantidadTurbinas;
	private int CantidadPasajeros;
	
	public Avion(int pTurbinas, int pPasajeros)
	{
		CantidadTurbinas = pTurbinas;
		CantidadPasajeros = pPasajeros;
	}
	
	
	public void despegar()
	{
		encender();
		acelerar(1000);
	}
	
	public void aterrizar()
	{
		acelerar(-900);
		System.out.println("Avion aterriza");
	}
	
	public void frenar()
	{
		System.out.println("Este es el metodo frenar de Avion");
		super.frenar(); // sobre escribir el metodo del padre pero si quiero llamar en 
		// en el momento que quiera al codigo del padre
	}
	
	public void acelerar(int pVelocidad)
	{
		System.out.println("Metodo acelerar en Avion");
	}
	
}
