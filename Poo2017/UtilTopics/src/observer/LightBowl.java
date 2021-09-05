package observer;

import java.util.Observable;
import java.util.Observer;

public class LightBowl implements Observer
{

	public LightBowl()
	{
		
	}
	
	public void encender()
	{
		System.out.println("Se enciende luz de emergencia");
	}

	@Override
	public void update(Observable objectAction, Object arg) {
		if (objectAction instanceof Puerta)
		{		
			encender();
		}
	}
}
