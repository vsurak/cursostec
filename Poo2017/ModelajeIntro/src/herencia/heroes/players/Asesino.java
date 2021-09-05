package herencia.heroes.players;

import herencia.heroes.library.NivelHeroe;

public class Asesino extends Heroe 
{
	private boolean HasMachete;
	
	public Asesino()
	{
		super("dddd", NivelHeroe.KILLER); // llamando al constructor sin parametros de la classe Padre
		HasMachete = false;
	}

	public void sacarMacheteVenenoso()
	{
		HasMachete=true;
		System.out.println("sacarMachete , codigo en "+this.getClass().toString());
	}
	
	public void atacar() 
	{
		System.out.println("Ataca el Asesino");
	}	
}
