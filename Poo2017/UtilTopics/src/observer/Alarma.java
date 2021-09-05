package observer;

import java.util.Observable;
import java.util.Observer;

public class Alarma implements Observer
{
	public Alarma()
	{
		
	}
	
	public void sonarAlarma()
	{
		System.out.println("Se activa la alarma");
	}

	@Override
	public void update(Observable objectAction, Object arg) {
		if (objectAction instanceof Puerta)
		{
			sonarAlarma();
		}
	}
}
