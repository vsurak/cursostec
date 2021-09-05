package listas.program;

import listas.*;
import listas.libreria.Posicion;
import listas.PosicionInsercion;

public class Program 
{
	public static void main(String args[])
	{
		Lista lista = new Lista();
		
		Nodo nuevo = new Nodo("Pedro", 10, Posicion.DEFENSA);
		lista.agregar(nuevo, PosicionInsercion.INICIO);
		
		nuevo = new Nodo("Juan", 15, Posicion.CENTRAL);
		lista.agregar(nuevo, PosicionInsercion.INICIO);
		
		nuevo = new Nodo("Mario", 15, Posicion.CENTRAL);
		lista.agregar(nuevo, PosicionInsercion.FINAL);

		nuevo = new Nodo("Messi", 15, Posicion.CENTRAL);
		lista.agregar(nuevo, PosicionInsercion.FINAL);
		
		nuevo = new Nodo("Jeremi", 15, Posicion.CENTRAL);
		lista.agregar(nuevo, PosicionInsercion.INICIO);
		
		for(int i=0; i<lista.longitud(); i++)
		{
			Nodo current = lista.getNodo(i);
			System.out.println(current.getPlayer().getNombre());
		}
		
		lista.Eliminar(nuevo);
		
		Nodo algo = new Nodo("dddd", 60, Posicion.DELANTERO);
		lista.Eliminar(algo);
		
	}
}
