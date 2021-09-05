package slot.gui;

import slot.logic.*;

public class VentanaJuego 
{

	public static void main(String args[])
	{
		SlotMachine machine = new SlotMachine();
		machine.setCreditosToPlay(1);
		machine.spin();
		machine.calcularCreditos();

		machine.spin();
		machine.calcularCreditos();

		machine.spin();
		machine.calcularCreditos();
		machine.setCreditosToPlay(2);

		for(int i=0;i<1000; i++) 
		{
			machine.spin();
			machine.calcularCreditos();
		}
		
	}
}
