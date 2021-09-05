package observer;

import java.util.Observable;

public class Puerta extends Observable
{
	public Puerta()
	{
		
	}
	
	public void abrirApertura()
	{
		System.out.println("Abriendo la puerta");
		setChanged();
		this.notifyObservers(null);
	}
}
