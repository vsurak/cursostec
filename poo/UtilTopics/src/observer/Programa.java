package observer;

public class Programa {

	public static void main(String[] args) {
		Puerta puerta = new Puerta();
		Alarma al = new Alarma();
		LightBowl light = new LightBowl();
		
		puerta.addObserver(al);
		puerta.addObserver(light);
		
		puerta.abrirApertura();
	}

}
