package modelaje;

public class Program 
{
	public static void main(String[] args) 
	{
		// crear una instancia
		// NombreClass nombreVariable = new metodoConstructor
		
		Semaforo semaforo1 = new Semaforo();
		
		System.out.println(semaforo1.getEstado());
		
		semaforo1.cambiarColor();
		System.out.println(semaforo1.getEstado());

		semaforo1.cambiarColor();
		System.out.println(semaforo1.getEstado());
		
		semaforo1.cambiarColor();
		System.out.println(semaforo1.getEstado());
		
		System.out.println(ColorSemaforos.AMARILLO.getValue());
		
		
		Semaforo2 sema = new Semaforo2();
		sema.setTiempoColor(ColorSemaforos.AMARILLO, (short)5);
		sema.setTiempoColor(ColorSemaforos.VERDE, (short)25);
		sema.setTiempoColor(ColorSemaforos.ROJO, (short)40);
		
		System.out.println(sema.getEstado().toString());
		sema.cambiarColor();
		System.out.println(sema.getEstado().toString());
		sema.cambiarColor();
		System.out.println(sema.getEstado().toString());
		sema.cambiarColor();
		System.out.println(sema.getEstado().toString());
		sema.cambiarColor();
		System.out.println(sema.getEstado().toString());
		

		
	}

}
