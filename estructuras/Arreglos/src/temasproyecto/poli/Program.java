package temasproyecto.poli;

import java.awt.Color;
import java.util.*;

public class Program 
{
	public static void main(String args[])
	{
		Carro c1 = new Carro(true, Color.BLACK, 5);
		Bote bote1 = new Bote();
		Avion av1 = new Avion(2, 100);
		
		c1.apagar();
		bote1.apagar();
		av1.apagar();
		
		bote1.frenar();
		c1.frenar();
		av1.frenar();
		
		// Vehiculo vh = new Vehiculo(); no se pueden instanciar clases abstractas 
		// vh.acelerar(100);
		
		Bote bote2 = new Bote();
		Vehiculo vh2 = bote2;
		
		Vehiculo vh3 = new Avion(6,200);
		
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		Vehiculo[] arregloVehiculos = new Vehiculo[30];
		
		listaVehiculos.add(new Avion(4,50));
		listaVehiculos.add(new Carro(true, Color.BLUE, 4));
		listaVehiculos.add(new Carro(false, Color.CYAN, 5));
		listaVehiculos.add(new Avion(2,150));
		listaVehiculos.add(new Bote());
		
		for (Vehiculo vehiculo : listaVehiculos) {
			vehiculo.acelerar(1000);
		}
		
		
	}
}
