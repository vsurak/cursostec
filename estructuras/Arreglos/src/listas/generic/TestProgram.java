package listas.generic;

import java.util.Random;
import listas.libreria.Jugador;
import java.util.Calendar;

public class TestProgram 
{
	public static void main(String args[])
	{
		Nodo<String> nuevo = new Nodo<String>();
		Nodo<Random> nuevo1 = new Nodo<Random>();
		Nodo<Integer>  nuevo2 = new Nodo<Integer>();
		
		Lista<String> miLista = new Lista<String>();
		Lista<Calendar> otraLista = new Lista<Calendar>();
		
		miLista.agregar(nuevo, PosicionInsercion.FINAL);
		
		Nodo<Jugador> algo = new Nodo<Jugador>();
		Jugador p = algo.getValue();
		
		
	}
}
