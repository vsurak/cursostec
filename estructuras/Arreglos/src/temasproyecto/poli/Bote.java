package temasproyecto.poli;

public class Bote extends Vehiculo
{
	private int Capacidad;
	private int TiempoEnAltaMar;

	public int getCapacidad() {
		return Capacidad;
	}

	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
	}

	public int getTiempoEnAltaMar() {
		return TiempoEnAltaMar;
	}

	public void setTiempoEnAltaMar(int tiempoEnAltaMar) {
		TiempoEnAltaMar = tiempoEnAltaMar;
	}
	
	public void anclar()
	{
		frenar();
		System.out.println("Tirar el ancla");
	}
	
	public void acelerar(int pVelocidad)
	{
		System.out.println("Metodo acelerar en Bote");
	}
	
}
