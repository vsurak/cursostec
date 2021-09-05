package listas.libreria;

public class Jugador 
{
	private String Nombre;
	private short Numero;
	private Posicion PosicionJugador;
	
	public Jugador(String pNombre, int pNumero, Posicion pPosicion)
	{
		this.Nombre= pNombre;
		this.Numero = (short)pNumero;
		this.PosicionJugador = pPosicion;
	}
	
	/*
	 * Getters and Setters
	 */
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public short getNumero() {
		return Numero;
	}
	public void setNumero(short numero) {
		Numero = numero;
	}
	public Posicion getPosicionJugador() {
		return PosicionJugador;
	}
	public void setPosicionJugador(Posicion posicionJugador) {
		PosicionJugador = posicionJugador;
	}
	
	
}
