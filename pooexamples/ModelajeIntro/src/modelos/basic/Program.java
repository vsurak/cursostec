package modelos.basic;

public class Program 
{
	public static void main(String argsp[])
	{
		Radio radio1 = new Radio();
		Radio radio2 = new Radio();
		Radio radio3;
		
		/// lo siguiente no es posible, daria un null pointer exception porque
		/// radio3 no ha sido inicializado, no tiene vida, no posee espacio en memoria
		/// no es instancia aun, por ende no puedo hacer nada
		//radio3.decrementarFrecuencia();
		//radio3.getVolumen();
		
		radio1.setVolumen((short)10);
		radio2.setVolumen((short)35);
		
		System.out.println("Volumen Radio1: "+radio1.getVolumen());
		System.out.println("Volumen Radio2: "+radio2.getVolumen());
		
		radio2 = radio1; // radio2 pasa a apuntar a radio1, entre objetos se trabaja por referencias, es decir direcciones de memoria
		// ahora ambos apuntan a la misma instancia usando dos variables distintas
		// la instancia, o bien espacio de memoria, que se habia reservado al inicio
		// apuntada por la variable radio2, ahora quedo perdida en memoria imposible de acceder
		
		// dado que ambas variables apuntan al mismo espacio de memoria veo el mismo valor
		System.out.println("Volumen Radio1: "+radio1.getVolumen());
		System.out.println("Volumen Radio2: "+radio2.getVolumen());
		
		System.out.println("-----------------------------------");
		Radio radio4 = new Radio();
		Radio radio5 = new Radio((short)60, 206.8f);
		System.out.println("Frecuencia radio4: "+radio4.getFrecuencia());
		System.out.println("Frecuencia radio5: "+radio5.getFrecuencia());

	}
}
