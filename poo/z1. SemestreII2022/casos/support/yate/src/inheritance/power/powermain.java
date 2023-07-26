package inheritance.power;

public class powermain {

	// 1. Existen multiples tipos de dispositivos que consumen energía, 
	// se quiere simular durante un periodo de tiempo en segundos dicho consumo.
	// cada dispositivo posee su propio nivel de consumo y velocidad de consumo segun el
	// nivel, el cual puede cambiar en el tiempo durante la simulación
	public static void main(String[] args) {
		Freezer refri = new Freezer(2, 60);
		
		Stove horno = new Stove();
		horno.setSimulationTime(0, 30);
		horno.addToLevel(1);
		
		refri.start();
		horno.start();
		
		try {
			System.out.println("waiting for input to continue");
			System.in.read();
			System.out.println("Continua");
			
			refri.setLevel(4);
			horno.addToLevel(2);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
