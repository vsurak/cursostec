package listas;

import listas.libreria.Jugador;
import listas.libreria.Posicion;

public class Nodo 
{
	private Jugador Player;
	private Nodo Siguiente;
	
	public Nodo(Jugador pJugador)
	{
		setPlayer(pJugador);
		this.Siguiente=null;
	}
	
	public Nodo(String pName, int pNumero, Posicion pPos)
	{
		Jugador jugador = new Jugador(pName, pNumero, pPos);
		setPlayer(jugador);
		this.Siguiente = null;
	}

	public Jugador getPlayer() {
		return Player;
	}

	public void setPlayer(Jugador player) {
		Player = player;
	}

	public Nodo getSiguiente() {
		return Siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		Siguiente = siguiente;
	}
	
	
	
}
