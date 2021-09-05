package usointerfaces;

import java.util.Random;

public class Program {

	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.agregarArticulo(new Carro());
		persona.agregarArticulo(new Computadora());
		persona.agregarArticulo(new Carro());
		persona.agregarArticulo(new Casa(383838.00));
		persona.agregarArticulo(new Remolque());
		persona.agregarArticulo(new Casa(238283.11));
		Remolque rem = new Remolque();
		Carro cr = new Carro();
		
		persona.agregarArticulo(rem);
		persona.agregarArticulo(cr);
		
		Random rand = new Random();
		
		ISellable articulo = persona.getArticulo(3);
		
		
	}

}
