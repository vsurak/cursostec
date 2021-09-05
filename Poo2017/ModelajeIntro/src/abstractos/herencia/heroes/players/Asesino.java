package abstractos.herencia.heroes.players;

import abstractos.herencia.heroes.library.NivelHeroe;

public class Asesino extends Heroe 
{
	private boolean HasMachete;
	
	public Asesino()
	{
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
	
	public void volar() 
	{
		System.out.println("Asesino vuela...oh si");
	}
}
